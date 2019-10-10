package test;

import dao.AccountDao;
import domain.Account;
import domain.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AccountDaoTest {

    final AccountDao accountDao = new AccountDao();

    Person person1 = new Person("111.222.333-11", "Rafael");
    Person person2 = new Person("444.555.666-77", "Marinho");
    Person person3 = new Person("888.999.111-22", "Mola");

    Account account1 = new Account(
            "2407",
            "88965",
            15000.00,
            1000.00,
            person1
    );
    Account account2 = new Account(
            "3302",
            "112546",
            100.00,
            500.00,
            person2
    );
    Account account3 = new Account(
            "9965",
            "02102",
            2500.00,
            750.00,
            person1
    );

    @Before
    public void beforeAll() {

        System.out.println("Executando testes da Classe PersonDao...");
    }

    @Test
    public void insert() {

        System.out.println("Inserindo account -------------------------------------------");

        accountDao.insert(account1);
        accountDao.insert(account2);
        accountDao.insert(account3);

        System.out.println("Listando todos os account -------------------------------------------");
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        Assert.assertEquals(3, accounts.size());
    }
}
