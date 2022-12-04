package Models.Customer.StrategyTransaction.CoinSystemsTransaction;

import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Markets.ECoins;

public class BuyingCoinFromCoinSystem implements ICoinSystemTransaction{
    @Override
    public void transaction(Customer cus, ECoins coin, double usdtQuantity, ACoinSystem processCoinSystem) {
        if (cus.getCoins().containsKey(ECoins.USDT)) {
            if (usdtQuantity <= cus.getCoins().get(ECoins.USDT)) {
                cus.getCoins().replace(ECoins.USDT,cus.getCoins().get(ECoins.USDT)-usdtQuantity);
                double currency = processCoinSystem.sellCoin(coin, usdtQuantity);
                cus.setCoins(coin,currency);
                System.out.println("+/ "+cus.getFirstName()+" "+cus.getLastName()+" has bought "+formatter.format(currency)+" "+coin.toString()+" from "+processCoinSystem.getName());
            }
            else System.out.println("!/ There is not enough USDT on your account for buying("+coin.toString()+") from the CoinSystem");
        }
        else System.out.println("!/ You do not have "+coin.toString()+" for buying");
    }
}
