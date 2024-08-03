package com.taskmanagement.app.service;

import com.taskmanagement.app.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    @Override
    public String registerUser(UserRequest user) {
        return "Created";
    }
}
