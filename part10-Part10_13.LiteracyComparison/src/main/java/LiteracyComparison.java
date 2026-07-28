
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        
        ArrayList<LiteracyRate> rows = new ArrayList<>();
        
        try {
            
            Files.lines(Paths.get("literacy.csv"))
                    .map(row -> row.split(","))
                    .filter(parts -> parts.length >= 6)
                    .map(parts -> new LiteracyRate(parts[0].trim(), 
                            parts[1].trim(), 
                            parts[2].replace("(%)", "").trim(), 
                            parts[3].trim(), 
                            Integer.valueOf(parts[4]), 
                            Double.valueOf(parts[5])))
                    .sorted((l1, l2) -> l1.compareTo(l2))
                    .forEach(l -> System.out.println(l));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }
}
