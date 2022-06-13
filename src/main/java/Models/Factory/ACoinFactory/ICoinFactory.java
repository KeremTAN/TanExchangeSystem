package Models.Factory.ACoinFactory;


import Models.Markets.ECoins;
import Models.StrategyCoins.IExchangeCoins;

public interface ICoinFactory {
    IExchangeCoins createCoin();
    ECoins getCoinType();
}
