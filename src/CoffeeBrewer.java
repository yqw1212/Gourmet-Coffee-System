public class CoffeeBrewer extends CoffeeAccessory {
    private String model;
    private String waterType;
    private int capacity;

    CoffeeBrewer(String code, String description, double price,String model,String waterType,int capacity) {
        super(code, description, price);
        this.model = model;
        this.waterType = waterType;
        this.capacity = capacity;
    }
    public String getModel() {
        return this.model;
    }
    public String getWaterType() {
        return this.waterType;
    }
    public int getCapacity() {
        return this.capacity;
    }
}
