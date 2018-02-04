package com.jdmcherry.service;

import com.google.common.collect.Lists;
import com.jdmcherry.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl {


    @Autowired
    private AccountService accountService;

    public List<Account> findAll() {
        return Lists.newArrayList(accountService.findAll());
    }

    public Account findById(int id) {
        return accountService.findOne(id);
    }

    public int sumAllAccounts() {
        return accountService.getSumAcc();
    }

    public List<Account> maxAccount() {
        return Lists.newArrayList(accountService.findTopByOrderByBalanceDesc());
    }
}