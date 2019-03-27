package it.functional.com.api.address;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.narayana.address.api.model.Address;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by nandigama on 3/26/2019.
 */
public class BaseIt {
     public static ObjectMapper mapper = new ObjectMapper();

    @BeforeClass
    public static void setUp() throws IOException {
        InputStream stream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("test-application.properties");
        Properties properties = new Properties();
        properties.load(stream);
        RestAssured.baseURI = properties.getProperty("address.endpoint");
    }

    protected Address createAddress(int id, String firstName, String lastName,
                                  String email,
                                  String addressLineOne,
                                  String addressLineTwo,
                                  String city,
                                  String state,
                                  int zipCode) {
        return new Address(id, firstName, lastName, email, addressLineOne,addressLineTwo, city, state, zipCode);
    }
    protected void assertAddressResponse(Address expectedResponse, Address actualResponse){
        assertEquals(expectedResponse.getCity(), actualResponse.getCity());
        assertEquals(expectedResponse.getAddressLineOne(), actualResponse.getAddressLineOne());
        assertEquals(expectedResponse.getAddressLineTwo(), actualResponse.getAddressLineTwo());
        assertEquals(expectedResponse.getEmail(), actualResponse.getEmail());
        assertEquals(expectedResponse.getFirstName(), actualResponse.getFirstName());
        assertEquals(expectedResponse.getLastName(), actualResponse.getLastName());
        assertEquals(expectedResponse.getEmail(), actualResponse.getEmail());
        assertEquals(expectedResponse.getZipCode(), actualResponse.getZipCode());
        assertTrue(expectedResponse.getId() > 0);
    }

}
