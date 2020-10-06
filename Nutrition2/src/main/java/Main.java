import model.Aliment;
import model.AlimentNQ;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<AlimentNQ> foodEaten = getQuantities();
        List<Aliment> alimente = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("alimente.txt"))) {
            String line;

            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String values[] = line.split(", ");
                AlimentNQ alimentNQ = new AlimentNQ();
                alimentNQ.setName(values[0]);
                if (foodEaten.contains(alimentNQ)) {
                    Aliment aliment = new Aliment(values[0], Double.parseDouble(values[1]), Double.parseDouble(values[2]), Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), Double.parseDouble(values[6]), Double.parseDouble(values[7]), foodEaten.get(foodEaten.indexOf(alimentNQ)).getQuantity());
                    alimente.add(aliment);
                    foodEaten.remove(alimentNQ);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("calorii.txt")))) {
            Aliment meal = Aliment.calculateMacros(alimente);
            String toWrite = "         <<<   ^^^   TOTAL   ^^^   >>>\n\n"
                    + "\n   <<<           KCAL          >>>   " + round(meal.getKcal(), 3)
                    + "\n   <<<     GRASIMI SATURATE    >>>   " + round(meal.getGrasimiSaturate(), 3)
                    + "\n   <<<    GRASIMI NESATURATE   >>>   " + round(meal.getGrasimiNesaturate(), 3)
                    + "\n   <<<          ZAHAR          >>>   " + round(meal.getZahar(), 3)
                    + "\n   <<<  CARBOHIDRATI COMPLECSI >>>   " + round(meal.getCarbohidratiComplecsi(), 3)
                    + "\n   <<<         PROTEINE        >>>   " + round(meal.getProteine(), 3)
                    + "\n   <<<          FIBRE          >>>   " + round(meal.getFibre(), 3)
                    + "\n   <<<    CANTITATE TOTALA     >>>   " + round(meal.getCantitate(), 3);

            writer.write(toWrite);
            if (!foodEaten.isEmpty()) {
                foodEaten.forEach(food -> {
                    try {
                        writer.write("\nAliment negasit: " + food.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<AlimentNQ> getQuantities() {
        List<AlimentNQ> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("quantities.txt"))) {
            String line;

            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String values[] = line.split(", ");
                AlimentNQ alimentNQ = new AlimentNQ();
                alimentNQ.setName(values[0]);
                alimentNQ.setQuantity(Double.parseDouble(values[1]));
                list.add(alimentNQ);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static double round(double value, int places) {
        if (places < 0) throw  new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
