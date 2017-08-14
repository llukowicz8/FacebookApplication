package exception;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NotFoundException extends Exception {
    private String message;
    private static final Logger logger = LogManager.getLogger(NotFoundException.class);

    public NotFoundException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        logger.error(message);
        return message;
    }




}
