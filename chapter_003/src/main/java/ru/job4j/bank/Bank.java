package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Bank.
 * @author Ivan Belyaev
 * @since 17.01.2018
 * @version 1.0
 */
public class Bank {
    /** The collection holds customers and their accounts. */
    private Map<User, List<Account>> customers = new HashMap<>();

    /**
     * Method adds a new client.
     * If the client is already there, it adds nothing.
     * @param user - new client.
     */
    public void addUser(User user) {
        customers.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Method removes the client.
     * @param user - client.
     */
    public void deleteUser(User user) {
        customers.remove(user);
    }

    /**
     * Method adds the account to the client.
     * If the account already exists, adds nothing.
     * @param passport - the client's passport.
     * @param account - the account which you want to add.
     */
    public void addAccountToUser(String passport, Account account) {
        List<Account> userAccounts = customers.get(new User("New User", passport));
        if (!userAccounts.contains(account)) {
            userAccounts.add(account);
        }
    }

    /**
     * Method removes the account from the client.
     * @param passport - the client's passport.
     * @param account - the account which you want to delete.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> userAccounts = customers.get(new User("Deleted User", passport));
        userAccounts.remove(account);
    }

    /**
     * The method returns all the customer account.
     * @param passport - the client's passport.
     * @return returns all the customer account.
     */
    public List<Account> getUserAccounts(String passport) {
        return customers.get(new User("Desired User", passport));
    }

    /**
     * Method for transferring money from one account to another account.
     * If the account is not found or not enough money in the account from which you transfer money returns false.
     * @param srcPassport - the passport of the client from whose account transfer money.
     * @param srcRequisite - details of the account from which you transferred the money.
     * @param destPassport - the passport of the client on whose account transfer money.
     * @param destRequisite - details of the account to which you transferred the money.
     * @param amount - the amount of money to transfer.
     * @return returns true if the operation was successful, otherwise returns false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findAccount(srcPassport, srcRequisite);
        Optional<Account> destAccount = findAccount(destPassport, destRequisite);

        boolean result = false;
        if (srcAccount.isPresent() && destAccount.isPresent() && srcAccount.get().getValue() > amount) {
            srcAccount.get().setValue(srcAccount.get().getValue() - amount);
            destAccount.get().setValue(destAccount.get().getValue() + amount);
            result = true;
        }

        return result;
    }

    /**
     * The method returns the client's account.
     * @param passport  - the client's passport.
     * @param requisite - account details.
     * @return returns the client's account.
     */
    private Optional<Account> findAccount(String passport, String requisite) {
        Account result = null;

        List<Account> userAccounts = customers.get(new User("Desired User", passport));
        for (Account account : userAccounts) {
            if (requisite.equals(account.getRequisites())) {
                result = account;
                break;
            }
        }

        return Optional.ofNullable(result);
    }
}