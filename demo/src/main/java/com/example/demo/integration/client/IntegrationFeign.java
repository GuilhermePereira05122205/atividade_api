package com.example.demo.integration.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entities.User;
import com.example.integration.IntegrationInterface;

@FeignClient(
    name = "intergrationFeign",
    url = "${user.url}"
)
public interface IntegrationFeign extends IntegrationInterface{
    @GetMapping("/user/find-id/{id}")
    public User getUser(@PathVariable String id);
}
