package ru.job4j.collections.banktransfers;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 */
public class BankTest {

    /**
     * Test addUser.
     */
    @Test
    public void whenAddUserThenUserIsInStorage() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        bank.addUser(user);
        User expected = user;
        User result = bank.findUserInStorage(user.getPassport());
        assertThat(result, is(expected));
    }

    /**
     * Test deleteUser.
     */
    @Test
    public void whenDeleteUserThenUserIsNotInStorage() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        bank.addUser(user);
        bank.deleteUser(user);
        User expected = null;
        User result = bank.findUserInStorage(user.getPassport());
        assertThat(result, is(expected));
    }

    /**
     * Test addAccount.
     */
    @Test
    public void whenAddAccountThenUserHasAccount() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        Account account = new Account(150, "1234");
        bank.addUser(user);
        bank.addAccount(user, account);
        List<Account> list = bank.getUserAccounts(user);
        Account expected = account;
        Account result = list.get(list.indexOf(account));
        assertThat(result, is(expected));
    }

    /**
     * Test deleteAccount.
     */
    @Test
    public void whenDeleteAccountThenUserHasNoAccount() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        Account account = new Account(150, "1234");
        bank.addUser(user);
        bank.addAccount(user, account);
        bank.deleteAccount(user, account);
        List<Account> list = bank.getUserAccounts(user);
        boolean expected = false;
        boolean result = list.contains(account);
        assertThat(result, is(expected));
    }

    /**
     * Test getUserAccounts.
     */
    @Test
    public void whenAddAccountThenGetListWithUserAccounts() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        Account account1 = new Account(150, "1234");
        bank.addUser(user);
        bank.addAccount(user, account1);
        List<Account> expected = new ArrayList<>();
        expected.add(account1);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    /**
     * Test findUserInStorage.
     */
    @Test
    public void whenAddUserThenFindUserInStorage() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        bank.addUser(user);
        User expected = bank.findUserInStorage("1234");
        User result = user;
        assertThat(expected, is(result));
    }

    /**
     * Test findUserInStorage.
     */
    @Test
    public void whenAddAccountThenFindAccountInStorage() {
        Bank bank = new Bank();
        User user = new User("Oleg", "1234");
        Account account = new Account(150, "12345");
        bank.addUser(user);
        bank.addAccount(user, account);
        Account expected = bank.findAccountInStorage("12345");
        Account result = account;
        assertThat(expected, is(result));
    }

    /**
     * Test transferMoney.
     */
    @Test
    public void whenCorrectParametersThenTransferIsPass() {
        Bank bank = new Bank();
        User user1 = new User("Oleg", "2");
        User user2 = new User("Ivan", "7");
        Account account1 = new Account(750, "21");
        Account account2 = new Account(500, "71");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount(user1, account1);
        bank.addAccount(user2, account2);
        boolean expected = true;
        boolean result = bank.transferMoney("2", "21", "7", "71", 50);
        assertThat(result, is(expected));
    }

    /**
     * Test transferMoney.
     */
    @Test
    public void whenIncorrectParametersThenTransferIsNotPass() {
        Bank bank = new Bank();
        User user1 = new User("Oleg", "2");
        User user2 = new User("Ivan", "7");
        Account account1 = new Account(750, "21");
        Account account2 = new Account(500, "71");
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccount(user1, account1);
        bank.addAccount(user2, account2);
        boolean expected = false;
        boolean result = bank.transferMoney("21234", "21", "7", "71", 50);
        assertThat(result, is(expected));
    }
}