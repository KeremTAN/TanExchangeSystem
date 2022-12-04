package Models.Customer.StrategyTransaction.BanksTransaction;

import Models.Banks.ABanks;
import Models.Customer.Customer;
import Models.Markets.EMoney;

public class BuyingMoneyFromBank implements IBankTransaction {
    @Override
    public void transaction(Customer cus, EMoney money, double tryQuantity, ABanks processBank) {
        if (cus.getBalance().containsKey(EMoney.TRY)) {
            if (tryQuantity <= cus.getBalance().get(EMoney.TRY)) {
                cus.getBalance().replace(EMoney.TRY,cus.getBalance().get(EMoney.TRY)-tryQuantity);
                double currency = processBank.sellMoney(money, tryQuantity);
                cus.setBalance(money,currency);
                System.out.println("+/ "+cus.getFirstName()+" "+cus.getLastName()+" has bought "+formatter.format(currency)+" "+money.toString()+" from "+processBank.getName());
            }
            else System.out.println("!/ There is not enough TRY on your account for buying("+money.toString()+") from the Bank");
        }
    }
}
