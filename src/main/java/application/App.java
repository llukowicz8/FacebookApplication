package application;

import data.DataInitializer;
import exception.NotFoundException;
import model.Facebook;
import service.FacebookService;
import service.FacebookServiceImpl;

import java.util.Map;
import java.util.Set;

//pl.application.facebook
public class App 
{
    public static void main( String[] args )
    {
        //inicjacja  danych
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.initializeData("src/resources/datapaths.txt");

        FacebookService facebookService = new FacebookServiceImpl();

        Map<String, Long> wordMaps = facebookService.findMostCommonWords();
        Set<String> postsIds1 = facebookService.findPostIdsByKeyword("loft");
        Set<String> postsIds2 = facebookService.findPostIdsByKeyword("you");
        Set<String> postsIds3 = facebookService.findPostIdsByKeyword("json");
        Set<String> postsIds4 = facebookService.findPostIdsByKeyword("What");
        Set<Facebook> allFacebookAccount = facebookService.findAll();



        try {
            Facebook profile1 = facebookService.findById("2");
            Facebook profile2 = facebookService.findById("54");
        } catch (NotFoundException e) {
            e.getMessage();
        }


    }
}
