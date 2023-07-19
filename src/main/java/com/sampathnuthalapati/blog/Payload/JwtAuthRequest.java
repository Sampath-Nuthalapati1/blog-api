package com.sampathnuthalapati.blog.Payload;

import lombok.Data;

@Data
public class JwtAuthRequest {
    private String username;
    private String password;
}
