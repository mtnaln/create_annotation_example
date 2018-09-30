package com.metin.example;

import com.metin.annotations.CustomAuthority;
import org.springframework.stereotype.Service;

@Service
@CustomAuthority(authorities = {"TASK"})
public class TaskService extends BaseService {

    public void addTask() {

        if (authorityUtil.isAuth(this, Thread.currentThread().getStackTrace()[1].getMethodName())) {
            System.out.println("Task added successfully...");
        } else {
            System.out.println("You have NOT authoritiy for adding task...");
        }
    }

    public void deleteTask() {

        if (authorityUtil.isAuth(this, Thread.currentThread().getStackTrace()[1].getMethodName())) {
            System.out.println("Task deleted successfully...");
        } else {
            System.out.println("You have NOT authoritiy for deleting task...");
        }
    }

}
