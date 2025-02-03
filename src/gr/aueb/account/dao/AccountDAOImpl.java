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
        accounts.set(getIndexById(id), account);
        return account;
    }

    @Override
    public void deleteById(Long id) {
        accounts.removeIf(account -> account.getId().equals(id));
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

    private int getIndexByIban(String iban) {
        int positionToReturn = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getIban().equals(iban)) {
                positionToReturn = i;
                break;
            }
        }

        return positionToReturn;
    }

    private int getIndexBySsn(String ssn) {
        int positionToReturn = -1;

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getSsn().equals(ssn)) {
                positionToReturn = i;
                break;
            }
        }

        return positionToReturn;
    }

    @Override
    public Account getById(Long id) {
        int position = getIndexById(id);
        return (position != -1) ? accounts.get(getIndexById(id)) : null;
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public void deleteBySsn(String ssn) {
        accounts.removeIf(account -> account.getSsn().equals(ssn));
    }

    @Override
    public Account getByIban(String iban) {
        int position = getIndexByIban(iban);
        return (position != -1) ? accounts.get(getIndexByIban(iban)) : null;
    }

    @Override
    public Account getBySsn(String ssn) {
        int position = getIndexBySsn(ssn);
        return (position != -1) ? accounts.get(getIndexBySsn(ssn)) : null;
    }

    @Override
    public boolean userIdExists(Long id) {
        int position = getIndexById(id);
        return position != -1;
    }

    @Override
    public boolean ssnExists(String ssn) {
        int position = getIndexBySsn(ssn);
        return position != -1;
    }

    @Override
    public boolean ibanExists(String iban) {
        int position = getIndexByIban(iban);
        return position != -1;
    }
}
