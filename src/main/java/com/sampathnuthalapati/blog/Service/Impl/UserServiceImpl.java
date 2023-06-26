package com.sampathnuthalapati.blog.Service.Impl;

import com.sampathnuthalapati.blog.Model.User;
import com.sampathnuthalapati.blog.Payload.UserDTO;
import com.sampathnuthalapati.blog.Repository.UserRepo;
import com.sampathnuthalapati.blog.Service.UserService;
import com.sampathnuthalapati.blog.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);

        User savedUser = this.userRepo.save(user);
        
        return this.userToDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));

        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());

        User updatedUser = this.userRepo.save(user);
        UserDTO userDTO1 = this.userToDTO(updatedUser);

        return userDTO1;
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        return this.userToDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDTO> userDTOs = users.stream().map(user -> this.userToDTO(user)).collect(Collectors.toList());
        return userDTOs;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
        this.userRepo.delete(user);

    }

    public User dtoToUser(UserDTO userDTO) {
        User user= new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setAbout(userDTO.getAbout());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;

    }

    public UserDTO userToDTO(User user) {
        UserDTO userDTO= new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setAbout(user.getAbout());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;

    }
}
