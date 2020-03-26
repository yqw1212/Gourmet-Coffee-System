public class CoffeeBean extends Coffee{

    CoffeeBean(String code, String description, double price,String origin, String roast) {
        super(code, description, price);
        this.origin=origin;
        this.roast = roast;
    }

    public String getOrigin(){
        return this.origin;
    }
    public String getRoast(){
        return this.roast;
    }

    @Override
    public String toString() {
        return super.toString()+"_"+getOrigin()+"_"+getRoast();
    }

    private String origin;
    private String roast;
}
