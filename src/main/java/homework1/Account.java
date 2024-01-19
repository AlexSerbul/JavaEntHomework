package homework1;

import java.time.LocalDate;
import java.util.Objects;

public class Account {
    private String firstName;
    private String lastName;
    private String country;
    private LocalDate birthdate;
    private double balance;
    private String gender;

    public Account(String firstName, String lastName, String country, LocalDate birthdate, double balance, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.birthdate = birthdate;
        this.balance = balance;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Account)){
            return false;
        }
        Account account = (Account) obj;
        if(account.firstName.equals(this.firstName)
                && account.lastName.equals(this.lastName)
                && account.country.equals(this.country)
                && account.birthdate.equals(this.birthdate)
                && account.balance == this.balance
                && account.gender == this.gender)
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName,lastName,country,birthdate,balance,gender);
    }

    @Override
    public String toString() {
        String tostring = firstName + " " + lastName + "\nCountry: " + country + "\nDate of birth: " + birthdate + "\nGender:" + gender + "\nBalance: " + balance;
        return tostring;
    }
}
