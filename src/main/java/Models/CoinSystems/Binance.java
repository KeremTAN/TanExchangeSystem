package Models.CoinSystems;

import Models.Markets.ECoins;
import java.util.HashMap;
import java.util.Map;

public class Binance extends ACoinSystem {
    private final String name="BINANCE";
    private static Map<ECoins,Double> allCoinsOnMarket = new HashMap<>();
    private double binanceCommission=0.0003;
    private static double moneyOfBinance=0.0; // Usdt
    private static Binance instance;

    private Binance() { //Singleton
        allCoinsOnMarket.put(ECoins.USDT,9565840.0);
        allCoinsOnMarket.put(ECoins.BTC,5845.0);
        allCoinsOnMarket.put(ECoins.ETH,90855.0);
        allCoinsOnMarket.put(ECoins.BNB,3905878.0);
        allCoinsOnMarket.put(ECoins.ALGO,965840.0);
        allCoinsOnMarket.put(ECoins.ADA,7565480.0);
    }

    public static Binance getInstance() {
        if (instance==null) {
            synchronized (Binance.class) {
                instance = new Binance();
            }
        }
        return instance;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    protected Map<ECoins, Double> getAllCoinsOnMarket() {
        return allCoinsOnMarket;
    }

    @Override
    protected double getCoinSystemCommission() {
        return this.binanceCommission;
    }

    @Override
    protected double getMoneyOfCoinSystem() {
        return moneyOfBinance;
    }

    @Override
    protected void updateCoinSystemMoney() {
        moneyOfBinance+=getGainOfCoinSystem();
    }
}
