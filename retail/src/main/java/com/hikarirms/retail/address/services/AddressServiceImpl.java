package com.hikarirms.retail.address.services;

import com.hikarirms.retail.address.dto.GetDistrictRequest;
import com.hikarirms.retail.address.dto.GetProvinceRequest;
import com.hikarirms.retail.address.dto.GetRegencyRequest;
import com.hikarirms.retail.address.dto.GetVillageRequest;
import com.hikarirms.retail.address.entities.District;
import com.hikarirms.retail.address.entities.Province;
import com.hikarirms.retail.address.entities.Regency;
import com.hikarirms.retail.address.entities.Village;
import com.hikarirms.retail.address.repositories.DistrictRepository;
import com.hikarirms.retail.address.repositories.ProvinceRepository;
import com.hikarirms.retail.address.repositories.RegencyRepository;
import com.hikarirms.retail.address.repositories.VillageRepository;
import com.hikarirms.retail.common.utils.PageableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    private final ProvinceRepository provinceRepository;
    private final RegencyRepository regencyRepository;
    private final DistrictRepository districtRepository;
    private final VillageRepository villageRepository;

    @Autowired
    public AddressServiceImpl(ProvinceRepository provinceRepository, RegencyRepository regencyRepository,
                              DistrictRepository districtRepository, VillageRepository villageRepository) {
        this.provinceRepository = provinceRepository;
        this.regencyRepository = regencyRepository;
        this.districtRepository = districtRepository;
        this.villageRepository = villageRepository;
    }

    @Override
    public Page<Province> getProvinces(GetProvinceRequest request) {
        return provinceRepository.findByParams(request.getName(), PageableUtil.generatePageable(request));
    }

    @Override
    public Page<Regency> getRegencies(GetRegencyRequest request) {
        return regencyRepository.findByParams(request.getName(), request.getProvinceCode(),
                PageableUtil.generatePageable(request));
    }

    @Override
    public Page<District> getDistricts(GetDistrictRequest request) {
        return districtRepository.findByParams(request.getName(), request.getRegencyCode(),
                PageableUtil.generatePageable(request));
    }

    @Override
    public Page<Village> getVillages(GetVillageRequest request) {
        return villageRepository.findByParams(request.getName(), request.getDistrictCode(),
                PageableUtil.generatePageable(request));
    }

}
