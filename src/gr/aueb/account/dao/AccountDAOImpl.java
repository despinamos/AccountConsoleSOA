package gr.aueb.account.dao;

import gr.aueb.account.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO{

    private static Long id = 1L;
    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        account.setId(id++);
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Long id, Account account) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    private int getIndexById(Long id) {
        int positionToReturn = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                positionToReturn = i;
                break;
            }
        }

        return positionToReturn;
    }

    @Override
    public Account getById(Long id) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return List.of();
    }

    @Override
    public void deleteBySsn(String ssn) {

    }

    @Override
    public Account getByIban(String iban) {
        return null;
    }

    @Override
    public Account getBySsn(String ssn) {
        return null;
    }

    @Override
    public boolean userIdExists(Long id) {
        return false;
    }

    @Override
    public boolean ssnExists(String ssn) {
        return false;
    }

    @Override
    public boolean ibanExists(String iban) {
        return false;
    }
}
