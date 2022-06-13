package Controls;

import Models.Banks.ABanks;
import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Factory.*;
import Models.Factory.ABankFactory.IBankFactory;
import Models.Factory.ACoinFactory.ICoinFactory;
import Models.Factory.AMoneyFactory.IMoneyFactory;
import Models.Markets.*;
import Models.StrategyCoins.UsdtCoinEXch;

public class Facade {
    private static Facade instance;
    private ABanks processBank;
    private ACoinSystem processCoinSystem;

    private Facade(){ }

    public static Facade getInstance(){
        if(instance==null) {
            synchronized (Facade.class){
                instance=new Facade();
                System.out.println("FACADE INSTANCE CREATED!!");
            }
        }
        else System.out.println("YOU HAVE ALREADY FACADE INSTANCE!");
        return instance;
    }

    public void printAllGains(){
//        tcIsBank.printReserveInfo();
//        yapiKrediBank.printReserveInfo();
//        binance.printCoinStockInfo();
//        kuCoin.printCoinStockInfo();
    }

    public void printInfo(Customer c){
        c.printGoodsAndChattelsOfCustomer();
    }

    /** BANK SYSTEMS **/

    /**
     * getMoney() method of IMoneyFactory returns EMoney type
     * **/
    public void customerBuysCurrency(Customer customer, IBankFactory bankFactory, double tryQuantity, IMoneyFactory moneyFactory){
        processBank = bankFactory.createBank();
        processBank.setBuySellMoney(moneyFactory.createMoney());
        customer.buyMoneyFromBank(moneyFactory.getMoneyType(), tryQuantity, processBank);
    }

    public void customerSellsCurrency(Customer customer, IBankFactory bankFactory, double currencyQuantity, IMoneyFactory moneyFactory){
        processBank = bankFactory.createBank();
        processBank.setBuySellMoney(moneyFactory.createMoney());
        customer.sellMoneyToBank(moneyFactory.getMoneyType(), currencyQuantity, processBank);
    }

    /** COIN SYSTEMS **/

    public void customerBuysUsdt(Customer customer, double tryQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(new UsdtCoinEXch());
        customer.buyUsdt(tryQuantity, processCoinSystem);
    }

    public void customerSellsUsdt(Customer customer, double usdtQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(new UsdtCoinEXch());
        customer.sellUsdt(usdtQuantity, processCoinSystem);
    }

    public void customerBuysCoin(Customer customer, double usdtQuantity, ICoinFactory coinFactory){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(coinFactory.createCoin());
        customer.buyCoinFromSystem(coinFactory.getCoinType(), usdtQuantity, processCoinSystem);
    }

    public void customerSellsCoin(Customer customer, double coinQuantity, ICoinFactory coinFactory){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(coinFactory.createCoin());
        customer.sellCoinToSystem(coinFactory.getCoinType(), coinQuantity, processCoinSystem);
    }

} // FACADE

