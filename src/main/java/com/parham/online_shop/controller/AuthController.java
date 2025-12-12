package com.parham.online_shop.controller;


import com.parham.online_shop.model.RegisterModel;
import com.parham.online_shop.model.UserModel;
import com.parham.online_shop.service.LoginService;
import com.parham.online_shop.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {
    @Autowired
    private RegisterService registerService;

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterModel registerModel) {
        try {
            return ResponseEntity.ok(registerService.registerUser(registerModel));
        }
        catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserModel userModel) {
        try {
            return ResponseEntity.ok(loginService.login(userModel));
        }
        catch (Exception e) {
            log.error(e.getMessage());
            System.out.println(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
