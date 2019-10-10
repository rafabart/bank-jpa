package dao;

import domain.Account;

public class AccountDao extends GenericDao<Account, Long> {
    public AccountDao() {
        super(Account.class);
    }
}