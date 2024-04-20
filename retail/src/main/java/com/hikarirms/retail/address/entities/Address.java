package com.hikarirms.retail.address.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ms_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String type;
    @OneToOne
    @JoinColumn(name = "province_code", referencedColumnName = "code")
    private Province province;
    @OneToOne
    @JoinColumn(name = "regency_code", referencedColumnName = "code")
    private Regency regency;
    @OneToOne
    @JoinColumn(name = "district_code", referencedColumnName = "code")
    private District district;
    @OneToOne
    @JoinColumn(name = "village_code", referencedColumnName = "code")
    private Village village;
    private String addressDetail;

}
