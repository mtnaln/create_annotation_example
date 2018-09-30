package com.metin.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private PersonelService personelService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/addPersonel")
    public void addPersonel() {

        personelService.addPersonel();
    }

    @GetMapping("/deletePersonel")
    public void deletePersonel() {

        personelService.deletePersonel();
    }

    @GetMapping("/addTask")
    public void addTask() {

        taskService.addTask();
    }

    @GetMapping("/deleteTask")
    public void deleteTask() {

        taskService.deleteTask();
    }
}
