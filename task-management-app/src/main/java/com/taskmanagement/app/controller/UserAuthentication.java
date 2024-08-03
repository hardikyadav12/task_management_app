package com.taskmanagement.app.controller;

import com.taskmanagement.app.request.UserRequest;
import com.taskmanagement.app.service.UserAuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserAuthentication {

    @Autowired
    private UserAuthenticationService userAuthenticationService;



    @Operation(summary = "User is registered")
    @ApiResponse(
            responseCode = "200",
            description = "User Created Successfully",
            content = {
                    @Content(mediaType = "application/json")
            }
    )
    @PostMapping("/register")
    public ResponseEntity<HttpStatus> userRegistration(@RequestBody UserRequest userRequest) {

        userAuthenticationService.registerUser(userRequest);

        return new ResponseEntity<>(HttpStatus.OK);


    }


}
