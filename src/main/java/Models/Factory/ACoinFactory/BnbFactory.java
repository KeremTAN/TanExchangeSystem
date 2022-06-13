package Models.Factory.ACoinFactory;

import Models.Markets.ECoins;
import Models.StrategyCoins.BnbCoinExch;
import Models.StrategyCoins.IExchangeCoins;

public class BnbFactory implements ICoinFactory{
    @Override
    public IExchangeCoins createCoin() {
        return new BnbCoinExch();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BNB;
    }
}
