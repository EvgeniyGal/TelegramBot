package banks;

public class NBUData {
    private String exchangedate, cc, txt;
    private int r030;
    private float rate;

    public NBUData(String exchangedate, String cc, String txt, int r030, float rate) {
        this.exchangedate = exchangedate;
        this.cc = cc;
        this.txt = txt;
        this.r030 = r030;
        this.rate = rate;
    }

    public String getExchangedate() {
        return exchangedate;
    }

    public void setExchangedate(String exchangedate) {
        this.exchangedate = exchangedate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getR030() {
        return r030;
    }

    public void setR030(int r030) {
        this.r030 = r030;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
