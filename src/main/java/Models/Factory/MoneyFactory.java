package Models.Factory;
import Models.Banks.ABanks;
import Models.Markets.EMoney;
import Models.StrategyMoney.*;

import java.util.Random;

@Deprecated
public class MoneyFactory {
    // Simple Factory Method
    public EMoney setMoney(ABanks processBank){
        Random r = new Random();
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
            //processTimeDash();
            if (choose==1) { processBank.setBuySellMoney(new UsdMoneyExch()); return EMoney.USD; }
            else if (choose==2) { processBank.setBuySellMoney(new EurMoneyExch()); return EMoney.EUR; }
            else if (choose==3) { processBank.setBuySellMoney(new GbpMoneyExch()); return EMoney.GBP; }
            else if (choose==4) { processBank.setBuySellMoney(new ChfMoneyExch()); return EMoney.CHF; }
            else if (choose==5) { processBank.setBuySellMoney(new GoldMoneyExch()); return EMoney.Gold; }
            else if (choose==6) { processBank.setBuySellMoney(new SilverMoneyExch()); return EMoney.Silver; }
        }
    }
}
