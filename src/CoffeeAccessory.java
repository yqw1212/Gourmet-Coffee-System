public class CoffeeAccessory {
    private String code;
    private String description;
    private double price;

    CoffeeAccessory(String code, String description, double price){
        this.code = code;
        this.description = description;
        this.price = price;
    }
    public String getCode() {
        return this.code;
    }
    public String getDescription() {
        return this.description;
    }
    public double getPrice() {
        return this.price;
    }
    public String toString() {
        return code+"_" + description;
    }
}
