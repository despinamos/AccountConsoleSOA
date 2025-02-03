package gr.aueb.account.dto;

public class AccountUpdateDTO extends BaseDTO{

    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public AccountUpdateDTO() {}

    public AccountUpdateDTO(Long id, String iban, String firstname,
                            String lastname, String ssn, double balance) {
        setId(id);
        this.iban = iban;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
