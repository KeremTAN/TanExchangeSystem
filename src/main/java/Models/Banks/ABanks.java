package Models.Banks;

import Models.Markets.EMoney;
import Models.StrategyConvert.MoneyConverter.IConvertMoney;

import java.text.DecimalFormat;
import java.util.Map;

public abstract class ABanks  {

    private double tempCommission=0;
    public abstract String getName();
    protected abstract Map<EMoney, Double> getAllReserveMoney();
    private IConvertMoney moneyTrade;
    protected abstract double getBankCommission();
    protected abstract double getMoneyBank();
    protected abstract void updateBankMoney();
    private final DecimalFormat formatter = new DecimalFormat("##########.###");

    public void printReserveInfo() {
        System.out.println("'''''''''''''''''' "+ getName() +" ''''''''''''''''''");
        for(Map.Entry<EMoney, Double> moneyOfBank : getAllReserveMoney().entrySet())
            System.out.println(getName()+" has "+moneyOfBank.getValue()+" pieces of "+moneyOfBank.getKey());
        System.out.println(getName()+"'s gain from the transactions made : "+formatter.format(getMoneyBank())+" TRY");
        System.out.println("''''''''''''''''''''''''''''''''''''''''''''''\n");
    }

    private void calculateGainOfBank(double gainOfBank) {
        tempCommission = gainOfBank;
        updateBankMoney();
    }

    /**
     * getGainOfBank method to be used updating gain of the bank on subclasses
     */
    protected double getGainOfBank(){
        return tempCommission;
    }

    public double buyMoney(EMoney money, double currency) {
        double realValue=moneyTrade.convert(money.getPrice(), currency);
        double retMoney=realValue-(realValue * getBankCommission());
        System.out.println("!/ "+formatter.format(realValue*getBankCommission())+" TRY has been cut for this selling process");
        calculateGainOfBank((realValue*getBankCommission()));
        getAllReserveMoney().replace(money, getAllReserveMoney().get(money)+currency);
        getAllReserveMoney().replace(EMoney.TRY, getAllReserveMoney().get(EMoney.TRY)-retMoney);
        return retMoney; // payment try
    }

    public double sellMoney(EMoney money, double tryQuantity) {
        double realValue=moneyTrade.convert(money.getPrice(), tryQuantity);
        double retMoney=realValue-(realValue*getBankCommission());
        System.out.println("!/ "+formatter.format((realValue*getBankCommission())*(money.getPrice()))+" TRY has been cut for this buying process");
        calculateGainOfBank((realValue*getBankCommission())*money.getPrice()); // bank of currency converts to TRY for adding its safe
        getAllReserveMoney().replace(money, getAllReserveMoney().get(money)-retMoney);
        getAllReserveMoney().replace(EMoney.TRY, getAllReserveMoney().get(EMoney.TRY)+tryQuantity);
        return retMoney; //currency
    }



    public void setMoneyTrade(IConvertMoney buySellMoney) {
        this.moneyTrade=buySellMoney;
    }

    public double giveCredit(double quantity) {
        //this.buySellMoney = buySellMoney;
        return 0;
    }
}
