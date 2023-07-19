package com.sampathnuthalapati.blog.Payload;

import com.sampathnuthalapati.blog.Model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private int id;
    @NotEmpty
    @Size(min=4, message="Name must be minimum of 4 characters.")
    private String name;
    @Email(message = "Email address is not valid.")
    private String email;
    @NotEmpty
    @Size(min=8, max=15, message="Password must be minimum of 8 characters and maximum of 15 characters.")
    private String password;
    @NotEmpty
    private String about;
    private Set<RoleDTO> roles = new HashSet<>();
}
