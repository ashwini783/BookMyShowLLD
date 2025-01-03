package com.example.bookmyshowlld.repositories;

import com.example.bookmyshowlld.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
       //User is model on which I wanted to work upon, and Integer is primary key
    Optional<User> findByEmail(String email);
     User save(User entity);

}
