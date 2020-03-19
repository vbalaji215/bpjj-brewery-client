package com.bpjj.brewery.client.web.client;

import com.bpjj.brewery.client.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * vbala created on 3/18/2020
 * Inside the package - com.bpjj.brewery.client.web.client
 **/
@Component
@ConfigurationProperties(value = "bpjj.brewery", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customers/";
    private String apiHost;
    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost){
        this.apiHost = apiHost;
    }

    public CustomerDto getCustomerById(UUID customerId){
        return restTemplate.getForObject(
                apiHost + CUSTOMER_PATH_V1 + customerId.toString(),
                CustomerDto.class);
    }

    public URI createCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID customerId, CustomerDto customerDto){
        restTemplate.put(
                apiHost + CUSTOMER_PATH_V1 + customerId.toString(),
                customerDto);
    }

    public void deleteCustomer(UUID customerId){
        restTemplate.delete(
                apiHost + CUSTOMER_PATH_V1 + customerId.toString()
        );
    }


}
