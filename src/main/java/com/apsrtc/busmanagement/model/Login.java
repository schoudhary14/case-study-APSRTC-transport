package com.apsrtc.busmanagement.dao;

import lombok.Data;

@Data
public class LoginDao {
    private String username;
    private String password;

    public Object getUsername() {
        return username;
    }
    public Object getPassword() {
        return password;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
