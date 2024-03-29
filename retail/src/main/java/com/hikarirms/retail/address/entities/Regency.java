package com.hikarirms.retail.address.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "regency")
public class Regency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String provinceCode;
    private String selfCode;
    private String type;
    private String name;

}

