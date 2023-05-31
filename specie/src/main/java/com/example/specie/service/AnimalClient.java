package com.example.specie.service;

import com.example.specie.custom.SpecieCustom;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ANIMAL-SERVICE")
@LoadBalancerClient(name= "ANIMAL-SERVICE", configuration = SpecieCustom.class)
public interface AnimalClient {
    @GetMapping("/animal/{specie}")
    String findAnimalBySpecie(@PathVariable String specie);

}
