public class Lot {

    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuanity() {
        return quanity;
    }

    public void setQuanity(double quanity) {
        this.quanity = quanity;
    }

    private double quanity;




    @Override
    public String toString() {
        return "Lot{" +
                "price=" + price +
                ", quanity=" + quanity +
                '}';
    }

}