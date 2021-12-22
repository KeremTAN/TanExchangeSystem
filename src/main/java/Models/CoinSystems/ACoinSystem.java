package Models.CoinSystems;

import Models.AdapterUsdt;
import Models.ECoins;
import Models.StrategyCoins.IExchangeCoins;
import Models.StrategyCoins.UsdtCoinEXch;

import java.text.DecimalFormat;
import java.util.Map;

public abstract class ACoinSystem {

    private double tempCommission;
    public abstract String getName();
    protected abstract Map<ECoins,Double> getAllCoinsOnMarket();
    private IExchangeCoins buySellCoins;
    protected abstract double getCoinSystemCommission();
    protected abstract double getMoneyOfCoinSystem(); // Usdt
    protected abstract void updateCoinSystemMoney();
    private DecimalFormat formatter = new DecimalFormat("##########.###");

    public void printCoinStockInfo() {
        System.out.println("'''''''''''''''''' "+getName()+" ''''''''''''''''''");
        for(Map.Entry<ECoins,Double> allInfo : getAllCoinsOnMarket().entrySet())
            System.out.println(getName()+" has "+allInfo.getKey()+" pieces of "+allInfo.getValue());
        System.out.println(getName()+"'s gain from the transactions made : "+formatter.format(getMoneyOfCoinSystem())+" USDT");
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''\n");
    }

    private void calculateGainOfCoinSystem(double gainOfBank) {
        tempCommission = gainOfBank;
        updateCoinSystemMoney();
    }

    /**
     * getGainOfCoinSystem method to be used updating gain of the coin system on subclasses
     */
    protected double getGainOfCoinSystem(){
        return tempCommission;
    }

    public double buyCoin(double coinQuantity) { //ret usdt
        double realValue=buySellCoins.convertToUSDT(coinQuantity);
        double retUsdt=realValue-(realValue*getCoinSystemCommission());
        System.out.println("!/ "+formatter.format(realValue*getCoinSystemCommission())+" USDT has been cut for this selling process");
        calculateGainOfCoinSystem(realValue*getCoinSystemCommission());
        getAllCoinsOnMarket().replace(buySellCoins.getCoinType(),getAllCoinsOnMarket().get(buySellCoins.getCoinType())+coinQuantity);
        getAllCoinsOnMarket().replace(ECoins.USDT,getAllCoinsOnMarket().get(ECoins.USDT)-retUsdt);
        return  retUsdt;
    }

    public double sellCoin(double usdtQuantity) { /*ret coin*/
        double realValue=buySellCoins.convertToCoin(usdtQuantity);
        double retCoin=realValue-(realValue* getCoinSystemCommission());
        calculateGainOfCoinSystem((realValue* getCoinSystemCommission())*buySellCoins.getCoinValue()); //
        System.out.println("!/ "+formatter.format((realValue* getCoinSystemCommission())*buySellCoins.getCoinValue())+" USDT has been cut for this buying process");// coin converts to usdt for adding its safe of binance
        getAllCoinsOnMarket().replace(buySellCoins.getCoinType(),getAllCoinsOnMarket().get(buySellCoins.getCoinType())-retCoin);
        getAllCoinsOnMarket().replace(ECoins.USDT,getAllCoinsOnMarket().get(ECoins.USDT)+usdtQuantity);
        return retCoin; // coin
    }

    public double tryConvertToUsdt(double tryQuantity){
        double usdt = new AdapterUsdt(new UsdtCoinEXch()).convertToCurrency(tryQuantity);
        calculateGainOfCoinSystem(usdt*getCoinSystemCommission());
        return (usdt-(usdt*getCoinSystemCommission()));
    }

    public double usdtConvertToTry(double usdtQuantity){
        calculateGainOfCoinSystem(usdtQuantity*getCoinSystemCommission());
        usdtQuantity-=(usdtQuantity*getCoinSystemCommission());
        return new AdapterUsdt(new UsdtCoinEXch()).convertToTRY(usdtQuantity); // ret TRY
    }

    public void setBuySellCoins(IExchangeCoins buySellCoins) {
        this.buySellCoins=buySellCoins;
    }
}
