package com.projectwork.todolist.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "task_assignments")
public class TaskAssignments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id_user", nullable = false)
    private AdmUser user;

    @ManyToOne
    @JoinColumn(name = "task_id_task", nullable = false)
    private Task task;

    @Column(name = "assigned_at", nullable = false, updatable = false)
    private Timestamp assignedAt;
}
