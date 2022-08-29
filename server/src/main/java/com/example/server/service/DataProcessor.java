package com.example.server.service;

import com.example.server.entity.RepoObject;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class DataProcessor {
    public ResponseEntity getAllPublicRepositoyInformation(@AuthenticationPrincipal OAuth2User principal) {
        Map<String, Object> attributes = principal.getAttributes();
        String reposUrl = (String)attributes.get("repos_url");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RepoObject[]> responseEntity = restTemplate.getForEntity(reposUrl, RepoObject[].class);
        return responseEntity;
    }

    public Map<String,String> getUserName(OAuth2User principal) {
        return Collections.singletonMap("name", (String)principal.getAttribute("name"));
    }
}
