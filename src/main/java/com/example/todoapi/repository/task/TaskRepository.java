package com.example.todoapi.repository.task;

import com.example.todoapi.service.task.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT id , title FROM tasks WHERE id = #{taskId}")
    Optional<TaskRecord>select(long taskId);

}
