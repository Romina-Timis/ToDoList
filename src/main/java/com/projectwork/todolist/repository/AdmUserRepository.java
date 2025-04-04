package com.projectwork.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projectwork.todolist.model.AdmUser;


public interface AdmUserRepository extends JpaRepository<AdmUser, Integer> {
    @Query("SELECT u FROM AdmUser u WHERE u.username = ?1")
    AdmUser findByUsername(String username);

}
