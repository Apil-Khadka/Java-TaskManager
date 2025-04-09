package com.apil.taskmanager.Task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String name, String description, LocalDate dueDate, boolean completed) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }
}
