package data;


import model.Facebook;

import java.util.List;

public interface FileService {

    List<Facebook> readFile(String path);


}
