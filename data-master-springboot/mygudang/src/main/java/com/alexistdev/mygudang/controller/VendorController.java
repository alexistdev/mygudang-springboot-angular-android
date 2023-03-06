package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.dto.VendorDTO;
import com.alexistdev.mygudang.entity.Vendor;
import com.alexistdev.mygudang.service.VendorService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Vendor>> create(@Valid @RequestBody VendorDTO vendorDTO, Errors errors){
        ResponseData<Vendor> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for(ObjectError error: errors.getAllErrors()){
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        //cara manual convert to DTO
//        Vendor vendor = new Vendor();
//        vendor.setName(vendorDTO.getName());
//        vendor.setAddress(vendorDTO.getAddress());
//        vendor.setEmail(vendorDTO.getEmail());
//        vendor.setCode(vendorDTO.getCode());
        Vendor vendor = modelMapper.map(vendorDTO,Vendor.class);
        responseData.setStatus(true);
        responseData.setPayload(vendorService.save(vendor));
        return ResponseEntity.ok(responseData);
    }

}
