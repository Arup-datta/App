package com.example.server.controller;
import com.example.server.entity.RepoObject;
import com.example.server.service.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;



@RestController
public class HomeController {

    @Autowired
    private DataProcessor processor;


    @GetMapping("/user")
    public Map < String,String > userName(@AuthenticationPrincipal OAuth2User principal) {
        return processor.getUserName(principal);
    }

    @GetMapping("/get/repos")
    public ResponseEntity <?> allPublicReposityInformation(@AuthenticationPrincipal OAuth2User principal) {
        return processor.getAllPublicRepositoyInformation(principal);
    }
}
