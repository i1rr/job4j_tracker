package ru.job4j.collection.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class gives an example of very simple bank system
 * !WARNING! DO NOT USE IT IN REAL BANK SYSTEMS =)
 * @author i1rr
 * @version 2.0
 */
public class BankService {
    /**
     * This collection keep Users and their accounts together in HashMap collection.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * This method adds a User to "users" collection only if such user not yet exist.
     * @param user is used as an input value for a new user.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * This method adds a new account to existing user.
     * @param passport is used to find an account holder
     * @param account is the new account value that will be added to the existing user
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> userAccList = users.get(user);
            if (!userAccList.contains(account)) {
                userAccList.add(account);
            }
        }
    }

    /**
     * This method finds a user by passport id.
     * @param passport is used as input value to define the user.
     * @return returns user from Collection.
     */
    public User findByPassport(String passport) {
        if (passport != null) {
            return users.keySet().stream()
                    .filter(usr -> usr.getPassport().equals(passport))
                    .findFirst()
                    .orElse(null);
        }
        System.out.println("No user with such passport detected");
        return null;
    }

    /**
     * this method returns an account using passports and requisite values.
     * @param passport is used to find a user.
     * @param requisite is used to find the account if the user exist.
     * @return returns account value.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        System.out.println("This account does not exist");
        return null;
    }

    /**
     * this method describes money transfer logic.
     * @param srcPassport passport of user that transfers money.
     * @param srcRequisite account number of user that transfers money.
     * @param destPassport passport of user that receives money.
     * @param destRequisite account number of user that receives money.
     * @param amount amount of money that will be transferred from one account to another,
     *               if sender has enough money on his account.
     * @return returns boolean value of "true" if the operation is succeeded, and "false" if not.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);

        if (srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
