package Models.Factory;
import Models.Markets.EMoney;

import java.util.Random;

public class MoneyFactory {
    public EMoney setMoney(){
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
            if (choose==1) {  return EMoney.USD; }
            else if (choose==2) { return EMoney.EUR; }
            else if (choose==3) {  return EMoney.GBP; }
            else if (choose==4) {  return EMoney.CHF; }
            else if (choose==5) {  return EMoney.Gold; }
            else if (choose==6) {  return EMoney.Silver; }
        }
    }
}
