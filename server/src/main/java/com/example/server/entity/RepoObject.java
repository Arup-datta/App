package com.example.server.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

public class RepoObject {
    @JsonProperty("name")
    private String name; /// binders use reflection ~ so public/private doesn't matter
    @JsonProperty("created_at")
    private String createdAt;
}
