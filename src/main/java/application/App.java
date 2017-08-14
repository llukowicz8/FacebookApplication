package application;

import data.DataInitializer;
import exception.NotFoundException;
import service.FacebookService;
import service.FacebookServiceImpl;
//pl.application.facebook
public class App 
{
    public static void main( String[] args )
    {  //BasicConfigurator.configure();
        //inicjacja  danych
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.initializeData("src/resources/datapaths.txt");

        FacebookService facebookService = new FacebookServiceImpl();

        facebookService.findMostCommonWords();
        facebookService.findPostIdsByKeyword("loft");
        facebookService.findPostIdsByKeyword("you");
        facebookService.findPostIdsByKeyword("json");
        facebookService.findPostIdsByKeyword("What");
        facebookService.findAll();



        try {
           facebookService.findById("54");
        } catch (NotFoundException e) {
            e.getMessage();
        }


    }
}
