package com.alpheus.poseidon.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class PasswordUtils {

    public String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

    public Boolean matches(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
