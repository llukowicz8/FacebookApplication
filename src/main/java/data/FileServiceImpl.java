package data;


import model.Facebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileServiceImpl implements FileService {

    private Parser parser;


    FileServiceImpl(Parser parser){
        this.parser = parser;


    }

    public List<Facebook> readFile(String path) {
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            return stream.map(line->parser.parseObject(line)).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }



}
