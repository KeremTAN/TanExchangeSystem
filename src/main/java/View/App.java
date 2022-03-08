package View;

import Controls.Facade;
import Models.Customer.Customer;
import Models.Customer.CustomerBuilder;

public class App {
    public static void main(String[] args) {
        Facade facade = Facade.getInstance();
        Customer cus1 = CustomerBuilder.createCustomer("Steve", "JOBS", "9234567890", "5554443322", 'E')
                .setAge(47)
                .setHasCriminalRecord(true)
                .setIsMarried(true)
                .buildCustomer();

        Customer cus2 = CustomerBuilder.createGreatCustomer("BILL", "GATES", "1234567890", "1114443322", 'E')
                .setAge(53)
                .setEmailAddress("Bbill@hotmail.com")
                .buildCustomer();
        Customer[] allCustomers={ cus1, cus2};

        //facade.printAllGains();

        System.out.println("          SCENARIO 1          \n");
        Customer cus = allCustomers[0];
        facade.printInfo(cus);
//        facade.customerBuysCurrency(cus,1000);
//        facade.customerSellsCurrency(cus,100);
//        facade.customerBuysCoin(cus,8000);
//        facade.customerBuysUsdt(cus,100);
//        facade.customerBuysCurrency(cus,500);
        facade.customerSellsCoin(cus,30);
        facade.printInfo(cus);
/*
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

        ///////////////////////////////////////////////////

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
        facade.printInfo(cus);

        ///////////////////////////////////////////////////
        System.out.println();
        facade.printAllGains();
*/
    }
}
