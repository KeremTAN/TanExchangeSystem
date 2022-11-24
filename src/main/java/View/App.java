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
        facade.customerBuysCoin(cus,100);
        facade.customerSellsCoin(cus,10);
        facade.customerBuysCurrency(cus,1000);
        facade.customerSellsCurrency(cus,50);
        facade.printInfo(cus);
    }
}
