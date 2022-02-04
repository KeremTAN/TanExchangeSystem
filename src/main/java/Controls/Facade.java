package Controls;

import Models.Banks.ABanks;
import Models.Banks.TurkiyeCumIsBank;
import Models.Banks.YapiKrediBank;
import Models.CoinSystems.ACoinSystem;
import Models.CoinSystems.Binance;
import Models.CoinSystems.KuCoin;
import Models.Customer;
import Models.Markets.ECoins;
import Models.Markets.EMoney;
import Models.StrategyCoins.*;
import Models.StrategyMoney.*;

import java.util.Random;

public class Facade {
    private static Facade instance;
    private Customer customer;
    private ABanks yapiKrediBank = YapiKrediBank.getInstance();
    private ABanks tcIsBank = TurkiyeCumIsBank.getInstance();
    private ABanks processBank;
    private ACoinSystem binance = Binance.getInstance();
    private ACoinSystem kuCoin = KuCoin.getInstance();
    private ACoinSystem processCoin;
    private Random r = new Random();

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
        tcIsBank.printReserveInfo();
        yapiKrediBank.printReserveInfo();
        binance.printCoinStockInfo();
        kuCoin.printCoinStockInfo();
    }

    public void printInfo(Customer c){
        c.printGoodsAndChattelsOfCustomer();
    }

    /** BANK SYSTEMS **/

    public void customerBuysCurrency(Customer customer, double tryQuantity){
        processBank = chooseBank();
        EMoney m = chooseProcessMoney();
        customer.buyMoneyFromBank(m, tryQuantity, processBank);

    }

    public void customerSellsCurrency(Customer customer, double currencyQuantity){
        processBank = chooseBank();
        EMoney m = chooseProcessMoney();
        customer.sellMoneyToBank(m, currencyQuantity, processBank);

    }

    private ABanks chooseBank(){
        int choose;
        System.out.println("""
                
                ---------- Please choose to the Bank which you want to make the process ---------
                
                Please enter 1 to choose Yapı Kredi Bankası
                Please enter 2 to choose Türkiye Cumhuriyeti İş Bankası
                Please enter -1 to cancel the process
                If your choose is not valid, you will have to choose the process again!
                """);
        while(true){
            choose= r.nextInt(4);
            System.out.print("You can make to choose for your process bank : ");
            System.out.println(choose);
            processTimeDash();
            if (choose==1)
                return yapiKrediBank;
            else if(choose==2) return tcIsBank;
        }
    } //chooseBank()

    private EMoney chooseProcessMoney(){
        int choose;
        System.out.println("""
                
                ------- Please choose to type of money which you want to make the process -------
                
                Please enter 1 to choose USD
                Please enter 2 to choose EUR
                Please enter 3 to choose GBP
                Please enter 4 to choose CHF
                Please enter 5 to choose GOLD
                Please enter 6 to choose SILVER
                Please enter -1 to cancel the process
                If your choose is not valid, you will have to choose the process again!
                """);
        while(true){
            choose= r.nextInt(8);
            System.out.print("You can make to choose for your process money : ");
            System.out.println(choose);
            processTimeDash();
            if (choose==1) { processBank.setBuySellMoney(new UsdMoneyExch()); return EMoney.USD; }
            else if (choose==2) { processBank.setBuySellMoney(new EurMoneyExch()); return EMoney.EUR; }
            else if (choose==3) { processBank.setBuySellMoney(new GbpMoneyExch()); return EMoney.GBP; }
            else if (choose==4) { processBank.setBuySellMoney(new ChfMoneyExch()); return EMoney.CHF; }
            else if (choose==5) { processBank.setBuySellMoney(new GoldMoneyExch()); return EMoney.Gold; }
            else if (choose==6) { processBank.setBuySellMoney(new SilverMoneyExch()); return EMoney.Silver; }
        }
    } // chooseProcessMoney()

    /** COIN SYSTEMS **/

    public void customerBuysUsdt(Customer customer, double tryQuantity){
        processCoin=chooseCoinSystem();
        processCoin.setBuySellCoins(new UsdtCoinEXch());
        customer.buyUsdt(tryQuantity, processCoin);
    }

    public void customerSellsUsdt(Customer customer, double usdtQuantity){
        processCoin=chooseCoinSystem();
        processCoin.setBuySellCoins(new UsdtCoinEXch());
        customer.sellUsdt(usdtQuantity, processCoin);
    }

    public void customerBuysCoin(Customer customer, double usdtQuantity){
        processCoin=chooseCoinSystem();
        ECoins c = chooseProcessCoin();
        customer.buyCoinFromSystem(c, usdtQuantity, processCoin);
    }

    public void customerSellsCoin(Customer customer, double coinQuantity){
        processCoin=chooseCoinSystem();
        ECoins c = chooseProcessCoin();
        customer.sellCoinToSystem(c, coinQuantity, processCoin);

    }

    private ACoinSystem chooseCoinSystem(){
        int choose;
        System.out.println("""
                
                ****** Please choose to the Coin System which you want to make the process *****
                
                Please enter 1 to choose Binance
                Please enter 2 to choose KuCoin
                Please enter -1 to cancel the process
                If your choose is not valid, you will have to choose the process again!
                """);
        while(true){
            choose= r.nextInt(4);
            System.out.print("You can make to choose for your process coin system : ");
            System.out.println(choose);
            processTimeStar();
            if (choose==1)
                return binance;
            else if(choose==2)
                return kuCoin;
        }
    } //chooseBank()

    private ECoins chooseProcessCoin(){
        int choose;
        System.out.println("""
                
                ******* Please choose to type of coin which you want to make the process ******
                
                Please enter 1 to choose BTC
                Please enter 2 to choose ETH
                Please enter 3 to choose BNB
                Please enter 4 to choose ALGO
                Please enter 5 to choose ADA
                Please enter -1 to cancel the process
                If your choose is not valid, you will have to choose the process again!
                """);
        while(true){
            choose= r.nextInt(6);
            System.out.print("You can make to choose for your process coin : ");
            System.out.println(choose);
            processTimeStar();
            if (choose==1) { processCoin.setBuySellCoins(new BtcCoinExch()); return ECoins.BTC; }
            else if (choose==2) { processCoin.setBuySellCoins(new EthCoinExch()); return ECoins.ETH; }
            else if (choose==3) { processCoin.setBuySellCoins(new BnbCoinExch()); return ECoins.BNB; }
            else if (choose==4) { processCoin.setBuySellCoins(new AlgoCoinExch()); return ECoins.ALGO; }
            else if (choose==5) { processCoin.setBuySellCoins(new AdaCoinExch()); return ECoins.ADA; }
        }
    } // chooseProcessCoin()

    /** DECOR FOR MAIN **/
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

} // FACADE

