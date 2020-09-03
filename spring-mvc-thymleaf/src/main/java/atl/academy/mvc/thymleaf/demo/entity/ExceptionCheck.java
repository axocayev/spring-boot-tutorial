package atl.academy.mvc.thymleaf.demo.entity;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.UnsupportedCharsetException;
import java.text.ParseException;

@Slf4j

public class ExceptionCheck {

    public    int testConvert(String value) {
        int result = 0;
        try {
            // @Cleanup
            // FileInputStream fileInputStream = new FileInputStream(new File("test"));
            result = Integer.parseInt(value);
            log.info("value ={}, result {}", value, result);
            //fileInputStream.close();
        } catch (Exception e) {
            log.error(e.getMessage());
        }


        return result;
    }
}
