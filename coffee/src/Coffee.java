public class Coffee {

    Coffee(String code,String description,double price){
        this.code=code;
        this.description=description;
        this.price=price;
    }
    public String getCode(){
        return code;
    }
    public String getDescription(){
        return description;
    }
    public String getprice(){
        return String.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object object){
        if(object instanceof Coffee) {
            Coffee c = (Coffee) object;
            if (c.getCode().equals(getCode()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getCode() + "_" + getDescription() +"_" + getprice();//用方法
    }

    private String code;
    private String description;
    private double price;
}
