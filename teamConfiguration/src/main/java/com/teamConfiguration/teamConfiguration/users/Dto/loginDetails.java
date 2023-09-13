package com.teamConfiguration.teamConfiguration.users.Dto;

import lombok.Data;

@Data
public class loginDetails {
    private String email;
    private String password;

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
}
