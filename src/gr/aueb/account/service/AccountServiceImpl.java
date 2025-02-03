package gr.aueb.account.service;

import gr.aueb.account.dao.IAccountDAO;
import gr.aueb.account.dto.AccountInsertDTO;
import gr.aueb.account.dto.AccountUpdateDTO;
import gr.aueb.account.exceptions.AccountNotFoundException;
import gr.aueb.account.exceptions.IbanAlreadyExistsException;
import gr.aueb.account.exceptions.SsnAlreadyExistsException;
import gr.aueb.account.model.Account;

import java.util.List;

public class AccountServiceImpl implements IAccountService{

    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public Account insertAccount(AccountInsertDTO accountInsertDTO) throws SsnAlreadyExistsException, IbanAlreadyExistsException {
        Account account;

        try {
            // Take care not o insert two accounts with the same ssn or iban
            if(dao.ssnExists(accountInsertDTO.getSsn())) {
                throw new SsnAlreadyExistsException("User with ssn "
                + accountInsertDTO.getSsn() + " already exists");
            } else if (dao.ibanExists(accountInsertDTO.getIban())) {
                throw new IbanAlreadyExistsException("User with iban "
                + accountInsertDTO.getIban() + " already exists.");
            }

            account = mapInsertDTOToAccount(accountInsertDTO);
            System.err.printf("Account Logger: %s was inserted.\n", account);
            return dao.insert(account);
        } catch(SsnAlreadyExistsException | IbanAlreadyExistsException e) {
            System.err.printf(e.getMessage());
            throw e;
        }
    }

    @Override
    public Account updateAccount(AccountUpdateDTO accountUpdateDTO)
            throws SsnAlreadyExistsException, IbanAlreadyExistsException, AccountNotFoundException {
        Account account;
        Account newAccount;

        try {
            if(!dao.userIdExists(accountUpdateDTO.getId())) {
                throw new AccountNotFoundException("Contact not found.");
            }

            account = dao.getById(accountUpdateDTO.getId());
            boolean isSsnOurOwn = account.getSsn().equals(accountUpdateDTO.getSsn());
            boolean isSsnExists = dao.ssnExists(accountUpdateDTO.getSsn());

            boolean isIbanOurOwn = account.getIban().equals(accountUpdateDTO.getIban());
            boolean isIbanExists = dao.ibanExists(accountUpdateDTO.getIban());

            if(isSsnExists && !isSsnOurOwn) {
                throw new SsnAlreadyExistsException("Contact with ssn " + accountUpdateDTO.getSsn()
                + " already exists");
            }

            if(isIbanExists && !isIbanOurOwn) {
                throw new IbanAlreadyExistsException("Contact with iban " + accountUpdateDTO.getIban()
                        + " already exists");
            }

            newAccount = mapUpdateDTOToAccount(accountUpdateDTO);
            System.err.printf("Account Logger: %s was updated with the following info: %s\n",
                    account, newAccount);
            return dao.update(accountUpdateDTO.getId(), newAccount);
        } catch (SsnAlreadyExistsException | IbanAlreadyExistsException | AccountNotFoundException e) {
            System.err.println(e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteAccountById(Long id) throws AccountNotFoundException {

    }

    @Override
    public Account getAccountByid(Long id) throws AccountNotFoundException {
        return null;
    }

    @Override
    public List<Account> getAllAccounts() {
        return List.of();
    }

    @Override
    public Account getAccountBySsn(String ssn) throws AccountNotFoundException {
        return null;
    }

    @Override
    public Account getAccountByIban(String iban) throws AccountNotFoundException {
        return null;
    }

    @Override
    public void deleteAccountBySsn(String ssn) throws AccountNotFoundException {

    }

    @Override
    public void deleteAccountByIban(String iban) throws AccountNotFoundException {

    }

    private Account mapInsertDTOToAccount(AccountInsertDTO dto) {
        return new Account(null, dto.getIban(), dto.getFirstname(),
                dto.getLastname(), dto.getSsn(), dto.getBalance());
    }

    private Account mapUpdateDTOToAccount(AccountUpdateDTO dto) {
        return new Account(dto.getId(), dto.getIban(), dto.getFirstname(),
                dto.getLastname(), dto.getSsn(), dto.getBalance());
    }
}
