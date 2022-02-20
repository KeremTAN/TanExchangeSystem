package Controls;

import Models.Banks.ABanks;
import Models.CoinSystems.ACoinSystem;
import Models.Customer;
import Models.Factory.*;
import Models.Markets.*;
import Models.StrategyCoins.UsdtCoinEXch;
import java.util.Random;

public class Facade {
    private static Facade instance;
    private ABanks processBank;
    private ACoinSystem processCoinSystem;
    private Random r = new Random();

/*
//    private ABanks yapiKrediBank = YapiKrediBank.getInstance();
//    private ABanks tcIsBank = TurkiyeCumIsBank.getInstance();
//    private ACoinSystem binance = Binance.getInstance();
//    private ACoinSystem kuCoin = KuCoin.getInstance();
*/

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

    public void customerBuysCurrency(Customer customer, double tryQuantity){
        processBank = new BankFactory().setBank();
        EMoney m = new MoneyFactory().setMoney(processBank);
        customer.buyMoneyFromBank(m, tryQuantity, processBank);

    }

    public void customerSellsCurrency(Customer customer, double currencyQuantity){
        processBank = new BankFactory().setBank();
        EMoney m = new MoneyFactory().setMoney(processBank);
        customer.sellMoneyToBank(m, currencyQuantity, processBank);

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

    public void customerBuysCoin(Customer customer, double usdtQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        ECoins c = new CoinFactory().setCoin(processCoinSystem);
        customer.buyCoinFromSystem(c, usdtQuantity, processCoinSystem);
    }

    public void customerSellsCoin(Customer customer, double coinQuantity){
        processCoinSystem = new CoinSystemsFactory().setCoinSystem();
        ECoins c = new CoinFactory().setCoin(processCoinSystem);
        customer.sellCoinToSystem(c, coinQuantity, processCoinSystem);

    }
/*
    /** DECOR FOR MAIN
    private void processTimeDash(){
        String info ="-------------------------------------------------";
        for(int index=0; index<info.length();index++) {
            try {
                Thread.sleep(2);
                System.out.print(info.charAt(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }

    private void processTimeStar(){
        String info ="*************************************************";
        for(int index=0; index<info.length();index++) {
            try {
                Thread.sleep(2);
                System.out.print(info.charAt(index));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
 */

} // FACADE

