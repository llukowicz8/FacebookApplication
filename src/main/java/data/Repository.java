package data;


import exception.NotFoundException;
import model.Facebook;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repository {


    private static List<Facebook> facebookAccounts;

    private static FileService fileService;

    private static Repository instance;



    private Repository(FileService fileService) {
        this.fileService = fileService;

    }

    public static Repository getInstance(String... path) {
        if (instance == null) {
            synchronized (Repository.class) {
                if (instance == null) {
                    fileService = new FileServiceImpl(new ParserImpl());
                    instance = new Repository(fileService);
                    facebookAccounts = fileService.readFile(path[0]);
                    Collections.sort(facebookAccounts);

                }
            }
        }
        return instance;
    }

    public List<Facebook> getFacebookAccounts() {
        return facebookAccounts;
    }


    public Facebook findById(String id) throws NotFoundException {

        Facebook searchedFacebook = new Facebook();
        searchedFacebook.setId(id);
        int indexOfObject = Collections.binarySearch(facebookAccounts, searchedFacebook);
        if (indexOfObject < 0) {
            throw new NotFoundException("ID : " + id + " NOT FOUND");

        }

        return facebookAccounts.get(indexOfObject);
    }

    public Map<String, Long> findMostCommonWords() {
        Map<String, Long> wordMaps = new HashMap<>();
        List<String> allPosts = new ArrayList<>();
        facebookAccounts.stream().forEach(fbAcc -> fbAcc.getPosts().forEach(post -> allPosts.add(post.getMessage())));
        allPosts.stream().forEach(msg ->
                {
                    Pattern pattern = Pattern.compile("([a-zA-Z']{2,})");
                    Matcher matcher = pattern.matcher(msg);

                    while (matcher.find()) {
                        String word = matcher.group();
                        word = word.toLowerCase();
                        if (wordMaps.containsKey(word)) {
                            Long count = wordMaps.get(word);
                            ++count;
                            wordMaps.put(word.toLowerCase(), count);
                        } else {
                            wordMaps.put(word.toLowerCase(), Long.valueOf(1));
                        }

                    }


                }
        );

        return wordMaps;
    }


    public Set<String> findPostIdsByKeyWord(String word) {
        Set<String> ids = new HashSet<>();

        facebookAccounts.stream().forEach(fbacc -> fbacc.getPosts().forEach(post -> {
            if (post.getMessage().toLowerCase().matches("[\\w\\W'\\s]*" + word.toLowerCase() + "[\\w\\W\\s]*")) {
                ids.add(post.getId());
            }
        }));

        return ids;
    }

    public Set<Facebook> findAll() {
        SortedSet<Facebook> setStrings = new TreeSet<>((s1, s2) -> s1.getFirstname().compareToIgnoreCase(s2.getFirstname()) != 0 ? s1.getFirstname().compareToIgnoreCase(s2.getFirstname()) : s1.getLastname().compareToIgnoreCase(s2.getLastname()));
        setStrings.addAll(facebookAccounts);
        return setStrings;
    }
}






