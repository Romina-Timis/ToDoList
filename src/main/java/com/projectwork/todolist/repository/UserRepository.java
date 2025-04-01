package com.projectwork.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwork.todolist.model.User;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByIdUser(int id_user); // Updated method name to camel case
    Optional<User> findByEmailAndPassword(String email, String password);
}
