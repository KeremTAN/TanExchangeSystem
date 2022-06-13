package Models.Factory.ACoinSystemFactory;

import Models.CoinSystems.ACoinSystem;
import Models.CoinSystems.Binance;

public class BinanceFactory implements ICoinSystemFactory{
    @Override
    public ACoinSystem createCoinSystem() {
        return Binance.getInstance();
    }
}
