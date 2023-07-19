package com.sampathnuthalapati.blog.Payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class JwtAuthResponse {
    private String token;
}
