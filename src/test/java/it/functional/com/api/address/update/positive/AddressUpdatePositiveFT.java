package it.functional.com.api.address.update.positive;

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
public class AddressUpdatePositiveFT extends BaseIt {
    @Test
    public void updateAddressRecordWithValidData() throws JsonProcessingException {
        Address expectedResponse = createAddress(19, "Veena", "na", "tti", "oof",
                "jjf", "fjj", "Wa", 98012);
        String jsonStr = mapper.writeValueAsString(expectedResponse);
        Response response = given().contentType("application/json").log().all().body(jsonStr).put("/address");
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
        assertAddressResponse(expectedResponse, actualResponse);
    }
}
