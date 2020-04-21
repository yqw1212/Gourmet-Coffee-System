import java.io.*;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader {

    private static PrintWriter  stdErr = new  PrintWriter(System.err, true);
    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(line,"_");
        if(stringTokenizer.countTokens()!=4){
            throw new DataFormatException(line);
        }else {
            stringTokenizer.nextToken();
            return new Product(stringTokenizer.nextToken(),stringTokenizer.nextToken(),
                    Double.parseDouble(stringTokenizer.nextToken()));
        }
    }
    private Coffee readCoffee(String line) throws DataFormatException{
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(line,"_");
        if(stringTokenizer.countTokens()!=10){
            throw new DataFormatException(line);
        }else {
            stringTokenizer.nextToken();
            return new Coffee(stringTokenizer.nextToken(),stringTokenizer.nextToken(),
                    Double.parseDouble(stringTokenizer.nextToken()),stringTokenizer.nextToken(),
                    stringTokenizer.nextToken(),stringTokenizer.nextToken(),stringTokenizer.nextToken(),
                    stringTokenizer.nextToken(),stringTokenizer.nextToken());
        }
    }
    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException{
        StringTokenizer stringTokenizer;
        stringTokenizer = new StringTokenizer(line,"_");
        if(stringTokenizer.countTokens()!=7){
            throw new DataFormatException(line);
        }else {
            stringTokenizer.nextToken();
            return new CoffeeBrewer(stringTokenizer.nextToken(),stringTokenizer.nextToken(),
                    Double.parseDouble(stringTokenizer.nextToken()),stringTokenizer.nextToken(),
                    stringTokenizer.nextToken(),Integer.parseInt(stringTokenizer.nextToken()));
        }
    }
    public Catalog loadCatalog(String filename) throws FileNotFoundException, IOException, DataFormatException{
        Catalog catalog = new Catalog();
        try{
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader( new FileInputStream(filename)));

            String line = bufferedReader.readLine();
            while (line!=null){
                if(line.startsWith("Coffee")){
                    catalog.addProduct(readCoffee(line));
                }
                else if(line.startsWith("Brewer")){
                    catalog.addProduct(readCoffeeBrewer(line));
                }
                else if(line.startsWith("Product")){
                    catalog.addProduct(readProduct(line));
                }else {
                    throw new DataFormatException(line);
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch (FileNotFoundException fnfe){
            stdErr.println("The file does not exist");
        }
        return catalog;
    }

}
