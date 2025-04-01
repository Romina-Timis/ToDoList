package com.projectwork.todolist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Ensure Lombok is correctly imported

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false) // Add missing comma
    private String nome;

    @Column(name = "email", nullable = false) // Add missing comma
    private String email;
    
    @Column(name = "password", nullable = false) // Add missing comma
    private String password;

}
