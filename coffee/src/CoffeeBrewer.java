public class CoffeeBrewer extends Coffee{

    CoffeeBrewer(String code, String description, double price,String model,int numberOfCups) {
        super(code, description, price);
        this.model = model;
        this.numberOfCups = numberOfCups;
    }

    public String getModel(){
        return this.model;
    }
    public int getNumberOfCups(){
        return this.numberOfCups;
    }

    @Override
    public String toString() {
        return super.toString()+"_"+getModel()+"_"+getNumberOfCups();
    }

    private String model;
    private int numberOfCups;
}
