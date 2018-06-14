package com.example.multisource.web;

import com.example.multisource.domain.Income;
import com.example.multisource.domain.User;
import com.example.multisource.service.DemoService;
import com.example.multisource.service.income.IncomeService;
import com.example.multisource.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/income")
public class controller {
    @Autowired
    private DemoService demoService;
    @GetMapping("/add")
    public String index(@RequestParam("name") String name,@RequestParam("amount") Double amount){
        demoService.inbyUserIncome(name,amount);
        return "success";
    }
}
