package com.example.todoapi.service.task;

import com.example.todoapi.repository.task.TaskRecord;
import com.example.todoapi.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity find(long taskId) {
        return taskRepository.select(taskId)
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new TaskEntityNotFoundException(taskId)); //ここを自作したクラスに変更
    }

    public List<TaskEntity> find() {
        return List.of(new TaskEntity(1, "task1"), new TaskEntity(2, "task2"));
    }

    public TaskEntity create(String title) {
        var record = new TaskRecord(null, title);
        taskRepository.insert(record);
        return new TaskEntity(record.getId(), record.getTitle());
    }
}
