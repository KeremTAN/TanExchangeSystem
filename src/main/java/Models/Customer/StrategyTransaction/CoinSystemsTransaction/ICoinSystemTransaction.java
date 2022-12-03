package Models.Customer.StrategyTransaction.CoinSystemsTransaction;

import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Customer.StrategyTransaction.ITransaction;
import Models.Markets.ECoins;

public interface ICoinSystemTransaction extends ITransaction {
    void transaction(Customer cus, ECoins coin, double quantity, ACoinSystem processCoinSystem);
}
