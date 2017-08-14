package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Facebook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ParserImpl implements Parser {


    public Facebook parseObject(String pathToObject) {
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(pathToObject));
            ObjectMapper objectMapper = new ObjectMapper();
            Facebook fbAccount = objectMapper.readValue(jsonData, Facebook.class);

            return fbAccount;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
