package com.hikarirms.retail.address.services;

import com.hikarirms.retail.address.dto.GetDistrictRequest;
import com.hikarirms.retail.address.dto.GetProvinceRequest;
import com.hikarirms.retail.address.dto.GetRegencyRequest;
import com.hikarirms.retail.address.dto.GetVillageRequest;
import com.hikarirms.retail.address.entities.District;
import com.hikarirms.retail.address.entities.Province;
import com.hikarirms.retail.address.entities.Regency;
import com.hikarirms.retail.address.entities.Village;
import org.springframework.data.domain.Page;

public interface AddressService {

    Page<Province> getProvinces(GetProvinceRequest request);

    Page<Regency> getRegencies(GetRegencyRequest request);

    Page<District> getDistricts(GetDistrictRequest request);

    Page<Village> getVillages(GetVillageRequest request);

}
