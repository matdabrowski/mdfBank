package mdf.bank.mdfwebappbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;

public class ObjectUtils {

    private ObjectUtils() {
    }

    public static <T> T objectOf(MvcResult result, Class<T> clazz) {
        try {
            return new ObjectMapper().readValue(result.getResponse().getContentAsString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
