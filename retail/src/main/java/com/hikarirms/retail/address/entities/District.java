package com.hikarirms.retail.address.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "district")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String code;
    private String regencyCode;
    private String selfCode;
    private String name;

}
