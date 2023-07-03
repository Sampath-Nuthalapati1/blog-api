package com.sampathnuthalapati.blog.Security;

import com.sampathnuthalapati.blog.Exception.ResourceNotFoundException;
import com.sampathnuthalapati.blog.Model.User;
import com.sampathnuthalapati.blog.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //load user from database by username
        User user = this.userRepo.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User", "email", Long.parseLong(username)));


        return user;
    }

}
