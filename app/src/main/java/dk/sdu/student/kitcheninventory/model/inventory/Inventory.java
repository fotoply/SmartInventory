package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;

public class Inventory {

    private static Inventory instance;
    private StorageCompartment DEFAULT_STORAGE_COMPARTMENT;

    private Inventory() {
        instance = this;
        compartments = new ArrayList<>();
        DEFAULT_STORAGE_COMPARTMENT = new StorageCompartment("Mangler køkkenplads");

        //TEST DATA BELOW
        addCompartment("Kød");
        addCompartment("Frugt");
        addCompartment("Grøntsag");
        addCompartment("Drikkelse");

        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            Product randomProduct = new Product();
            randomProduct.applyTemplate(DefaultTemplates.getRandomProduct());
            int variation = random.nextInt(5) - 2;
            randomProduct.setExpirationInDays((int) (randomProduct.getDaysUntilExpiration() + variation));
            addProduct(randomProduct);
        }

    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    private List<StorageCompartment> compartments;

    public StorageCompartment getCompartmentByName(String name) {
        return compartments.stream().filter(storageCompartment -> storageCompartment.getName().equals(name)).findFirst().orElse(null);
    }

    public List<String> getAllCompartmentNames() {
        return compartments.stream().map(StorageCompartment::getName).collect(Collectors.toList());
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new NoSuchElementException("Cannot add null products");
        }

        StorageCompartment compartment = getCompartmentByName(product.getCategory());
        if (compartment == null) {
            DEFAULT_STORAGE_COMPARTMENT.addProduct(product);
        } else {
            compartment.addProduct(product);
        }
        System.out.println(product.getName() + " was added");
    }

    public void addCompartment(String name) {
        compartments.add(new StorageCompartment(name));
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        for (StorageCompartment storageCompartment : compartments) {
            products.addAll(storageCompartment.getProducts());
        }
        products.addAll(DEFAULT_STORAGE_COMPARTMENT.getProducts());
        return products;
    }

    public List<Product> getProductsByExpirationDate() {
        return getProductsByExpirationDate(10);
    }

    public List<Product> getProductsByExpirationDate(int limit) {
        List<Product> result = getAllProducts();
        result.sort((o1, o2) -> (int) (o1.getDaysUntilExpiration() - o2.getDaysUntilExpiration()));
        if (result.size() < limit) {
            return result;
        }
        return result.subList(0, limit - 1);
    }
}
