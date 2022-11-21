package com.dh.billservice.api.client;

import com.dh.billservice.domain.dto.response.UserResponseDetailDto;
import com.dh.billservice.feign.FeignInterceptor;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="user-service", configuration = FeignInterceptor.class)
public interface UserServiceClient {

    @GetMapping("users/userName/{userName}")
    ResponseEntity<UserResponseDetailDto> findByUserName(@PathVariable String userName);



}
