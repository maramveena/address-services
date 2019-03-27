package com.narayana.address.api.mapper;

import com.narayana.address.api.model.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by nandigama on 2/19/2019.
 */
@Mapper
public interface AddressMapper {

    @Insert("insert into CUSTOMER.ADDRESS(FIRSTNAME, LASTNAME, EMAIL, ADDRESSLINEONE, ADDRESSLINETWO, CITY, STATE, ZIPCODE) " +
            "values(#{firstName},#{lastName},#{email},#{addressLineOne},#{addressLineTwo},#{city},#{state},#{zipCode})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Address address);

    @Select("select * from CUSTOMER.ADDRESS")
    List<Address> findAll();

    @Select("select * from CUSTOMER.ADDRESS WHERE ID=#{id}")
    Address findAddressByd(@Param("id")int id);

    @Update("UPDATE CUSTOMER.ADDRESS SET FIRSTNAME=#{firstName}, LASTNAME =#{lastName}" +
            ", EMAIL =#{email}, ADDRESSLINEONE =#{addressLineOne}, ADDRESSLINETWO =#{addressLineTwo}, CITY =#{city}, " +
            "STATE =#{state}, ZIPCODE =#{zipCode} WHERE ID =#{id}")
    void updateAddress(Address address);

    @Delete("DELETE FROM CUSTOMER.ADDRESS WHERE ID =#{id}")
    void deleteAddress(@Param("id")int id);

}
