package it.functional.com.api.address.retrieve.positve;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narayana.address.api.model.Address;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import it.functional.com.api.address.BaseIt;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
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
public class AddressRetrievePositiveFT extends BaseIt{
    @Test
    public void getAddressDetails(){
        Response response = given().contentType("application/json").get("/address/18");
        assertEquals(200, response.statusCode());
        Address actualResponse = response.as(Address.class);
    }
}
