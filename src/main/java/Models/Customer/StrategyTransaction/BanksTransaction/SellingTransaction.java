package Models.Customer.StrategyTransaction.BanksTransaction;

import Models.Banks.ABanks;
import Models.Customer.Customer;
import Models.Markets.EMoney;

public class SellingTransaction implements IBankTransaction {
    @Override
    public void transaction(Customer cus, EMoney money, double currencyQuantity, ABanks processBank) {
        if (cus.getBalance().containsKey(money)) {
            if (currencyQuantity <= cus.getBalance().get(money)) {
                cus.getBalance().replace(money,cus.getBalance().get(money)-currencyQuantity);
                System.out.println("-/ "+cus.getFirstName()+" "+cus.getLastName()+" has sold "+formatter.format(currencyQuantity)+" "+money.toString()+" to "+processBank.getName());
                double tryQ = processBank.buyMoney(money, currencyQuantity);
                cus.setBalance(EMoney.TRY,tryQ);
            }
            else System.out.println("!/ There is not enough money("+money.toString()+") on your account for selling to the Bank");
        }
        else System.out.println("!/ You do not have money("+money.toString()+") for selling");
    }
}
