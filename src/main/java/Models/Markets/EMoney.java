package Models.Markets;

public enum EMoney {
    TRY(1.0), EUR(18.35), USD(18.05), GBP(18.2), CHF(13.8), Gold(1000.01), Silver(702.0);

    private double price;

    EMoney(double price) {
        this.price = price;
    }

    public double getPrice() { return this.price; }
}