package gz;

public class CurrencyRate {

    private String baseCurrency;            // Базовая валюта
    private String currency;                // Валюта сделки
    private double saleRateNB;              // Курс продажи НБУ
    private double purchaseRateNB;          // Курс покупки НБУ
    private double saleRate;                // Курс продажи ПриватБанка
    private double purchaseRate;            // Курс покупки ПриватБанка

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getCurrency() {
        return currency;
    }

    public double getSaleRateNB() {
        return saleRateNB;
    }

    public double getPurchaseRateNB() {
        return purchaseRateNB;
    }

    public double getSaleRate() {
        return saleRate;
    }

    public double getPurchaseRate() {
        return purchaseRate;
    }

    @Override
    public String toString() {
        return "\n\tCurrencyRate{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", currency='" + currency + '\'' +
                ", saleRateNB=" + saleRateNB +
                ", purchaseRateNB=" + purchaseRateNB +
                ", saleRate=" + saleRate +
                ", purchaseRate=" + purchaseRate +
                '}';
    }
}
