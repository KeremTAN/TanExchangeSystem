package Models;

import Models.Banks.ABanks;
import Models.CoinSystems.ACoinSystem;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Customer {
    private Map<String, String> stringProperties = new HashMap<>();
    private Map<EMoney,Double> balance = new HashMap<>();
    private Map<ECoins,Double> coins = new HashMap<>();
    DecimalFormat formatter = new DecimalFormat("##########.###");

    public Customer(String firstName, String lastName, String tcId, String address, String phoneNumber, String emailAddress, double creditScore, boolean married, double age, boolean criminalRecord) {
        Random r = new Random();
        stringProperties.put("firstname",firstName);
        stringProperties.put("lastname",lastName);
        stringProperties.put("tcId",tcId);
        stringProperties.put("address",address);
        stringProperties.put("phoneNumber",phoneNumber);
        stringProperties.put("emailAddress",emailAddress);
        stringProperties.put("creditScore",String.valueOf(creditScore));
        stringProperties.put("age",String.valueOf(age));
        stringProperties.put("married",String.valueOf(married));
        stringProperties.put("criminalRecord", String.valueOf(criminalRecord));
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

    private String getProperty(String propertyName){
        return stringProperties.get(propertyName);
    }

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
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has bought "+formatter.format(currency)+" "+money.toString()+" from "+processBank.getName());
            }
            else System.out.println("-/ There is not enough TRY on your account for buying("+money.toString()+") from the Bank");
        }
    }

    public void sellMoneyToBank(EMoney money, double currencyQuantity, ABanks processBank) {
        if (balance.containsKey(money)) {
            if (currencyQuantity <= balance.get(money)) {
                balance.replace(money,balance.get(money)-currencyQuantity);
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has sold "+formatter.format(currencyQuantity)+" "+money.toString()+" to "+processBank.getName());
                double tryQ = processBank.buyMoney(currencyQuantity);
                setBalance(EMoney.TRY,tryQ);
            }
            else System.out.println("-/ There is not enough money("+money.toString()+") on your account for selling to the Bank");
        }
        else System.out.println("-/ You do not have money("+money.toString()+") for selling");
    }

    public void buyCoinFromSystem(ECoins coin, double usdtQuantity, ACoinSystem processSystem) {
        if (coins.containsKey(ECoins.USDT)) {
            if (usdtQuantity <= coins.get(ECoins.USDT)) {
                coins.replace(ECoins.USDT,coins.get(ECoins.USDT)-usdtQuantity);
                double currency = processSystem.sellCoin(usdtQuantity);
                setCoins(coin,currency);
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has bought "+formatter.format(currency)+" "+coin.toString()+" from "+processSystem.getName());
            }
            else System.out.println("-/ There is not enough USDT on your account for buying("+coin.toString()+") from the Bank");
        }
        else System.out.println("-/ You do not have "+coin.toString()+" for buying");
    }

    public void sellCoinToSystem(ECoins coin, double coinQuantity, ACoinSystem processSystem) {
        if (coins.containsKey(coin)) {
            if (coinQuantity <= coins.get(coin)) {
                coins.replace(coin,coins.get(coin)-coinQuantity);
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has sold "+formatter.format(coinQuantity)+" "+coin.toString()+" to "+processSystem.getName());
                double usdt = processSystem.buyCoin(coinQuantity);
                setCoins(ECoins.USDT,usdt);
            }
            else System.out.println("-/ There is not enough money("+coin.toString()+") on your account for selling to the Bank");
        }
        else System.out.println("-/ You do not have money("+coin.toString()+") for selling");
    }

    public void buyUsdt(double tryQuantity, ACoinSystem processSystem){
        if (balance.containsKey(EMoney.TRY)) {
            if (tryQuantity <= balance.get(EMoney.TRY)) {
                balance.replace(EMoney.TRY, balance.get(EMoney.TRY) - tryQuantity);
                double usdt = processSystem.tryConvertToUsdt(tryQuantity);
                setCoins(ECoins.USDT, usdt);
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has bought "+formatter.format(usdt)+" USDT from "+processSystem.getName());
            }
            else System.out.println("-/ There is not enough TRY on your account for buying(USDT) from the Bank");
        }
        else System.out.println("-/ You do not have TRY for buying");
    }

    public void sellUsdt(double usdtQuantity, ACoinSystem processSystem){
        if (coins.containsKey(ECoins.USDT)) {
            if (usdtQuantity <= coins.get(ECoins.USDT)) {
                coins.replace(ECoins.USDT, coins.get(ECoins.USDT) - usdtQuantity);
                System.out.println("+/ "+getProperty("firstname")+" "+getProperty("lastname")+" has sold "+formatter.format(usdtQuantity)+" USDT to "+processSystem.getName());
                double tryQ = processSystem.usdtConvertToTry(usdtQuantity);
                setBalance(EMoney.TRY,tryQ);
            }
        }
    }

    public void printGoodsAndChattelsOfCustomer(){
        for(Map.Entry<EMoney, Double> m : balance.entrySet())
            System.out.println("| "+getProperty("firstname")+" "+getProperty("lastname")+" has "+formatter.format(m.getValue())+" pieces of "+m.getKey().toString());

        for(Map.Entry<ECoins, Double> m : coins.entrySet())
            System.out.println("| "+getProperty("firstname")+" "+getProperty("lastname")+" has "+formatter.format(m.getValue())+" pieces of "+m.getKey().toString());
    }

 /*   public void setDebt(EMoney money, double quantity) {
        if (debt.containsKey(money))
            debt.replace(money, debt.get(money)-quantity);
        else debt.put(money,-quantity);
    }*/
}
