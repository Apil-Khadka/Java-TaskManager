package com.apil.taskmanager.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
    //  This interface will automatically provide CRUD operations for the Task entity
}
