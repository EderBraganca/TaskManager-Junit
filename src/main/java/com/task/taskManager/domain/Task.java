package com.task.taskManager.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "/task")
public class Task {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    private boolean completed;
}
