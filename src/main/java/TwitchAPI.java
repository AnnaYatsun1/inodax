public class TwitchAPI {
    private String[][] sell;

    public String[][] getSell() {
        return sell;
    }

    public void setSell(String[][] sell) {
        this.sell = sell;
    }

    public String[][] getBuy() {
        return buy;
    }

    public void setBuy(String[][] buy) {
        this.buy = buy;
    }

    private String[][] buy;


    @Override
    public String toString()
    {
        return "ClassPojo [sell = "+sell+", buy = "+buy+"]";
    }


}