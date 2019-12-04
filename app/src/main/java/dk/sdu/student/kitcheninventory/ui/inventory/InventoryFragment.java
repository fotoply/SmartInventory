package dk.sdu.student.kitcheninventory.ui.inventory;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dk.sdu.student.kitcheninventory.R;
import dk.sdu.student.kitcheninventory.data.inventory.InventoryBeveragesData;
import dk.sdu.student.kitcheninventory.data.inventory.InventoryFruitsData;
import dk.sdu.student.kitcheninventory.data.inventory.InventoryMeatsData;
import dk.sdu.student.kitcheninventory.data.inventory.InventoryVegetablesData;
import dk.sdu.student.kitcheninventory.ui.recipes.RecipesRecyclerViewAdapter;

public class InventoryFragment extends Fragment
{

    private InventoryViewModel contentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        contentViewModel = ViewModelProviders.of(this).get(InventoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_inventory, container, false);

        LinearLayoutManager layoutManagerBeverages = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewBeverages = root.findViewById(R.id.recyclerViewBeverages);
        recyclerViewBeverages.setAdapter(new InventoryRecyclerViewAdapterBeverages(root.getContext(), InventoryBeveragesData.GetData()));
        recyclerViewBeverages.setLayoutManager(layoutManagerBeverages);

        LinearLayoutManager layoutManagerMeats = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewMeats = root.findViewById(R.id.recyclerViewMeats);
        recyclerViewMeats.setAdapter(new InventoryRecyclerViewAdapterMeats(root.getContext(), InventoryMeatsData.GetData()));
        recyclerViewMeats.setLayoutManager(layoutManagerMeats);

        LinearLayoutManager layoutManagerFruits = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewFruits = root.findViewById(R.id.recyclerViewFruits);
        recyclerViewFruits.setAdapter(new InventoryRecyclerViewAdapterFruits(root.getContext(), InventoryFruitsData.GetData()));
        recyclerViewFruits.setLayoutManager(layoutManagerFruits);

        LinearLayoutManager layoutManagerVegetables= new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewVegetables = root.findViewById(R.id.recyclerViewVegetables);
        recyclerViewVegetables.setAdapter(new InventoryRecyclerViewAdapterVegetables(root.getContext(), InventoryVegetablesData.GetData()));
        recyclerViewVegetables.setLayoutManager(layoutManagerVegetables);

        return root;
    }
}