import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<CoffeeAccessory>{
    private ArrayList<CoffeeAccessory> coffeeAccessoryArrayList;
    Catalog(){
        coffeeAccessoryArrayList = new ArrayList<CoffeeAccessory>();
    }
    public void addCoffee(CoffeeAccessory coffeeAccessory){
        coffeeAccessoryArrayList.add(coffeeAccessory);
    }
    public void removeCoffee(CoffeeAccessory coffeeAccessory){
        coffeeAccessoryArrayList.remove(coffeeAccessory);
    }
    public CoffeeAccessory getCoffee(String code){
        for (CoffeeAccessory c : coffeeAccessoryArrayList) {
            if (c.getCode().equals(code))
                return c;
        }
        return null;//不写gg
    }
    public Iterator<CoffeeAccessory> iterator() {
        return coffeeAccessoryArrayList.iterator();
    }
    public int getNum(){
        return coffeeAccessoryArrayList.size();
    }
}
