package com.sampathnuthalapati.blog.Repository;

import com.sampathnuthalapati.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}
