package com.projectwork.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectwork.todolist.model.AdmUser;
import com.projectwork.todolist.repository.AdmUserRepository;

@Service
public class AdmUserService {

    private final AdmUserRepository userRepository;

    public AdmUserService(AdmUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<AdmUser> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<AdmUser> getById(int id) {
        return userRepository.findById(id);
    }

    public AdmUser saveUser(AdmUser user) {
        // Salva l'utente nel database
        return userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public AdmUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



}
