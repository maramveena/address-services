package it.functional.com.api.address.create.negative;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.narayana.address.api.model.Address;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import it.functional.com.api.address.BaseIt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/**
 * Created by nandigama on 3/26/2019.
 */
public class AddressCreatteNegativeFT extends BaseIt{
    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createResourceWithInvalidContentType() throws JsonProcessingException {
        Address expectedResponse = createAddress(47, "vee", "na", "tti", "oof",
                "jjf", "fjj", "Wa", 98012);
        String jsonStr = mapper.writeValueAsString(expectedResponse);
        Response response = given().contentType("application/xml").log().all().body(jsonStr).log().all().post("/address");
          assertEquals(415, response.getStatusCode());
    }

}
