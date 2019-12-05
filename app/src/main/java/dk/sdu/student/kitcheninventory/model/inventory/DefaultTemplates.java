package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class DefaultTemplates {
    private static List<ProductTemplate> defaultTemplates = new ArrayList<>();

    static {
        defaultTemplates.add(new ProductTemplate("Minimælk", "Drikkelse", 7, 1.0, "L", "2139182931234"));
        defaultTemplates.add(new ProductTemplate("Letmælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Sødmælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Skummemælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Smoothie", "Drikkelse", 2, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Æblejuice", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Solbær Saft", "Drikkelse", 14, 1.0, "L", "1231274981248"));
        defaultTemplates.add(new ProductTemplate("Vitamin Well Prepare", "Drikkelse", 90, 1.0, "stk", "7350042717743"));
        defaultTemplates.add(new ProductTemplate("Cola", "Drikkelse", 180, 1, "g", "7823526002357"));
        defaultTemplates.add(new ProductTemplate("Havregryn", "Grøntsager", 28, 1.0, "stk"));
        defaultTemplates.add(new ProductTemplate("Tomat", "Grøntsag", 7, 1, "stk", "2342363409686"));
        defaultTemplates.add(new ProductTemplate("Broccoli", "Grøntsag", 7, 1, "g", "8743952422347"));
        defaultTemplates.add(new ProductTemplate("Løg", "Grøntsag", 14, 1, "stk", "3242368727091"));
        defaultTemplates.add(new ProductTemplate("Jordbær", "Grøntsag", 14, 1, "g", "2312893821128"));
        defaultTemplates.add(new ProductTemplate("Gulerødder", "Grøntsag", 10, 1, "g", "1238192038894"));
        defaultTemplates.add(new ProductTemplate("Hvidløg", "Grøntsag", 12, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Persille", "Grøntsag", 8, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Purløg", "Grøntsag", 8, 1, "stk", "2342341289743"));
        defaultTemplates.add(new ProductTemplate("Hakkekød", "Kød", 2, 1, "g", "9780201379624"));
        defaultTemplates.add(new ProductTemplate("Kylling", "Kød", 4, 1, "g", "9032028105345"));
        defaultTemplates.add(new ProductTemplate("Bacon", "Kød", 3, 1, "g", "9823420234890"));
        defaultTemplates.add(new ProductTemplate("Roast beef", "Kød", 2, 1, "g", "1242912342345"));
        defaultTemplates.add(new ProductTemplate("Kalkunbryst", "Kød", 2, 1, "g", "5094523423526"));
        defaultTemplates.add(new ProductTemplate("Banan", "Frugt", 7, 1, "stk", "3970934534902"));
        defaultTemplates.add(new ProductTemplate("Annanas", "Frugt", 7, 1, "g", "2391830919012"));
        defaultTemplates.add(new ProductTemplate("Æble", "Frugt", 10, 1, "stk", "4765294832893"));
        defaultTemplates.add(new ProductTemplate("Avocado", "Frugt", 3, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Appelsin", "Frugt", 3, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Parlomo", "Frugt", 3, 1, "stk", ""));


    }

    private static Random random = new Random();

    public static List<ProductTemplate> search(final String searchString) {
        return search(searchString, 10);
    }

    public static List<ProductTemplate> search(final String searchString, int limit) {
        return defaultTemplates.stream()
                .filter(defaultTemplates1 -> defaultTemplates1.getName().toLowerCase().contains(searchString.toLowerCase()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static ProductTemplate getByBarcode(String barcode) {
        Optional<ProductTemplate> barcodeResult = defaultTemplates.stream()
                .filter(productTemplate -> productTemplate.getBarcode().equals(barcode))
                .findFirst();
        return barcodeResult.orElse(null);
    }

    public static ProductTemplate getRandomProduct() {
        return defaultTemplates.get(random.nextInt(defaultTemplates.size()));
    }
}
