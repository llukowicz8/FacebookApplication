package tests;

import data.DataInitializer;
import exception.NotFoundException;
import model.Facebook;
import org.junit.Assert;
import org.junit.Before;
import service.FacebookService;
import service.FacebookServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Unit test for simple Facebook Service
 */

public class AppTest
{
    @Before
    public void init(){
        DataInitializer dataInitializer = new DataInitializer();
        dataInitializer.initializeData("src/test/resources/datatestpaths.txt");
    }

    @org.junit.Test(expected = NotFoundException.class)
    public void findByIdNotFoundTest() throws NotFoundException {



        FacebookService facebookService = new FacebookServiceImpl();
        facebookService.findById("8");

    }

    @org.junit.Test
    public void findByIdFoundTest() throws NotFoundException {


        FacebookService facebookService = new FacebookServiceImpl();
        Facebook fbAccount = facebookService.findById("5");


        Assert.assertNotNull(fbAccount);
    }

    @org.junit.Test
    public void postIdsTest() {


        FacebookService facebookService = new FacebookServiceImpl();
        Set<String> expectedResult = new HashSet<>(Arrays.asList("2", "3"));

        Set<String> result = facebookService.findPostIdsByKeyword("fantastic");

        Assert.assertEquals(expectedResult,result);


    }

}
