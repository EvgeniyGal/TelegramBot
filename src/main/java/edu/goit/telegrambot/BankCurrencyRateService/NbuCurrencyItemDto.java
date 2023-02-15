package edu.goit.telegrambot.BankCurrencyRateService;

public class NbuCurrencyItemDto {
    //r030":36,"txt":"Австралійський долар","rate":25.3036,"cc":"AUD","exchangedate":"13.02.2023"
    private Integer r030;
    private String txt;
    private float rate;
    private CurrencyType cc;
    private String exchangedate;

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public CurrencyType getCc() {
        return cc;
    }

    public void setCc(CurrencyType cc) {
        this.cc = cc;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    @Override
    public String toString() {
        return "NbuCurrencyItemDto{" +
                "r030=" + r030 +
                ", txt='" + txt + '\'' +
                ", rate=" + rate +
                ", cc=" + cc +
                ", exchangedate='" + exchangedate + '\'' +
                '}';
    }
}
