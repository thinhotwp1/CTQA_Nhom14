package com.example.server_ctqa.controller;

import com.example.server_ctqa.dao.UserDAO;
import com.example.server_ctqa.dao.daoImpl.UserDAOImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PostMapping("/user")
    public String response(@RequestBody String name) {
        UserDAO accountDb = new UserDAOImpl();
        if (accountDb.checkAccount(name, "1")) {
            System.out.println("thanh cong: " + name);
            return "thanh cong: " + name;
        }
        System.out.println("Sai tk mk");
        return "that bai";
    }

}
