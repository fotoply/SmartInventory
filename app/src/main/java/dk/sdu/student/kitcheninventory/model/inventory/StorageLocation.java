package dk.sdu.student.kitcheninventory.model.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageLocation {

    private static StorageLocation instance;

    private StorageLocation() {
        instance = this;
        storageCompartments = new ArrayList<>();
    }

    public static StorageLocation getInstance() {
        if (instance == null) {
            instance = new StorageLocation();
        }
        return instance;
    }

    private String name;
    private List<StorageCompartment> storageCompartments;

    public StorageCompartment getCompartmentByName(String name) {
        return storageCompartments.stream().filter(storageCompartment -> storageCompartment.getName().equals(name)).findFirst().get();
    }


    public List<String> getAllCompartmentNames() {
        return storageCompartments.stream().map(StorageCompartment::getName).collect(Collectors.toList());
    }
}
