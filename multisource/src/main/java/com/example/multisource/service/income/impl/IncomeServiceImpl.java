package com.example.multisource.service.income.impl;

import com.example.multisource.dao.income.IncomeMapper;
import com.example.multisource.dao.user.UserMapper;
import com.example.multisource.domain.Income;
import com.example.multisource.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeMapper incomeMapper;
    @Override
    public int inserIncome(Income income) {
        return incomeMapper.insertIncome(income);
    }
}
