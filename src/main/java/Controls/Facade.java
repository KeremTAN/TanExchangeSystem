package Controls;

import Models.Banks.ABanks;
import Models.CoinSystems.ACoinSystem;
import Models.Customer.Customer;
import Models.Customer.StrategyTransaction.BanksTransaction.BuyingMoneyFromBank;
import Models.Customer.StrategyTransaction.BanksTransaction.SellingMoneyToBank;
import Models.Customer.StrategyTransaction.CoinSystemsTransaction.BuyingCoinFromCoinSystem;
import Models.Customer.StrategyTransaction.CoinSystemsTransaction.SellingCoinToCoinSystem;
import Models.Factory.*;
import Models.Markets.*;
import Models.StrategyConvert.CoinConverter.ConvertToCoin;
import Models.StrategyConvert.CoinConverter.ConvertToUsdt;
import Models.StrategyConvert.MoneyConverter.ConvertToCurrency;
import Models.StrategyConvert.MoneyConverter.ConvertToTRY;

import java.util.Random;

public class Facade {
    private static Facade instance;
    private ABanks processBank;
    private ACoinSystem processCoinSystem;
    private Random r = new Random();

    private Facade(){ }

    public static Facade getInstance(){
        if(instance==null) {
            synchronized (Facade.class){
                if(instance==null) {
                    instance = new Facade();
                    System.out.println("FACADE INSTANCE CREATED!!");
                }
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

    public void customerBuysCurrency(Customer customer, double tryQuantity){
        processBank = new BankFactory().setBank();
        processBank.setMoneyTrade(new ConvertToCurrency());
        EMoney m = new MoneyFactory().setMoney();
        new BuyingMoneyFromBank().transaction(customer,m,tryQuantity,processBank);

    }

    public void customerSellsCurrency(Customer customer, double currencyQuantity){
        processBank = new BankFactory().setBank();
        processBank.setMoneyTrade(new ConvertToTRY());
        EMoney m = new MoneyFactory().setMoney();
        new SellingMoneyToBank().transaction(customer, m, currencyQuantity, processBank);

    }

    /** COIN SYSTEMS **/

    public void customerBuysUsdt(Customer customer, double tryQuantity){
      /*  processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(new UsdtCoinEXch());
        customer.buyUsdt(tryQuantity, processCoinSystem);*/
    }

    public void customerSellsUsdt(Customer customer, double usdtQuantity){
       /* processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setBuySellCoins(new UsdtCoinEXch());
        customer.sellUsdt(usdtQuantity, processCoinSystem);*/
    }

    public void customerBuysCoin(Customer customer, double usdtQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setCoinTrade(new ConvertToCoin());
        ECoins c = new CoinFactory().setCoin();
        new BuyingCoinFromCoinSystem().transaction(customer, c, usdtQuantity, processCoinSystem);
    }

    public void customerSellsCoin(Customer customer, double coinQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        processCoinSystem.setCoinTrade(new ConvertToUsdt());
        ECoins c = new CoinFactory().setCoin();
        new SellingCoinToCoinSystem().transaction(customer, c, coinQuantity, processCoinSystem);

    }

} // FACADE

