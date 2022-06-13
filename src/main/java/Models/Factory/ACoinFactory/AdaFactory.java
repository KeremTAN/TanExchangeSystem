package Models.Factory.ACoinFactory;

import Models.Markets.ECoins;
import Models.StrategyCoins.AdaCoinExch;
import Models.StrategyCoins.IExchangeCoins;

public class AdaFactory implements ICoinFactory{
    @Override
    public IExchangeCoins createCoin() {
        return new AdaCoinExch();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.ADA;
    }
}
