package com.example.multisource.service.impl;

import com.example.multisource.domain.Income;
import com.example.multisource.domain.User;
import com.example.multisource.service.DemoService;
import com.example.multisource.service.income.IncomeService;
import com.example.multisource.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private UserService userService;
    @Autowired
    private IncomeService incomeService;
    @Override
//    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { java.lang.RuntimeException.class })
    @Transactional
    public int inbyUserIncome(String name, Double amount) {
       try {
           User user = new User();
           user.setName(name);
           userService.insertUser(user);
           System.out.println(user.getId());
           this.throwRuntimeException();
           Income income = new Income();
           income.setAmount(amount);
           income.setUserId(user.getId());
           income.setOperateDate(new Timestamp(System.currentTimeMillis()));
           incomeService.inserIncome(income);
           return 0;
       }catch (Exception e){
           e.printStackTrace();
           throw e;
       }
    }
    public void throwRuntimeException() {
        throw new RuntimeException("User defined exceptions");
    }
}
