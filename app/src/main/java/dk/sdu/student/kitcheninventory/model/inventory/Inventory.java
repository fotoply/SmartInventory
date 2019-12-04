package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {

    private static Inventory instance;

    private Inventory() {
        instance = this;
        compartments = new ArrayList<>();
    }

    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    private List<StorageCompartment> compartments;

    public StorageCompartment getCompartmentByName(String name) {
        return compartments.stream().filter(storageCompartment -> storageCompartment.getName().equals(name)).findFirst().get();
    }


    public List<String> getAllCompartmentNames() {
        return compartments.stream().map(StorageCompartment::getName).collect(Collectors.toList());
    }
}
