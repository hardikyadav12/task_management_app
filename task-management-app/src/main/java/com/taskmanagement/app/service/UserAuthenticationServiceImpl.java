package com.taskmanagement.app.service;

import com.taskmanagement.app.entity.User;
import com.taskmanagement.app.repository.UserRepository;
import com.taskmanagement.app.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

    @Autowired private UserRepository userRepository;

    @Override
    public String registerUser(UserRequest user) {

        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[6];
        secureRandom.nextBytes(salt);

        KeySpec spec = new PBEKeySpec(user.getUserPassword().toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();

            User registeredUser = User.builder().hashedPassword(Arrays.toString(hash)).saltPassword(Arrays.toString(salt)).userName(user.getUserName()).build();

            userRepository.save(registeredUser);


        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

        return "Created";
    }
}
