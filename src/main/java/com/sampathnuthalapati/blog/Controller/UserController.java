package com.sampathnuthalapati.blog.Controller;

import com.sampathnuthalapati.blog.Payload.APIRespnse;
import com.sampathnuthalapati.blog.Payload.UserDTO;
import com.sampathnuthalapati.blog.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUserDTO = this.userService.createUser(userDTO);
        return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable Integer userId) {
        UserDTO updatedUser = this.userService.updateUser(userDTO, userId);
        return ResponseEntity.ok(updatedUser);
    }

    // delete using APIResponse class
    @DeleteMapping("/{userId}")
    public ResponseEntity<APIRespnse> deleteUser(@PathVariable("userId") Integer uid) {
        this.userService.deleteUser(uid);
        return new ResponseEntity<APIRespnse>(new APIRespnse("User Deleted Successfully", true), HttpStatus.OK);
    }

    // simple delete method without Custom APIResponse class
    //    @DeleteMapping("/{userId}")
    //    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid) {
    //        this.userService.deleteUser(uid);
    //        return new ResponseEntity(Map.of("message", "User Deleted Successfully"), HttpStatus.OK);
    //    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }



}
