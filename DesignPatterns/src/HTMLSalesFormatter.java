public class HTMLSalesFormatter implements SalesFormatter{

    private static HTMLSalesFormatter htmlSalesFormatter = null;
    private HTMLSalesFormatter(){}
    public static HTMLSalesFormatter getSingletonInstance(){
        if(htmlSalesFormatter == null){
            htmlSalesFormatter = new HTMLSalesFormatter();
        }
        return htmlSalesFormatter;
    }
    @Override
    public String formatSales(Sales sales) {
        StringBuffer str = new StringBuffer();
        str.append("<html>").append("\n");
        str.append("    <body>").append("\n");
        str.append("        <center><h2>Orders</h2></center>").append("\n");
        for (Order o:sales){
            str.append("        <hr>").append("\n");
            str.append("        <h4>Total = ").append(o.getTotalCost()).append("</h4>").append("\n");
            for (OrderItem orderItem:o){
                str.append("            <p>").append("\n");
                str.append("                <b>code:</b> ").append(orderItem.getProduct().getCode()).append("<br>").append("\n");
                str.append("                <b>quantity:</b> ").append(orderItem.getQuantity()).append("<br>").append("\n");
                str.append("                <b>price:</b> ").append(orderItem.getProduct().getPrice()).append("<br>").append("\n");
                str.append("            </p>").append("\n");
            }
        }
        str.append("    </body>").append("\n");
        str.append("</html>").append("\n");
        return str.toString();
    }
}
