package Models.Factory;
import Models.Banks.*;

import java.util.Random;

public class BankFactory {
    public ABanks setBank(){
        Random r = new Random();
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
            //processTimeDash();
            if (choose==1)
                return YapiKrediBank.getInstance();
            else if(choose==2) return TurkiyeCumIsBank.getInstance();
        }
    }
}
