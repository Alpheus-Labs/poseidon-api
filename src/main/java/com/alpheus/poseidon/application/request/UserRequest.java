package com.alpheus.poseidon.application.request;

import com.alpheus.poseidon.utils.PasswordUtils;

public class UserRequest {
    private String name;

    private String userName;

    private String password;

    public UserRequest(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = PasswordUtils.encrypt(password);
    }
}
