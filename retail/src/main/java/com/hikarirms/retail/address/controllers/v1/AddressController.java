package com.hikarirms.retail.address.controllers.v1;

import com.hikarirms.retail.address.dto.GetDistrictRequest;
import com.hikarirms.retail.address.dto.GetProvinceRequest;
import com.hikarirms.retail.address.dto.GetRegencyRequest;
import com.hikarirms.retail.address.dto.GetVillageRequest;
import com.hikarirms.retail.address.entities.District;
import com.hikarirms.retail.address.entities.Province;
import com.hikarirms.retail.address.entities.Regency;
import com.hikarirms.retail.address.entities.Village;
import com.hikarirms.retail.address.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("provinces")
    public Page<Province> getProvinces(GetProvinceRequest req) {
        return addressService.getProvinces(req);
    }

    @GetMapping("regencies")
    public Page<Regency> getRegencies(GetRegencyRequest req) {
        return addressService.getRegencies(req);
    }

    @GetMapping("districts")
    public Page<District> getDistricts(GetDistrictRequest req) {
        return addressService.getDistricts(req);
    }

    @GetMapping("villages")
    public Page<Village> getVillages(GetVillageRequest req) {
        return addressService.getVillages(req);
    }

}
