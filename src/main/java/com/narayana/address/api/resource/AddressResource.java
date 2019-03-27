package com.narayana.address.api.resource;

import com.narayana.address.api.mapper.AddressMapper;
import com.narayana.address.api.model.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandigama on 2/19/2019.
 */
@RestController
@RequestMapping(value="/address", produces={"application/json"}, consumes="application/json")
public class AddressResource {

    private AddressMapper addressMapper;

    public AddressResource(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    /**
     * @param address
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createAddress(@RequestBody Address address) {
        //Request validations

        //insert into database
        Address address1 = addressMapper.findAddressByd(address.getId());
        if (address1 != null)
            return ResponseEntity.badRequest().build();

        addressMapper.insert(address);

        return ResponseEntity.ok(address);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, consumes = "application/json")
    public ResponseEntity getAddressById(@PathVariable("id") int id) {
        Address address = addressMapper.findAddressByd(id);
        if (address != null)
            return ResponseEntity.ok(address);
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateAddress(@RequestBody Address address) {
        Address address1 = addressMapper.findAddressByd(address.getId());
        if (address1 == null)
            return ResponseEntity.notFound().build();

        addressMapper.updateAddress(address);
        return ResponseEntity.ok(address);

    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ResponseEntity deleteAddress(@PathVariable("id") int id) {
        Address address = addressMapper.findAddressByd(id);
        if (address == null)
            return ResponseEntity.notFound().build();
        addressMapper.deleteAddress(id);
        return ResponseEntity.ok().build();
    }
}
