public class PlainTextSalesFormatter implements SalesFormatter{
    private static PlainTextSalesFormatter plainTextSalesFormatter = null;
    private PlainTextSalesFormatter(){}
    public static SalesFormatter getSingletonInstance(){
        if(plainTextSalesFormatter==null){
            plainTextSalesFormatter = new PlainTextSalesFormatter();
        }
        return plainTextSalesFormatter;
    }
    @Override
    public String formatSales(Sales sales) {
        StringBuffer str = new StringBuffer();
        int num=1;
        for (Order o:sales) {
            str.append("--------------------").append("\n");
            str.append("Order ").append(num).append("\n");
            for(OrderItem orderItem:o){
                str.append(orderItem).append("\n");
            }
            str.append("Total = ").append(o.getTotalCost()).append("\n");
            num++;
        }
        return str.toString();
    }
}
