package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.course1.cloudstorage.services.HashService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashServiceTest {

    private HashService hashService;
    private String data = "test";
    private String salt = "salt";

    @BeforeEach
    public void setup() {
        hashService = new HashService();
    }

    @Test
    public void testHashValue() {
        String hashedValue = hashService.getHashedValue(data, salt);
        assert hashedValue != null;
        assert !hashedValue.equals(data);
        assert !hashedValue.equals(salt);
    }

}
