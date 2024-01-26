package homework2;

import homework1.Account;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class AccountService {

//    метод повертає List акаунтів, в яких баланс більше 500. приймає список акаунтів
    public List<Account> getAccountsBalance500(List<Account> accounts){
        return accounts.stream()
                .filter(account -> account.getBalance()>500)
                .collect(Collectors.toList());
    }

//    метод повертає Set назв країн. приймає список акаунтів
    public Set<String> getCountriesSet (List<Account> accounts){
        return accounts.stream()
                .map(Account::getCountry)
                .collect(Collectors.toSet());
    }

//    метод повертає boolean перевіряючи чи є серед акаунтів хтось молодше 2000 р.н. приймає список акаунтів
    public boolean isYoungerThen2000 (List<Account> accounts){
        return accounts.stream()
                .anyMatch(account -> account.getBirthdate().isBefore(LocalDate.of(2000,01,01)));
    }

//    метод отримує ???повертає??? суму всіх балансів акаунтів чоловічої статі. приймає список акаунтів
    public double getMaleBalance (List<Account> accounts){
        return accounts.stream()
                .filter(account -> account.getGender().equals("Male"))
                .collect(Collectors.summingDouble(Account::getBalance));
    }

//    метод повертає акаунти груповані по місяцю народження. приймає список акаунтів
    public Map<Month, List<Account>> groupByMonth(List<Account> accounts){
        return accounts.stream()
                .collect(Collectors.groupingBy(account -> account.getBirthdate().getMonth()));
    }

//    метод повертає середній баланс акаунтів залежно від держави. приймає список акаунтів і державу по якій треба шукати
    public double getAverageBalanceForCountry(List<Account> accounts,String country){
        return accounts.stream()
                .filter(account -> account.getCountry().equals(country))
                .collect(Collectors.averagingDouble(Account::getBalance));
    }

//    метод повертає імя+фамілія працівників через кому, параметром методу є (List<List<Account>> accountsLists)]
    public String getNames(List<List<Account>> accountsLists){
        List<String> fullNames = new ArrayList<>();
        accountsLists.stream()
                .flatMap(List::stream)
                .forEach(account -> fullNames.add(account.getFirstName()+" "+account.getLastName()));
        return fullNames.stream()
                .collect(Collectors.joining(", "));
    }

//    метод повертає відсортований список всіх акаунтів за прізвищем і за ім.ям
    public List<Account> sortByFullName(List<Account> accounts){
        Comparator<Account> compareByLastName = Comparator.comparing(Account::getLastName);
        Comparator<Account> compareByFirstName = Comparator.comparing(Account::getFirstName);
        Comparator<Account> comparator = compareByLastName.thenComparing(compareByFirstName);
        return accounts.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

//    метод який повертає найстарший акаунт. приймає список акаунтів
    public Account getOldestAccount(List<Account> accounts){
        return accounts.stream()
                .min(Comparator.comparing(Account::getBirthdate))
                .get();

    }
//    метод повертає Map груповану по року народження та середньому балансу
    public Map<Integer, Double> getMap(List<Account> accounts){
        return accounts.stream()
                .collect(Collectors.groupingBy((account -> account.getBirthdate().getYear()),Collectors.averagingDouble(Account::getBalance)));
    }

//    метод який повертає акаунт з найдовшим прізвищем
    public Account getLongestSurnameAccount(List<Account> accounts){
        return accounts.stream()
                .max(Comparator.comparing(account -> account.getLastName().length()))
                .get();
    }
}
