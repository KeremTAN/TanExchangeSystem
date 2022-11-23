package Models.Customer;

import Models.Markets.ECoins;
import Models.Markets.EMoney;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CustomerBuilder {
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String tcId;
    private String phoneNumber;

    private int age;
    private double creditScore;

    private boolean isMarried;
    private boolean hasCriminalRecord;

    private char gender = 'X';

    private Map<EMoney,Double> balance = new HashMap<>();
    private Map<ECoins,Double> coins = new HashMap<>();

    private void randomMoneyAndCoinsGenerate(){
        Random r = new Random();
        balance.put(EMoney.TRY,r.nextDouble()*10000);
        balance.put(EMoney.USD,r.nextDouble()*1000);
        balance.put(EMoney.EUR,r.nextDouble()*1000);
        balance.put(EMoney.CHF,r.nextDouble()*1000);
        balance.put(EMoney.Gold,r.nextDouble()*10);
        coins.put(ECoins.USDT,r.nextDouble()*10000);
        coins.put(ECoins.BNB,r.nextDouble()*1000);
        coins.put(ECoins.ETH,r.nextDouble()*1000);
        coins.put(ECoins.ALGO,r.nextDouble()*1000);
    }

    public static CustomerBuilder createCustomer(String firstName, String lastName, String tcId, String phoneNumber, char gender){
        CustomerBuilder builder = new CustomerBuilder();
        builder.firstName=firstName;
        builder.lastName=lastName;
        builder.tcId=tcId;
        builder.phoneNumber=phoneNumber;
        builder.gender=gender;

        return builder;
    }
    public static CustomerBuilder createGreatCustomer(String firstName, String lastName, String tcId, String phoneNumber, char gender){
        CustomerBuilder builder = new CustomerBuilder();
        builder.firstName=firstName;
        builder.lastName=lastName;
        builder.tcId=tcId;
        builder.phoneNumber=phoneNumber;
        builder.gender=gender;

        builder.isMarried=true;
        builder.hasCriminalRecord=false;
        return builder;
    }

    public Customer buildCustomer(){
        randomMoneyAndCoinsGenerate();

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAddress(address);
        customer.setEmailAddress(emailAddress);
        customer.setTcId(tcId);
        customer.setAge(age);
        customer.setPhoneNumber(phoneNumber);
        customer.setCreditScore(creditScore);
        customer.setMarried(isMarried);
        customer.setHasCriminalRecord(hasCriminalRecord);
        customer.setGender(gender);
        customer.setBalance(balance);
        customer.setCoins(coins);

        return customer;
    }

    public CustomerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public CustomerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public CustomerBuilder setCreditScore(double creditScore) {
        this.creditScore = creditScore;
        return this;
    }

    public CustomerBuilder setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
        return this;
    }

    public CustomerBuilder setHasCriminalRecord(boolean hasCriminalRecord) {
        this.hasCriminalRecord = hasCriminalRecord;
        return this;
    }

    public CustomerBuilder setBalance(Map<EMoney, Double> balance) {
        this.balance = balance;
        return this;
    }

    public CustomerBuilder setCoins(Map<ECoins, Double> coins) {
        this.coins = coins;
        return this;
    }
}
