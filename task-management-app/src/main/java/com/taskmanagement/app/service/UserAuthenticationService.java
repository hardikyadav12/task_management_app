package com.taskmanagement.app.service;

import com.taskmanagement.app.request.UserRequest;

public interface UserAuthenticationService {

    String registerUser(UserRequest user);

}
