import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TestCatalog {
    private Catalog cat;
    private BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
    private PrintWriter stdOut = new PrintWriter(System.out);

    TestCatalog(){
        cat = new Catalog();
    }
    public void displayCatalog(){
        for (Coffee c:cat)
            System.out.println(c);
    }
    public void displayCoffee() throws IOException {
        stdOut.println("Please input the coffee code");
        String str = stdIn.readLine();
        Coffee c = cat.getCoffee(str);
        if(c==null)
            stdOut.println("There is not a coffee object which has the code");
        else
            stdOut.println(c);
    }
    public void addCoffee() throws IOException {
        stdOut.println("请按以下格式输入各类产品");
        stdOut.println("Coffee:Coffee_C001_美式咖啡_16.8");
        stdOut.println("CoffeeBean:Bean_B001_肯尼亚咖啡豆_69_肯尼亚_中度烘焙");
        stdOut.println("CoffeeBrewer:Brewer_R001_比乐蒂摩卡咖啡壶_479_S076_2");
        String line = stdIn.readLine();
        Coffee c = null;
        if(line.startsWith("Coffee"))
            c = readCoffee(line);
        else if(line.startsWith("Bean"))
            c = readCoffeeBean(line);
        else if(line.startsWith("Brewer"))
            c = readCoffeeBrewer(line);
        else
            stdOut.println("输入数据错误");
        if(c!=null)
            cat.addCoffee(c);
    }

    private Coffee readCoffee(String line){
        StringTokenizer in = new StringTokenizer(line,"_");
        if(in.countTokens()!=4)
            stdOut.println("输入数据错误");
        else {
            in.nextToken();
            return new Coffee(in.nextToken(),in.nextToken(),Double.parseDouble(in.nextToken()));
        }
        return null;
    }
    private Coffee readCoffeeBean(String line){
        StringTokenizer in = new StringTokenizer(line,"_");
        if(in.countTokens()!=6)
            stdOut.println("输入数据错误");
        else {
            in.nextToken();
            return new CoffeeBean(in.nextToken(),in.nextToken(),Double.parseDouble(in.nextToken()),in.nextToken(),in.nextToken());
        }
        return null;
    }
    private Coffee readCoffeeBrewer(String line){
        StringTokenizer in = new StringTokenizer(line,"_");
        if(in.countTokens()!=4)
            stdOut.println("输入数据错误");
        else {
            in.nextToken();
            return new CoffeeBrewer(in.nextToken(),in.nextToken(),Double.parseDouble(in.nextToken()),
                                    in.nextToken(),Integer.parseInt(in.nextToken()));
        }
        return null;
    }
    public void modifyCoffee() throws IOException {
        stdOut.println("请输入要修改价格的商品编号");
        String code = stdIn.readLine();
        Coffee c = cat.getCoffee(code);
        if(c==null)
            stdOut.println("您输入的商品不存在");
        else{
            stdOut.println("请输入新的价格");
            code = stdIn.readLine();
            c.setPrice(Double.parseDouble(code));
        }
    }
    public void removeCoffee() throws IOException {
        stdOut.println("请输入要删除的商品编码");
        String code = stdIn.readLine();
        Coffee c = cat.getCoffee(code);
        if(c!=null)
            cat.removeCoffee(c);
        else
            stdOut.println("你输入的商品不存在");
    }
    private int getChoice(){
        int input;
        do{
            try {
                stdOut.println();
                stdOut.println("[0] Quit");
                stdOut.println("[1] Display catalog");
                stdOut.println("[2] Display coffee");
                stdOut.println("[3] Add coffee");
                stdOut.println("[4] Remove coffee");
                stdOut.println("[5] Modify coffee");
                stdOut.println("Choice>");
                stdOut.flush();

                input = Integer.parseInt(stdIn.readLine());
                stdOut.println();
                if(input>=0 && input<=5)
                    break;
                else
                    stdOut.println("Invalid choice :"+input);
            } catch (NumberFormatException | IOException nfe) {
                stdOut.println(nfe);
            }
        }while (true);

        return input;
    }

    public void run() throws IOException {
        int choice = getChoice();
        while (choice!=0){
            if(choice==1)
                displayCatalog();
            else if(choice==2)
                displayCoffee();
            else if(choice==3)
                addCoffee();
            else if(choice==4)
                removeCoffee();
            else if (choice==5)
                modifyCoffee();
            choice = getChoice();
        }
    }

    public static void main(String[] args) {
        TestCatalog app = new TestCatalog();
    }
}
