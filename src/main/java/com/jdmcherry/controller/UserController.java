package com.jdmcherry.controller;

import com.jdmcherry.model.Account;
import com.jdmcherry.model.User;
import com.jdmcherry.service.AccountServiceImpl;
import com.jdmcherry.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    AccountServiceImpl accountServiceImpl;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUser(Model model) {

        List<User> userList = userServiceImpl.findAll();
        model.addAttribute("user", new User());
        model.addAttribute("userList", userList);
        return "index";
    }

    @RequestMapping(value = "/getRichest", method = RequestMethod.GET)
    public String getRichestUser(Model model) {
        List<Account> richestUser = accountServiceImpl.maxAccount();
        model.addAttribute("account", new Account());
        model.addAttribute("richestUser", richestUser);
        return "richestUser";
    }

    @RequestMapping(value = "/getAccountSum", method = RequestMethod.GET)
    public String accountSum(Model model) {
        model.addAttribute("sum", accountServiceImpl.sumAllAccounts());
        return "accountSum";
    }
}
