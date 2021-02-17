package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if(!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        } else {
            System.out.println("Such user already exist");
        }
    }

    public void addAccount(String passport, Account account){
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccList = users.get(user);
            boolean isNewAcc = true;
            for (Account accCheck : userAccList) {
                if (accCheck.equals(account)) {
                    isNewAcc = false;
                    break;
                }
            }
            if (isNewAcc) {
                userAccList.add(account);
            } else {
                System.out.println("Such account already exist");
            }
        } else {
            System.out.println("Please try again");
        }
    }

    public User findByPassport(String passport) {
        for(User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        System.out.println("No user with such passport detected");
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if(user != null) {
            for (Account acc : users.get(user)) {
                if (acc.getRequisite().equals(requisite)) {
                    return acc;
                }
            }
        }
        System.out.println("This account does not exist");
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);

        if(srcAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
        }
        return rsl;
    }
}
