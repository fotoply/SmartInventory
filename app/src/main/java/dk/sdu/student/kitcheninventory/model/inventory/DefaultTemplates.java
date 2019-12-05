package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public class DefaultTemplates {
    private static List<ProductTemplate> defaultTemplates = new ArrayList<>();

    static {
        defaultTemplates.add(new ProductTemplate("Minimælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Letmælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Sødmælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Skummemælk", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Smoothie", "Drikkelse", 2, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Æblejuice", "Drikkelse", 7, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Solbær Saft", "Drikkelse", 14, 1.0, "L"));
        defaultTemplates.add(new ProductTemplate("Vitamin Well Prepare", "Drikkelse", 90, 1.0, "stk", "7350042717743"));
        defaultTemplates.add(new ProductTemplate("Cola", "Drikkelse", 180, 1, "g", "782352600235"));
        defaultTemplates.add(new ProductTemplate("Havregryn", "Grøntsager", 28, 1.0, "stk"));
        defaultTemplates.add(new ProductTemplate("Tomat", "Grøntsag", 7, 1, "stk", "234236340968"));
        defaultTemplates.add(new ProductTemplate("Broccoli", "Grøntsag", 7, 1, "g", "874395242234"));
        defaultTemplates.add(new ProductTemplate("Løg", "Grøntsag", 14, 1, "stk", "324236872709"));
        defaultTemplates.add(new ProductTemplate("Jordbær", "Grøntsag", 14, 1, "g", "231289382112"));
        defaultTemplates.add(new ProductTemplate("Gulerødder", "Grøntsag", 10, 1, "g", "123819203889"));
        defaultTemplates.add(new ProductTemplate("Hvidløg", "Grøntsag", 12, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Persille", "Grøntsag", 8, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Purløg", "Grøntsag", 8, 1, "stk", ""));
        defaultTemplates.add(new ProductTemplate("Hakkekød", "Kød", 2, 1, "g", "978020137962"));
        defaultTemplates.add(new ProductTemplate("Kylling", "Kød", 4, 1, "g", "903202810534"));
        defaultTemplates.add(new ProductTemplate("Bacon", "Kød", 3, 1, "g", "982342023489"));
        defaultTemplates.add(new ProductTemplate("Roast beef", "Kød", 2, 1, "g", "124291234234"));
        defaultTemplates.add(new ProductTemplate("Kalkunbryst", "Kød", 2, 1, "g", "509452342352"));
        defaultTemplates.add(new ProductTemplate("Banan", "Frugt", 7, 1, "stk", "397093453490"));
        defaultTemplates.add(new ProductTemplate("Annanas", "Frugt", 7, 1, "g", "239183091901"));
        defaultTemplates.add(new ProductTemplate("Æble", "Frugt", 10, 1, "stk", "476529483289"));
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
