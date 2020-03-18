package com.bpjj.brewery.client.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * vbala created on 3/17/2020
 * Inside the package - com.bpjj.brewery.client.web.model
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    private String name;
}
