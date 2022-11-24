package Models.Factory;

import Models.Markets.ECoins;

import java.util.Random;

public class CoinFactory {
    public ECoins setCoin(){
        Random r = new Random();
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
            //processTimeStar();
            if (choose==1) { return ECoins.BTC; }
            else if (choose==2) { return ECoins.ETH; }
            else if (choose==3) { return ECoins.BNB; }
            else if (choose==4) { return ECoins.ALGO; }
            else if (choose==5) { return ECoins.ADA; }
        }
    }
}
