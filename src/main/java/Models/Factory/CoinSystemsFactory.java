package Models.Factory;
import Models.CoinSystems.*;

import java.util.Random;

public class CoinSystemsFactory {
    public ACoinSystem setCoinSystem(){
        Random r = new Random();
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
            // processTimeStar();
            if (choose==1)
                return Binance.getInstance();
            else if(choose==2)
                return KuCoin.getInstance();
        }

    }


}
