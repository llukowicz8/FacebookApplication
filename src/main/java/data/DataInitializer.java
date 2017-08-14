package data;


public class DataInitializer {

    public void initializeData(String path){
        Repository.getInstance(path);
    }

}
