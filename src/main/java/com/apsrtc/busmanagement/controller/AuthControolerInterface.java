package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.dao.LoginDao;
import com.apsrtc.busmanagement.dao.SignUpDao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public interface AuthControolerInterface {

    ResponseEntity<Map<String,Object>> authenticateUser(@RequestBody LoginDao loginDao);
    ResponseEntity<Map<String,Object>> registerUser(@RequestBody SignUpDao signUpDao);
}
