package Models.Markets;

public enum ECoins {
    USDT(1.05), BTC(16500.865), BNB(250.48), ETH(1580.125), ALGO(0.55), ADA(0.2);

    private double price;

    ECoins(double price) {
        this.price=price;
    }

    public double getPrice() { return this.price; }
}

