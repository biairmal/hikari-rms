package com.hikarirms.retail.address.dto;

import com.hikarirms.retail.common.dto.BasePageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDistrictRequest extends BasePageRequest {

    private String name;
    private String regencyCode;

}
