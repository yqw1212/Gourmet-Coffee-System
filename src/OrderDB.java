import java.util.ArrayList;
import java.util.HashMap;

public class OrderDB {
    private ArrayList<Order> orderArrayList;
    private HashMap<String, Integer> sell;
    private Catalog catalog;
    OrderDB(Catalog catalog){
        this.orderArrayList = new ArrayList<Order>();
        this.sell = new HashMap<String,Integer>();
        this.catalog =catalog;
    }
    public Order getOrder(String code){
        for (Order o : orderArrayList) {
            if (o.getCode().equals(code))
                return o;
        }
        return null;
    }
    public void displayProductsSold(){
        for (String s : sell.keySet())
            System.out.println(sell.get(s)+"_"+ catalog.getCoffee(s));
    }
    public void displayOrders(){
        for(Order o : orderArrayList)
            System.out.println(o);
    }
    public void addOrder(Order order){
        orderArrayList.add(order);
        HashMap<String,Integer> hashMap = order.hashMap();
        for(String str : hashMap.keySet()){
            if(sell.containsKey(str)){
                int i = sell.get(str);
                sell.replace(str,i+hashMap.get(str));
            }
            else
                sell.put(str,hashMap.get(str));
        }
    }
    public void remove(Order order){
        orderArrayList.remove(order);
        HashMap<String,Integer> hashMap = order.hashMap();
        int flag = 0;
        for(String str : hashMap.keySet()){
            if(sell.containsKey(str)&&sell.get(str)>=hashMap.get(str))
                flag = 0;
            else
                flag = 1;
        }
        if (flag ==1)
            System.out.println("无法删除");
        else {
            for (String st : hashMap.keySet()){
                if(sell.get(st)>hashMap.get(st)) {
                    int i = sell.get(st);
                    sell.replace(st, i - hashMap.get(st));
                }
                else
                    sell.remove(st);
            }
        }
    }
}
