package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultTemplates {
    private static List<ProductTemplate> defaultTemplates = new ArrayList<>();

    static {
        defaultTemplates.add(new ProductTemplate("1L Minimælk", new Category(), 7, 1.0));
        defaultTemplates.add(new ProductTemplate("1L Letmælk", new Category(), 7, 1.0));
        defaultTemplates.add(new ProductTemplate("1L Sødmælk", new Category(), 7, 1.0));
        defaultTemplates.add(new ProductTemplate("1L Skummemælk", new Category(), 7, 1.0));
        defaultTemplates.add(new ProductTemplate("Havregryn", new Category(), 28, 1.0));
        defaultTemplates.add(new ProductTemplate("Vitamin Well Prepare", new Category(), 90, 1.0, "7350042717743"));

    }

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
}
