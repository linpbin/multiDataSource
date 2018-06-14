package com.example.multisource.dao.income;

import com.example.multisource.domain.Income;
import org.apache.ibatis.annotations.*;

@Mapper
public interface IncomeMapper {
    @Insert("insert into income(userId,amount,operateDate) values(#{income.userId},#{income.amount},#{income.operateDate})")
    int insertIncome(@Param("income") Income income);
}
