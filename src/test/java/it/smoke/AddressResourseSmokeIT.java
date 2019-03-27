package it.smoke;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.narayana.address.api.model.Address;
import io.restassured.response.Response;
import it.functional.com.api.address.BaseIt;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/**
 * Created by nandigama on 3/26/2019.
 */
public class AddressResourseSmokeIT extends BaseIt {
    @Test
    public void testAddressResourceSmokeIT() throws JsonProcessingException {
       int id =  createResourceWithValidData();
        getAddressDetails(id);
        updateAddressRecordWithValidData(id);
        deleteAddressRecordWithPositiveData(id);
    }

    private void updateAddressRecordWithValidData(int id) throws JsonProcessingException {
        Address expectedResponse = createAddress(id, "Veena", "na", "tti", "oof",
                "jjf", "fjj", "Wa", 98012);
        String jsonStr = mapper.writeValueAsString(expectedResponse);
        Response response = given().contentType("application/json").log().all().body(jsonStr).put("/address");
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
        assertAddressResponse(expectedResponse, actualResponse);
    }

    private void getAddressDetails(int id) {
        Response response = given().contentType("application/json").get("/address/" + id);
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
    }

    private void deleteAddressRecordWithPositiveData(int id) {
        Response response = given().contentType("application/json").delete("/address/" + id);
        assertEquals(200, response.statusCode());
    }

    private int createResourceWithValidData() throws JsonProcessingException {
        Address expectedResponse = createAddress(46, "vee", "na", "tti", "oof",
                "jjf", "fjj", "Wa", 98012);
        String jsonStr = mapper.writeValueAsString(expectedResponse);
        Response response = given().contentType("application/json").log().all().body(jsonStr).log().all()
                .post("/address");
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
        assertAddressResponse(expectedResponse, actualResponse);
        return actualResponse.getId();
    }
}
