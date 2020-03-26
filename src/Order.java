import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Order {
    private Catalog buy;
    private Catalog catalog;
    private HashMap<String, Integer> products;
    private String code;
    private double sum;
    Order(Catalog catalog) throws IOException {
        sum = 0.00;
        buy = new Catalog();
        products = new HashMap<String, Integer>();
        this.catalog = catalog;
        run();
    }
    private int getChoice() throws IOException {
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[1]add");
        System.out.println("[2]remove");
        System.out.println("[3]display catalog");
        System.out.println("[0]结束");
        System.out.println("请选择:");
        return Integer.parseInt(stdIn.readLine());
    }
    public void run() throws IOException {
        int n = getChoice();
        while (n!=0){
            switch (n){
                case 1:{
                    System.out.println("请输入要加入订单的物品编码code");
                    String code = new Scanner(System.in).nextLine();
                    addItem(this.catalog.getCoffee(code));
                    break;
                }
                case 2:{
                    System.out.println("请输入要移出订单的物品编码code");
                    String code = new Scanner(System.in).nextLine();
                    removeItem(this.catalog.getCoffee(code));
                    break;
                }
                case 3:{
                    display(catalog);
                    break;
                }
            }
            n = getChoice();
        }
    }
    public void display(Catalog catalog){
        System.out.println("Quantity_Code_Descrption_Price");
        for(String str : products.keySet()){
            CoffeeAccessory coffeeAccessory = catalog.getCoffee(str);
            System.out.println(products.get(str)+"_"+str+"_"+coffeeAccessory.getDescription()+"_"+coffeeAccessory.getPrice() );
        }
        System.out.println("Total : "+getSum());
    }
    public void addItem(CoffeeAccessory coffeeAccessory){
        String code = coffeeAccessory.getCode();
        buy.addCoffee(coffeeAccessory);
        if(products.containsKey(code)){
            int i= products.get(code);
            products.replace(code,i+1);
        }
        else {
            products.put(code, 1);
        }
        sum += coffeeAccessory.getPrice();
    }
    public void removeItem(CoffeeAccessory coffeeAccessory){
        String code = coffeeAccessory.getCode();
        buy.removeCoffee(coffeeAccessory);
        if(products.containsKey(code)){
            if(products.get(code)!=1) {
                int i = products.get(code);
                products.replace(code, i - 1);
            }
            else
                products.remove(code);
        }
        else {
            System.out.println("亲,你输入的商品不在您的订单中呢");
        }
        sum -= coffeeAccessory.getPrice();
    }
    public HashMap<String, Integer> hashMap(){
        return this.products;
    }
    public double getSum() {
        return this.sum;
    }
    public String getCode(){
        return this.code;
    }
    public String toString(){
        StringBuffer s = new StringBuffer();
        for(String str : products.keySet()){
            CoffeeAccessory coffeeAccessory = catalog.getCoffee(str);
            s.append(products.get(str)+"_"+str+"_"+coffeeAccessory.getDescription()+"_"+coffeeAccessory.getPrice()+"\n");
        }
        s.append("Total : "+getSum());
        return s.toString();
    }
}
