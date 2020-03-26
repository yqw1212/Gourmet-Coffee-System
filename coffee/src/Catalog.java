import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Coffee>{
    Catalog(){
        coffeeArrayList = new ArrayList<>();
    }
    public void addCoffee(Coffee coffee){
        coffeeArrayList.add(coffee);
    }
    public void removeCoffee(Coffee coffee){
        coffeeArrayList.remove(coffee);
    }
    public Coffee getCoffee(String code){
        for (Coffee c : coffeeArrayList) {
            if (c.getCode().equals(code))
                return c;
        }
        return null;//不写gg
    }

    @Override
    public Iterator<Coffee> iterator() {
        return coffeeArrayList.iterator();
    }
    public int getNumberOfCoffees(){
        return coffeeArrayList.size();
    }

    private ArrayList<Coffee> coffeeArrayList;

}
