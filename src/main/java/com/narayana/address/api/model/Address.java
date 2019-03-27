package com.narayana.address.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Main Model class for Address Resource
 * Created by nandigama on 2/19/2019.
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    int id;
    String firstName;
    String lastName;
    String email;
    String addressLineOne;
    String addressLineTwo;
    String city;
    String state;
    int zipCode;
}
