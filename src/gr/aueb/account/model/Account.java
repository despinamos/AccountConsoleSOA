package gr.aueb.account.model;

import java.util.Objects;

public class Account extends AbstractEntity{

    private String iban;
    private String firstname;
    private String lastname;
    private String ssn;
    private double balance;

    public Account() {}

    public Account(Long id, String iban, String firstname, String lastname, String ssn, double balance) {
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

    @Override
    public String toString() {
        return "Iban: " + iban + ", Firstname: " + firstname +
                ", Lastname: " + lastname + ", Ssn: " + ssn +
                ", Balance: " + balance;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Account that)) return false;
        return Objects.equals(getIban(), that.getIban())
                && Objects.equals(getFirstname(), that.getFirstname())
                && Objects.equals(getLastname(), that.getLastname())
                && Objects.equals(getSsn(), that.getSsn())
                && Objects.equals(getBalance(), that.getBalance());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIban(), getFirstname(),
                getLastname(), getSsn(), getBalance());
    }
}
