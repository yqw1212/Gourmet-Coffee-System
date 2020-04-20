public class XMLSalesFormatter implements SalesFormatter{

    private static XMLSalesFormatter xmlSalesFormatter = null;
    private XMLSalesFormatter(){}
    public static XMLSalesFormatter getSingletonInstance(){
        if(xmlSalesFormatter == null){
            xmlSalesFormatter = new XMLSalesFormatter();
        }
        return xmlSalesFormatter;
    }
    @Override
    public String formatSales(Sales sales) {
        StringBuffer str = new StringBuffer();
        str.append("<Sales>").append("\n");
        for(Order o:sales){
            str.append("    <Order total=\"").append(o.getTotalCost()).append("\">").append("\n");
            for(OrderItem orderItem:o)
                str.append("        <OrderItem quantity=\"").append(orderItem.getQuantity()).append("\" price=\"")
                        .append(orderItem.getProduct().getPrice()).append("\">")
                        .append(orderItem.getProduct().getCode()).append("</OrderItem>").append("\n");
            str.append("    </Order>").append("\n");
        }
        str.append("</Sales>").append("\n");
        return str.toString();
    }
}
