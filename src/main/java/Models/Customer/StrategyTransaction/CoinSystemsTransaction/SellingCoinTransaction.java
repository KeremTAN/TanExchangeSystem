package Models.Customer.StrategyTransaction.CoinSystemsTransaction;

import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Markets.ECoins;

public class SellingCoinTransaction implements ICoinSystemTransaction{
    @Override
    public void transaction(Customer cus, ECoins coin, double quantity, ACoinSystem processCoinSystem) {

    }
}
