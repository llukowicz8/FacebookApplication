package service;


import data.Repository;
import exception.NotFoundException;
import model.Facebook;

import java.util.Map;
import java.util.Set;

public class FacebookServiceImpl implements FacebookService {

    Repository repository = Repository.getInstance();

    @Override
    public Facebook findById(String id) throws NotFoundException {
        return repository.findById(id);
    }

    @Override
    public Map<String, Long> findMostCommonWords() {

        return repository.findMostCommonWords();
    }

    @Override
    public Set<String> findPostIdsByKeyword(String word) {
        return repository.findPostIdsByKeyWord(word);
    }

    @Override
    public Set<Facebook> findAll() {
      return repository.findAll();
    }
}
