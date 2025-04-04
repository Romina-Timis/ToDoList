package com.projectwork.todolist.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectwork.todolist.model.Task;
import com.projectwork.todolist.repository.TaskRepository;
import com.projectwork.todolist.model.AdmUser;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

// Recupera tutti i prodotti
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    // Recupera un prodotto per ID
    public Optional<Task> getById(Integer id) {
        return taskRepository.findById(id);
    }

    // Salva un nuovo task o aggiorna un task esistente
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    // Elimina un prodotto per ID
    public void deleteById(Integer id) {
        taskRepository.deleteById(id);
    }

    // Estrazione dati dal DB per Stato
    
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByUser(AdmUser user) {
        return taskRepository.findByCreatedBy(user);
    }

}
