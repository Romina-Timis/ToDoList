package com.projectwork.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectwork.todolist.model.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {

List<User> findByUserId(int id);

}
