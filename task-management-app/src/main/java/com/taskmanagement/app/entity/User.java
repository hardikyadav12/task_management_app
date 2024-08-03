package com.taskmanagement.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "hashedPassword")
    private String hashedPassword;

    @Column(name = "salt_password")
    private String saltPassword;

}
