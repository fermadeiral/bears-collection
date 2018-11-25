package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * BankTest.
 * @author Ivan Belyaev
 * @since 17.01.2018
 * @version 1.0
 */
public class BankTest {
    /**
     * Test for addUser method.
     */
    @Test
    public void whenAddUserThenBankHasUserWithOutAccounts() {
        Bank bank = new Bank();
        User user = new User("Grisha", "123");
        bank.addUser(user);

        List<Account> methodReturns = bank.getUserAccounts(user.getPassport());
        List<Account> expected = new ArrayList<>();
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for deleteUser method.
     */
    @Test
    public void whenDeleteUserThenBankDoesNotHaveUser() {
        Bank bank = new Bank();
        User user = new User("Grisha", "123");
        bank.addUser(user);
        bank.deleteUser(user);

        List<Account> methodReturns = bank.getUserAccounts(user.getPassport());
        List<Account> expected = null;
        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for addAccountToUser method.
     */
    @Test
    public void whenAddAccountToUserThenBankHasUserWithThistAccount() {
        Bank bank = new Bank();
        User user = new User("Grisha", "123");
        bank.addUser(user);

        Account account = new Account("1234", 255.97);
        bank.addAccountToUser(user.getPassport(), account);

        List<Account> methodReturns = bank.getUserAccounts(user.getPassport());
        List<Account> expected = new ArrayList<>();
        expected.add(account);

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for deleteAccountFromUser method.
     */
    @Test
    public void whenDeleteAccountFromUserThenBankHasUserWithoutThistAccount() {
        Bank bank = new Bank();
        User user = new User("Grisha", "123");
        bank.addUser(user);

        Account account = new Account("1234", 255.97);
        bank.addAccountToUser(user.getPassport(), account);
        bank.deleteAccountFromUser(user.getPassport(), account);

        List<Account> methodReturns = bank.getUserAccounts(user.getPassport());
        List<Account> expected = new ArrayList<>();

        assertThat(methodReturns, is(expected));
    }

    /**
     * Test for getUserAccounts method.
     */
    @Test
    public void whenGetUserAccountsForUserWithTwoAccountsThenListWithTwoAccounts() {
        Bank bank = new Bank();
        User user = new User("Grisha", "123");
        bank.addUser(user);

        Account account1 = new Account("1234", 255.97);
        bank.addAccountToUser(user.getPassport(), account1);
        Account account2 = new Account("12345", 333);
        bank.addAccountToUser(user.getPassport(), account2);

        List<Account> methodReturns = bank.getUserAccounts(user.getPassport());
        List<Account> expected = new ArrayList<>();
        expected.add(account1);
        expected.add(account2);

        assertThat(methodReturns, is(expected));
    }

    /**
     * First test for transferMoney method.
     * Accounts exist and money is enough for the transfer.
     */
    @Test
    public void whenTransferMoneyPossibleThenTransferMoney() {
        Bank bank = new Bank();

        User grisha = new User("Grisha", "123");
        bank.addUser(grisha);

        Account accountGrisha = new Account("1234", 300.5);
        bank.addAccountToUser(grisha.getPassport(), accountGrisha);

        User oleg = new User("Oleg", "456");
        bank.addUser(oleg);

        Account accountOleg = new Account("5678", 200.7);
        bank.addAccountToUser(oleg.getPassport(), accountOleg);

        boolean methodReturns = bank.transferMoney(
                grisha.getPassport(), accountGrisha.getRequisites(),
                oleg.getPassport(), accountOleg.getRequisites(), 200.5);
        boolean expected = true;

        assertThat(methodReturns, is(expected));
        assertThat(accountGrisha.getValue(), is(100.0));
        assertThat(accountOleg.getValue(), is(401.2));
    }

    /**
     * Second test for transferMoney method.
     * One of the accounts does not exist.
     */
    @Test
    public void whenTransferMoneyImpossibleBecauseAccountDoesNotExistThenFalse() {
        Bank bank = new Bank();

        User grisha = new User("Grisha", "123");
        bank.addUser(grisha);

        Account accountGrisha = new Account("1234", 300.5);
        bank.addAccountToUser(grisha.getPassport(), accountGrisha);

        User oleg = new User("Oleg", "456");
        bank.addUser(oleg);

        Account accountOleg = new Account("5678", 200.7);

        boolean methodReturns = bank.transferMoney(
                grisha.getPassport(), accountGrisha.getRequisites(),
                oleg.getPassport(), accountOleg.getRequisites(), 200.5);
        boolean expected = false;

        assertThat(methodReturns, is(expected));
        assertThat(accountGrisha.getValue(), is(300.5));
        assertThat(accountOleg.getValue(), is(200.7));
    }

    /**
     * Third test for transferMoney method.
     * Not enough money.
     */
    @Test
    public void whenTransferMoneyImpossibleBecauseNotEnoughMoneyThenFalse() {
        Bank bank = new Bank();

        User grisha = new User("Grisha", "123");
        bank.addUser(grisha);

        Account accountGrisha = new Account("1234", 300.5);
        bank.addAccountToUser(grisha.getPassport(), accountGrisha);

        User oleg = new User("Oleg", "456");
        bank.addUser(oleg);

        Account accountOleg = new Account("5678", 200.7);
        bank.addAccountToUser(oleg.getPassport(), accountOleg);

        boolean methodReturns = bank.transferMoney(
                grisha.getPassport(), accountGrisha.getRequisites(),
                oleg.getPassport(), accountOleg.getRequisites(), 400.5);
        boolean expected = false;

        assertThat(methodReturns, is(expected));
        assertThat(accountGrisha.getValue(), is(300.5));
        assertThat(accountOleg.getValue(), is(200.7));
    }
}
