package Models.Banks;

import Models.Markets.EMoney;
import java.util.HashMap;
import java.util.Map;

public class TurkiyeCumIsBank extends ABanks {
    private final String name="Türkiye Cumhuriyeti İş Bankası";
    private static Map<EMoney,Double> allReserveMoney = new HashMap<>();
    private double bankCommission=0.0065;
    private static double moneyOfBank=0.0; // TRY
    private static TurkiyeCumIsBank instance;

    private TurkiyeCumIsBank() {
        allReserveMoney.put(EMoney.TRY, 650873100.0);
        allReserveMoney.put(EMoney.USD, 57000058.0);
        allReserveMoney.put(EMoney.EUR, 28087500.0);
        allReserveMoney.put(EMoney.GBP, 83405000.0);
        allReserveMoney.put(EMoney.CHF, 21000870.0);
        allReserveMoney.put(EMoney.Gold, 750.0); // kg
        allReserveMoney.put(EMoney.Silver, 5100.0); // quantity
    }

    public static TurkiyeCumIsBank getInstance() {
        if (instance==null) {
            synchronized (TurkiyeCumIsBank.class) {
                instance = new TurkiyeCumIsBank();
            }
        }
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    protected Map<EMoney, Double> getAllReserveMoney() {
        return allReserveMoney;
    }

    @Override
    protected double getBankCommission() {
        return bankCommission;
    }

    @Override
    protected double getMoneyBank() {
        return moneyOfBank;
    }

    @Override
    protected void updateBankMoney() {
        moneyOfBank+=super.getGainOfBank();
    }
}