package com.projectwork.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwork.todolist.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByIdUser(int id_user); // Updated method name to camel case
}
