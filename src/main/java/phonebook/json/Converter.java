package phonebook.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Admin on 22.02.2017.
 */
public class Converter {
//не использовался
    public String writeJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonObject = mapper.writeValueAsString(obj);
        return jsonObject;}
}
