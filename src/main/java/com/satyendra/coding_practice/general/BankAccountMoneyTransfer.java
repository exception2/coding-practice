package com.satyendra.coding_practice.general;

import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountMoneyTransfer {
    public static void main(String[] args) {


        BankAccountMoneyTransfer solution = new BankAccountMoneyTransfer();
        BankAccount account1 = new BankAccount(1, 100);
        BankAccount account2 = new BankAccount(2, 250);
        Map<Integer, Integer> lockSet = new ConcurrentHashMap<>();

        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        if(solution.transferMoney(account1, account2, 10)) {
            solution.transferMoney(account1, account2, 50);
            lockSet.remove(account1.accountId);
            lockSet.remove(account2.accountId);
        }
    }

    /*

    * */

    public boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, double amount) {
        fromAccount.amount -= amount;
        toAccount.amount += amount;
        return true;
    }

}

@AllArgsConstructor
class BankAccount {
    ReentrantLock reentrantLock;
    int accountId;
    double amount;

    BankAccount(int accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }
    private void lock() {
        reentrantLock.tryLock();
    }

    public synchronized boolean checkLockAquired() {
        boolean flag = reentrantLock.isLocked();
        if(!flag) {
            reentrantLock.tryLock();
        }
        return flag;
    }
}

