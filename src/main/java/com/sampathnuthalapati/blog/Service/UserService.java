package com.sampathnuthalapati.blog.Service;

import com.sampathnuthalapati.blog.Payload.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerNewUser(UserDTO user);

    //for creating normal users
    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Integer userId);

    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUsers();

    void deleteUser(Integer userId);
}
