package com.hikarirms.retail.address.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "village")
public class Village {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String districtCode;
    private String selfCode;
    private String name;
    private String postalCode;

}
