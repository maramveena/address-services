package it.functional.com.api.address.create.positive;

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
import static org.junit.Assert.assertTrue;

/**
 * Created by nandigama on 3/26/2019.
 */
public class AdressCreatePositiveFT extends BaseIt{

    @Test
    public void createResourceWithValidData() throws JsonProcessingException {
        Address expectedResponse = createAddress(43, "vee", "na", "tti", "oof",
                "jjf", "fjj", "Wa", 98012);
        String jsonStr = mapper.writeValueAsString(expectedResponse);
        Response response = given().contentType("application/json").log().all().body(jsonStr).log().all()
                .post("/address");
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
        assertAddressResponse(expectedResponse, actualResponse);
    }
}
