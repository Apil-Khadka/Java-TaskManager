package com.apil.taskmanager.Task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner init(TaskRepository taskRepository) {
        return args -> {
            Task task1 = new Task(
                "Task 1",
                "Description for Task 1",
                    LocalDate.of(2025, Month.SEPTEMBER,23),
                false
            );
            Task task2 = new Task(
                "Task 2",
                "Description for Task 2",
                LocalDate.of(2025, Month.JUNE,21),
                true
            );
            taskRepository.saveAll(
                List.of(task1, task2)
            );
        };
    }
}
