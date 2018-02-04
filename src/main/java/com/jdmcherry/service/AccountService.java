package com.jdmcherry.service;


import com.jdmcherry.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountService extends CrudRepository<Account, Integer> {
    int getSumAcc();

    List<Account> findTopByOrderByBalanceDesc();
}