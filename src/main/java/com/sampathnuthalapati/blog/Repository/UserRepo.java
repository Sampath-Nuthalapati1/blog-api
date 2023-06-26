package com.sampathnuthalapati.blog.Repository;

import com.sampathnuthalapati.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
