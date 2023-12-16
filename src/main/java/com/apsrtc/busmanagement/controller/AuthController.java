package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Role;
import com.apsrtc.busmanagement.model.User;
import com.apsrtc.busmanagement.dao.LoginDao;
import com.apsrtc.busmanagement.dao.SignUpDao;
import com.apsrtc.busmanagement.repository.RoleRepository;
import com.apsrtc.busmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> authenticateUser(@RequestBody LoginDao loginDao){
        Map<String,Object> response = new HashMap();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDao.getUsername(), loginDao.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByUsername(loginDao.getUsername().toString()).get();

        response.put("message","success");
        response.put("username",user.getUsername());
        response.put("role",user.getRoles());
        response.put("statusCode",HttpStatus.OK);

        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String,Object>> registerUser(@RequestBody SignUpDao signUpDao){
        Map<String,Object> response = new HashMap();
        if(userRepository.existsByUsername(signUpDao.getUsername())){
            response.put("message","Username is already taken");
            response.put("statusCode",HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpDao.getEmail())){
            response.put("message","Email already exists");
            response.put("statusCode",HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setName(signUpDao.getName());
        user.setUsername(signUpDao.getUsername());
        user.setEmail(signUpDao.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDao.getPassword()));

        Role roles = roleRepository.findByName(signUpDao.getRole()).get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);
        response.put("message","User registered");
        response.put("statusCode",HttpStatus.OK);
        response.put("username",user.getUsername());
        response.put("role",roles);

        return new ResponseEntity<>(response, (HttpStatus) response.get("statusCode"));

    }
}