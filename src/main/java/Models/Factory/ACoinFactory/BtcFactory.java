package Models.Factory.ACoinFactory;

import Models.Markets.ECoins;
import Models.StrategyCoins.BtcCoinExch;
import Models.StrategyCoins.IExchangeCoins;

public class BtcFactory implements ICoinFactory{
    @Override
    public IExchangeCoins createCoin() {
        return new BtcCoinExch();
    }

    @Override
    public ECoins getCoinType() {
        return ECoins.BTC;
    }
}
