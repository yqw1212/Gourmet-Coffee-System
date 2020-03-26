import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

public class GourmetCoffeeSystem {
    private Catalog catalog;
    private OrderDB orderDB;
    private BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter strOut = new PrintWriter(System.out);
    private PrintWriter strErr = new PrintWriter(System.err);
    GourmetCoffeeSystem() {
        catalog = new Catalog();
        orderDB = new OrderDB(catalog);
        init();
    }
    private int getChoiose () throws IOException {
        strOut.println("[1]display catalog");
        strOut.println("[2]display product");
        strOut.println("[3]buy");
        strOut.println("[4]display all orders");
        strOut.println("[5]display products sold");
        strOut.println("[0]退出");
        strOut.flush();
        return Integer.parseInt(stdIn.readLine());
    }
    public void run() throws IOException {
        int n = getChoiose();
        while (n!=0){
            switch (n){
                case 1:{
                    displayCatalog();
                    break;
                }
                case 2:{
                    search_product();
                    break;
                }
                case 3:{
                    orderDB.addOrder(new Order(catalog));
                    break;
                }
                case 4:{
                    orderDB.displayOrders();
                    break;
                }
                case 5:{
                    orderDB.displayProductsSold();
                    break;
                }
            }
            n = getChoiose();
        }
    }
    private void search_product() throws IOException {
        strOut.println("请输入要查找物品的编码code");
        strOut.flush();
        CoffeeAccessory c = catalog.getCoffee(stdIn.readLine());
        if(c!=null){
            strOut.println("Code : "+c.getCode());
            strOut.println("Description : "+c.getDescription());
            strOut.println("Price : "+c.getPrice());
            strOut.flush();
            if(c instanceof Coffee){
                strOut.println("Oringin : "+((Coffee) c).getOrigin());
                strOut.println("Roast : "+((Coffee) c).getRoast());
                strOut.println("Flavor : "+((Coffee) c).getFlavor());
                strOut.println("Aroma : "+((Coffee) c).getAroma());
                strOut.println("Acidity : "+((Coffee) c).getAcidity());
                strOut.println("Body : "+((Coffee) c).getBody());
                strOut.flush();
            }
            else if(c instanceof CoffeeBrewer){
                strOut.println("Model : "+((CoffeeBrewer) c).getModel());
                strOut.println("Water type : "+((CoffeeBrewer) c).getWaterType());
                strOut.println("Capacity : "+((CoffeeBrewer) c).getCapacity());
                strOut.flush();
            }
        }
        else{
            strOut.println("您输入的商品不存在");
            strOut.flush();
        }
    }
    private void displayCatalog(){
        for (CoffeeAccessory c : catalog){
            System.out.println(c);
        }
    }
    private void init(){
        catalog.addCoffee(new Coffee("C001","Colombia,Whole,1 lb",17.99,
                "Colombia","Medium","Rich and Healty","Rich","Medium","Full"));
        catalog.addCoffee(new Coffee("C002","Colombia,Ground,1 lb",18.75,
                "Colombia","Medium","Rich and Healty","Rich","Medium","Full"));
        catalog.addCoffee(new Coffee("C007","Guatemala,Whole,1 lb",17.99,
                "Colombia","Medium","Rich and complex","Spicy","Medium to high","Medium to full"));
        catalog.addCoffee(new Coffee("C008","Guatemala,Ground,1 lb",18.75,
                "Colombia","Medium","Rich and complex","Spicy","Medium to high","Medium to full"));
        catalog.addCoffee(new CoffeeBrewer("B001","Home Coffee Brewer",150.00,
                "Brewer 100","Pourover",6));
        catalog.addCoffee(new CoffeeBrewer("B002","Coffee Brewer,2 Warmers",200.00,
                "Brewer 200","Pourover",12));
        catalog.addCoffee(new CoffeeBrewer("B003","Coffee Brewer,2 Warmers",280.00,
                "Brewer 300","Pourover",12));
        catalog.addCoffee(new CoffeeBrewer("B004","Commercial Brewer,20 cups",380.00,
                "Quick Coffee 100","Automatic",20));
        catalog.addCoffee(new CoffeeBrewer("B005","Commercial Brewer,40 cups",480.00,
                "Quick Coffee 200","Automatic",40));
        catalog.addCoffee(new CoffeeAccessory("A001","Almond Flavored Syrup",9.00));
        catalog.addCoffee(new CoffeeAccessory("A002","Irish Creme Flavored",9.00));
        catalog.addCoffee(new CoffeeAccessory("A005","Gourmet Coffee Cookies",12.00));
        catalog.addCoffee(new CoffeeAccessory("A007","Gourmet Coffee Ceramic Mug",8.00));
        catalog.addCoffee(new CoffeeAccessory("A009","Gourmet Coffee 36 Cup Filters",45.00));
    }
    public static void main(String[] args) throws IOException {
        GourmetCoffeeSystem test = new GourmetCoffeeSystem();
        test.run();
    }
}
