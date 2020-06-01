package com.api.gateway.security;

import lombok.Data;

@Data
public class LoginUser {
    private String username;
    private String password;
}
