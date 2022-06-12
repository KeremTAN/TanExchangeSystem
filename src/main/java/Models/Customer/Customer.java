package Models.Customer;

import Models.Banks.ABanks;
import Models.CoinSystems.ACoinSystem;
import Models.Markets.*;
import java.util.Map;
import java.text.DecimalFormat;

public class Customer {
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

    private char gender;

    private Map<EMoney,Double> balance;
    private Map<ECoins,Double> coins;
    DecimalFormat formatter = new DecimalFormat("##########.###");

    private void setBalance(EMoney money, double quantity) {
        if (balance.containsKey(money))
            balance.replace(money, balance.get(money)+quantity);
        else balance.put(money,quantity);
    }

    private void setCoins(ECoins coin, double quantity) {
        if(coins.containsKey(coin))
            coins.replace(coin, coins.get(coin)+quantity);
        else coins.put(coin, quantity);
    }

    public void buyMoneyFromBank(EMoney money, double tryQuantity, ABanks processBank) {
        if (balance.containsKey(EMoney.TRY)) {
            if (tryQuantity <= balance.get(EMoney.TRY)) {
                balance.replace(EMoney.TRY,balance.get(EMoney.TRY)-tryQuantity);
                double currency = processBank.sellMoney(tryQuantity);
                setBalance(money,currency);
                System.out.println("+/ "+getFirstName()+" "+getLastName()+" has bought "+formatter.format(currency)+" "+money.toString()+" from "+processBank.getName());
            }
            else System.out.println("!/ There is not enough TRY on your account for buying("+money.toString()+") from the Bank");
        }
    }

    public void sellMoneyToBank(EMoney money, double currencyQuantity, ABanks processBank) {
        if (balance.containsKey(money)) {
            if (currencyQuantity <= balance.get(money)) {
                balance.replace(money,balance.get(money)-currencyQuantity);
                System.out.println("-/ "+getFirstName()+" "+getLastName()+" has sold "+formatter.format(currencyQuantity)+" "+money.toString()+" to "+processBank.getName());
                double tryQ = processBank.buyMoney(currencyQuantity);
                setBalance(EMoney.TRY,tryQ);
            }
            else System.out.println("!/ There is not enough money("+money.toString()+") on your account for selling to the Bank");
        }
        else System.out.println("!/ You do not have money("+money.toString()+") for selling");
    }

    public void buyCoinFromSystem(ECoins coin, double usdtQuantity, ACoinSystem processSystem) {
        if (coins.containsKey(ECoins.USDT)) {
            if (usdtQuantity <= coins.get(ECoins.USDT)) {
                coins.replace(ECoins.USDT,coins.get(ECoins.USDT)-usdtQuantity);
                double currency = processSystem.sellCoin(usdtQuantity);
                setCoins(coin,currency);
                System.out.println("+/ "+getFirstName()+" "+getLastName()+" has bought "+formatter.format(currency)+" "+coin.toString()+" from "+processSystem.getName());
            }
            else System.out.println("!/ There is not enough USDT on your account for buying("+coin.toString()+") from the CoinSystem");
        }
        else System.out.println("!/ You do not have "+coin.toString()+" for buying");
    }

    public void sellCoinToSystem(ECoins coin, double coinQuantity, ACoinSystem processSystem) {
        if (coins.containsKey(coin)) {
            if (coinQuantity <= coins.get(coin)) {
                coins.replace(coin,coins.get(coin)-coinQuantity);
                System.out.println("-/ "+getFirstName()+" "+getLastName()+" has sold "+formatter.format(coinQuantity)+" "+coin.toString()+" to "+processSystem.getName());
                double usdt = processSystem.buyCoin(coinQuantity);
                setCoins(ECoins.USDT,usdt);
            }
            else System.out.println("!/ There is not enough money("+coin.toString()+") on your account for selling to the CoinSystem");
        }
        else System.out.println("!/ You do not have money("+coin.toString()+") for selling");
    }

    public void buyUsdt(double tryQuantity, ACoinSystem processSystem){
        if (balance.containsKey(EMoney.TRY)) {
            if (tryQuantity <= balance.get(EMoney.TRY)) {
                balance.replace(EMoney.TRY, balance.get(EMoney.TRY) - tryQuantity);
                double usdt = processSystem.tryConvertToUsdt(tryQuantity);
                setCoins(ECoins.USDT, usdt);
                System.out.println("+/ "+getFirstName()+" "+getLastName()+" has bought "+formatter.format(usdt)+" USDT from "+processSystem.getName());
            }
            else System.out.println("!/ There is not enough TRY on your account for buying(USDT) from the CoinSystem");
        }
        else System.out.println("!/ You do not have TRY for buying");
    }

    public void sellUsdt(double usdtQuantity, ACoinSystem processSystem){
        if (coins.containsKey(ECoins.USDT)) {
            if (usdtQuantity <= coins.get(ECoins.USDT)) {
                coins.replace(ECoins.USDT, coins.get(ECoins.USDT) - usdtQuantity);
                System.out.println("-/ "+getFirstName()+" "+getLastName()+" has sold "+formatter.format(usdtQuantity)+" USDT to "+processSystem.getName());
                double tryQ = processSystem.usdtConvertToTry(usdtQuantity);
                setBalance(EMoney.TRY,tryQ);
            }
        }
    }

    public void printGoodsAndChattelsOfCustomer(){
        for(Map.Entry<EMoney, Double> m : balance.entrySet())
            System.out.println("| "+getFirstName()+" "+getLastName()+" has "+formatter.format(m.getValue())+" pieces of "+m.getKey().toString());

        for(Map.Entry<ECoins, Double> m : coins.entrySet())
            System.out.println("| "+getFirstName()+" "+getLastName()+" has "+formatter.format(m.getValue())+" pieces of "+m.getKey().toString());
    }

/*    public void setDebt(EMoney money, double quantity) {
        if (debt.containsKey(money))
            debt.replace(money, debt.get(money)-quantity);
        else debt.put(money,-quantity);
    }*/

    /**
     *
     * GETTERS & SETTERS
     *
     */

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTcId() {
        return tcId;
    }

    public void setTcId(String tcId) {
        this.tcId = tcId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(double creditScore) {
        this.creditScore = creditScore;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public boolean hasCriminalRecord() {
        return hasCriminalRecord;
    }

    public void setHasCriminalRecord(boolean hasCriminalRecord) {
        this.hasCriminalRecord = hasCriminalRecord;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Map<EMoney, Double> getBalance() {
        return balance;
    }

    public void setBalance(Map<EMoney, Double> balance) {
        this.balance = balance;
    }

    public Map<ECoins, Double> getCoins() {
        return coins;
    }

    public void setCoins(Map<ECoins, Double> coins) {
        this.coins = coins;
    }
}
