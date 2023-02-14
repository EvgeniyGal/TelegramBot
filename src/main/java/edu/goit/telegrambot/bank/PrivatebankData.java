package banks;

public class PrivatebankData {
    private String ccy, base_ccy;
    private float buy,sale;

    public PrivatebankData(String ccy, String base_ccy, float buy, float sale) {
        this.ccy = ccy;
        this.base_ccy = base_ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBase_ccy() {
        return base_ccy;
    }

    public void setBase_ccy(String base_ccy) {
        this.base_ccy = base_ccy;
    }

    public float getBuy() {
        return buy;
    }

    public void setBuy(float buy) {
        this.buy = buy;
    }

    public float getSale() {
        return sale;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    /*private String currunceRate, baseCurrence;
    private float saleRate, purchaseRate;

    public PrivateBankData(String currunceRate, String baseCurrence, float purchaseRate, float saleRate) {
        this.currunceRate = currunceRate;
        this.baseCurrence = baseCurrence;
        this.purchaseRate = purchaseRate;
        this.saleRate = saleRate;
    }

    public String getBaseCurrence() {
        return baseCurrence;
    }

    public void setBaseCurrence(String baseCurrence) {
        this.baseCurrence = baseCurrence;
    }

    public String getCurrunceRate() {
        return currunceRate;
    }

    public void setCurrunceRate(String currunceRate) {
        this.currunceRate = currunceRate;
    }

    public float getSaleRate() {
        return saleRate;
    }

    public void setSaleRate(float saleRate) {
        this.saleRate = saleRate;
    }

    public float getPurchaseRate() {
        return purchaseRate;
    }

    public void setPurchaseRate(float purchaseRate) {
        this.purchaseRate = purchaseRate;
    }*/
}
