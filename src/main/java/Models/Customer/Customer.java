package Models.Customer;

import Models.Customer.StrategyTransaction.ITransaction;
import Models.Markets.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Map;

@Getter
@Setter
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


    public void setBalance(EMoney money, double quantity) {
        if (balance.containsKey(money))
            balance.replace(money, balance.get(money)+quantity);
        else balance.put(money,quantity);
    }

    public void setCoins(ECoins coin, double quantity) {
        if(coins.containsKey(coin))
            coins.replace(coin, coins.get(coin)+quantity);
        else coins.put(coin, quantity);
    }

/* ADAPTER
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
*/
    public void printGoodsAndChattelsOfCustomer(){
        for(Map.Entry<EMoney, Double> m : balance.entrySet())
            System.out.println("| "+getFirstName()+" "+getLastName()+" has "+ ITransaction.formatter.format(m.getValue())+" pieces of "+m.getKey().toString());

        for(Map.Entry<ECoins, Double> m : coins.entrySet())
            System.out.println("| "+getFirstName()+" "+getLastName()+" has "+ITransaction.formatter.format(m.getValue())+" pieces of "+m.getKey().toString());
    }

/*    public void setDebt(EMoney money, double quantity) {
        if (debt.containsKey(money))
            debt.replace(money, debt.get(money)-quantity);
        else debt.put(money,-quantity);
    }*/
}
