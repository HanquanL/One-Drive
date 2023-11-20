package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.repository.UserRepository;
import com.udacity.jwdnd.course1.cloudstorage.services.HashService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final HashService hashService;

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByUsername(username) == null;
    }

    public User createUser(User user) {
        if(user == null) {
            System.out.println("User is null");
        } else if (user.getPassword() == null) {
            System.out.println("User password is null");
        }
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodeSalt = Base64.getEncoder().encodeToString(salt);

        if(encodeSalt == null) {
            System.out.println("encodeSalt is null");
        }

        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodeSalt);
        return userRepository.save(new User(null, user.getUsername(), encodeSalt, hashedPassword, user.getFirstname(), user.getLastname()));
    }

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
