package com.taskmanagement.app.request;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserRequest {

    private String userName;

    private String hashedPassword;

}
