package com.service.impl;

import com.config.MyConfiguration;
import com.domain.Account;
import com.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfiguration.class)
public class AccountServiceImplTest {
    @Autowired
    private IAccountService accountService;

    @Qualifier("account")
    @Autowired
    private Account account1;

    @Qualifier("account")
    @Autowired
    private Account account2;

    @Test
    public void transfer() {
        account1.setId(17);
        account2.setId(18);
        accountService.transfer(account2, account1, 10f);
    }

    @Test
    public void saveAccount() {
        accountService.saveAccount(account1);
        accountService.saveAccount(account2);
    }

    @Test
    public void queryAll() {
        List<Account> accounts = accountService.queryAll();
        accounts.forEach((System.out::println));
    }

    @Test
    public void queryById() {
        List<Account> accounts = accountService.queryById(account1.getId());
        accounts.forEach(System.out::println);
    }

    @Test
    public void queryByName() {
        List<Account> accounts = accountService.queryByName(account1.getName());
        accounts.forEach(System.out::println);
    }


    @Test
    public void updateAccount() {
        account1.setBalance(account1.getBalance()+1);
        accountService.updateAccount(account1);
    }

    @Test
    public void deleteAccountById() {
        accountService.deleteAccountById(account1.getId());
    }

    @Test
    public void setAccountDao() {
    }
}