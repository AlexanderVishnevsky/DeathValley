package com.jdmcherry.model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "account")
@NamedNativeQuery(name = "Account.getSumAcc", query = "SELECT SUM(account) FROM account")
public class Account implements com.jdmcherry.model.Entity {
    private int id;
    private int balance;
    private User user;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "account", nullable = true)
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @OneToOne
    @PrimaryKeyJoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account1 = (Account) o;

        if (getId() != account1.getId()) return false;
        if (getBalance() != account1.getBalance()) return false;
        return getUser().equals(account1.getUser());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getBalance();
        result = 31 * result + getUser().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", user=" + user +
                '}';
    }
}

