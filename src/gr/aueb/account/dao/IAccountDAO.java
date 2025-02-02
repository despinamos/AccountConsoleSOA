package gr.aueb.account.dao;

import gr.aueb.account.model.Account;

import java.util.List;

public interface IAccountDAO {

    // Basic CRUD actions (add, update, delete, getOne, getAll)

    Account insert(Account account);
    Account update(Long id, Account account);
    void deleteById(Long id);
    Account getById(Long id);
    List<Account> getAll();

    // Additional contextual CRUD specific to the class
    void deleteBySsn(String ssn);

    // Additional Queries
    Account getByIban(String iban);
    Account getBySsn(String ssn);
    boolean userIdExists(Long id);
    boolean ssnExists(String ssn);
    boolean ibanExists(String iban);
}
