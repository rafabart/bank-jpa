package domain;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account extends IdAbstract<Long> {

    @Column(nullable = false)
    private String numberAccount;

    @Column(nullable = false)
    private String agency;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private Double limitAccount = 500.00;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_person", nullable = false)
    private Person person;

    public void deposit(Double valor) {
        this.balance += valor;
    }

    public boolean withdraw(Double valor) {
        if (valor < this.balance + this.limitAccount) {
            this.balance -= valor;
            return true;
        } else {
            return false;
        }
    }

    public Account(String agency, String numberAccount, Double balance, Double limitAccount, Person person) {
        this.agency = agency;
        this.numberAccount = numberAccount;
        this.balance = balance;
        this.limitAccount = limitAccount;
        this.person = person;
    }

    public Account() {
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getlimitAccount() {
        return limitAccount;
    }

    public void setlimitAccount(Double limitAccount) {
        this.limitAccount = limitAccount;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append(super.toString()).append('\'');
        sb.append(", agency='").append(agency).append('\'');
        sb.append(", numberAccount='").append(numberAccount).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", limitAccount=").append(limitAccount);
        sb.append(", person=").append(person);
        sb.append('}');
        return sb.toString();
    }
}
