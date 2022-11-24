package Models.StrategyConvert.CoinConverter;

public class ConvertToCoin implements IConverterCoin{
    @Override
    public double convert(double coinPrice, double usdtQuantity) {
        return usdtQuantity/coinPrice;
    }
}
