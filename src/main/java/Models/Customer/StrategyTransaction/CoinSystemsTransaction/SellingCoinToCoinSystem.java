package Models.Customer.StrategyTransaction.CoinSystemsTransaction;

import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Markets.ECoins;

public class SellingCoinToCoinSystem implements ICoinSystemTransaction{
    @Override
    public void transaction(Customer cus, ECoins coin, double coinQuantity, ACoinSystem processCoinSystem) {
        if (cus.getCoins().containsKey(coin)) {
            if (coinQuantity <= cus.getCoins().get(coin)) {
                cus.getCoins().replace(coin,cus.getCoins().get(coin)-coinQuantity);
                System.out.println("-/ "+cus.getFirstName()+" "+cus.getLastName()+" has sold "+formatter.format(coinQuantity)+" "+coin.toString()+" to "+processCoinSystem.getName());
                double usdt = processCoinSystem.buyCoin(coin, coinQuantity);
                cus.setCoins(ECoins.USDT,usdt);
            }
            else System.out.println("!/ There is not enough money("+coin.toString()+") on your account for selling to the CoinSystem");
        }
        else System.out.println("!/ You do not have money("+coin.toString()+") for selling");
    }
}
