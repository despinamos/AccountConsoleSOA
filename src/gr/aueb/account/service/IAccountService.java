package gr.aueb.account.service;

import gr.aueb.account.dto.AccountInsertDTO;
import gr.aueb.account.dto.AccountUpdateDTO;
import gr.aueb.account.exceptions.AccountNotFoundException;
import gr.aueb.account.exceptions.IbanAlreadyExistsException;
import gr.aueb.account.exceptions.SsnAlreadyExistsException;
import gr.aueb.account.model.Account;

import java.util.List;

public interface IAccountService {

    Account insertAccount(AccountInsertDTO accountInsertDTO)
        throws SsnAlreadyExistsException, IbanAlreadyExistsException;

    Account updateAccount(AccountUpdateDTO accountUpdateDTO)
        throws SsnAlreadyExistsException, IbanAlreadyExistsException,
            AccountNotFoundException;

    void deleteAccountById(Long id) throws AccountNotFoundException;

    Account getAccountByid(Long id) throws AccountNotFoundException;

    List<Account> getAllAccounts();

    Account getAccountBySsn(String ssn) throws AccountNotFoundException;

    Account getAccountByIban(String iban) throws AccountNotFoundException;

    void deleteAccountBySsn(String ssn) throws AccountNotFoundException;

    void deleteAccountByIban(String iban) throws AccountNotFoundException;
}
