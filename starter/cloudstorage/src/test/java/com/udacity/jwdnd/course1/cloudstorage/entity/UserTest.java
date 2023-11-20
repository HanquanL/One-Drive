package com.udacity.jwdnd.course1.cloudstorage.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private String username = "Test Username";
    private String password = "Test Password";
    private String firstname = "Test Firstname";
    private String lastname = "Test Lastname";
    private byte[] salt = new byte[16];
    @BeforeEach
    public void setup() {
        user = new User(null, username, password, firstname, lastname, salt.toString());
    }

    // Add tests for the remaining fields in the User class

    @Test
    public void testSetAndGetUsername() {
        String username = "Test Username";
        user.setUsername(username);
        assert username == user.getUsername();
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "Test Password";
        user.setPassword(password);
        assert password == user.getPassword();
    }

    @Test
    public void testSetAndGetFirstname() {
        String firstname = "Test Firstname";
        user.setFirstname(firstname);
        assert firstname == user.getFirstname();
    }

    @Test
    public void testSetAndGetLastname() {
        String lastname = "Test Lastname";
        user.setLastname(lastname);
        assert lastname == user.getLastname();
    }

    @Test
    public void testSetAndGetSalt() {
        String salt = "Test Salt";
        user.setSalt(salt);
        assert salt == user.getSalt();
    }
}
