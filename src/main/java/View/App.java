package View;

import Controls.Facade;
import Models.Customer;

public class App {
    public static void main(String[] args) {
        Facade facade = Facade.getInstance();
        Customer[] allCustomers={
                new Customer("Hayri", "Irdal","11111111111","Bursa","5986573258","hayriirdal@mail.com",5.7,true,41,false),
                new Customer("Halit", "Ayarcı","22222222222","Istanbul","5895762385","halitayarci@mail.com",7.7,true,49,true),
                new Customer("Zehra", "Ayarcı","23333333333","Istanbul","5998746517","zehraayarci@mail.com",8.3,true,25,false),
                new Customer("Muvakkit Nuri", "Efendi","98877744555","Manisa","5879865478","muvakkitnuriefendi@mail.com",5.7,false,60, false)
                //,new Customer(null,null,null,null,null,null,)
        };
        System.out.println();
        facade.printAllGains();

        System.out.println("          SCENARIO 1          \n");
        Customer cus = allCustomers[0];
        facade.printInfo(cus);
        facade.customerBuysCurrency(cus,1000);
        facade.customerSellsCurrency(cus,100);
        facade.customerBuysCoin(cus,8000);
        facade.customerBuysUsdt(cus,3000);
        facade.customerBuysCurrency(cus,500);
        facade.customerSellsCoin(cus,30);
        facade.printInfo(cus);

        ///////////////////////////////////////////////////

        System.out.println("\n           SCENARIO 2          \n");
        cus = allCustomers[1];
        facade.printInfo(cus);
        facade.customerBuysCurrency(cus,1000);
        facade.customerSellsCurrency(cus,200);
        facade.customerBuysUsdt(cus,5000);
        facade.customerBuysCoin(cus,1000);
        facade.customerBuysCurrency(cus,2000);
        facade.customerSellsCurrency(cus, 250);
        facade.printInfo(cus);

/*        ///////////////////////////////////////////////////

        System.out.println("\n           SCENARIO 3         \n ");
        cus = allCustomers[2];
        facade.printInfo(cus);
        facade.customerSellsUsdt(cus,500);
        facade.customerBuysCoin(cus, 750);
        facade.customerBuysCurrency(cus,2500);
        facade.customerBuysCurrency(cus,1250);
        facade.customerSellsCurrency(cus,100);
        facade.printInfo(cus);

        ///////////////////////////////////////////////////

        System.out.println("\n           SCENARIO 4         \n ");
        cus = allCustomers[3];
        facade.printInfo(cus);
        facade.customerBuysCurrency(cus,1000);
        facade.customerBuysUsdt(cus,6000);
        facade.customerBuysCoin(cus, 100);
        facade.customerBuysCurrency(cus,1000);
        facade.customerSellsCurrency(cus,200);
        facade.customerBuysCoin(cus, 500);
        facade.customerBuysCurrency(cus,1000);
        facade.printInfo(cus);*/

        ///////////////////////////////////////////////////
        System.out.println();
        facade.printAllGains();



    }
}
