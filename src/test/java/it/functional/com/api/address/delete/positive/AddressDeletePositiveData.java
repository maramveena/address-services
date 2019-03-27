package it.functional.com.api.address.delete.positive;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import it.functional.com.api.address.BaseIt;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/**
 * Created by nandigama on 3/26/2019.
 */
public class AddressDeletePositiveData extends BaseIt{
    @Test
    public void deleteAddressRecordWithPositiveData(){
        Response response = given().contentType("application/json").delete("/address/18");
        assertEquals(200, response.statusCode());
    }
}
