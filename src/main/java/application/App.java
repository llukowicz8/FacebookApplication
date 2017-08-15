package application;

import data.DataInitializer;
import exception.NotFoundException;
import model.Facebook;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.FacebookService;
import service.FacebookServiceImpl;

import java.util.Map;
import java.util.Set;

//pl.application.facebook
public class App 
{
    private static final Logger logger = LogManager.getLogger(App.class);

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


        logger.info("Id posts with 'loft' word "+postsIds1);
        logger.info("Id posts with 'you' word "+postsIds2);
        logger.info("Id posts with 'json' word "+postsIds3);
        logger.info("Id posts with 'What' word "+postsIds4);
        logger.info("Facebook accounts "+allFacebookAccount);
        logger.info("Word Maps "+wordMaps);



        try {
            Facebook profile1 = facebookService.findById("2");
            logger.info("Profile with id:2 "+profile1);
            Facebook profile2 = facebookService.findById("54");
        } catch (NotFoundException e) {
            e.getMessage();
        }


    }
}
