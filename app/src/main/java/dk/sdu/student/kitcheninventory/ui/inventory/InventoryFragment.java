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
        recyclerViewBeverages.setAdapter(new RecipesRecyclerViewAdapter(root.getContext(), InventoryRecyclerViewDataBeverages.GetData()));
        recyclerViewBeverages.setLayoutManager(layoutManagerBeverages);

        LinearLayoutManager layoutManagerMeats = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewMeats = root.findViewById(R.id.recyclerViewMeats);
        recyclerViewMeats.setAdapter(new RecipesRecyclerViewAdapter(root.getContext(), InventoryRecyclerViewDataMeats.GetData()));
        recyclerViewMeats.setLayoutManager(layoutManagerMeats);

        LinearLayoutManager layoutManagerFruits = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewFruits = root.findViewById(R.id.recyclerViewFruits);
        recyclerViewFruits.setAdapter(new RecipesRecyclerViewAdapter(root.getContext(), InventoryRecyclerViewDataFruits.GetData()));
        recyclerViewFruits.setLayoutManager(layoutManagerFruits);

        LinearLayoutManager layoutManagerVegetables= new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerViewVegetables = root.findViewById(R.id.recyclerViewVegetables);
        recyclerViewVegetables.setAdapter(new RecipesRecyclerViewAdapter(root.getContext(), InventoryRecyclerViewDataVegetables.GetData()));
        recyclerViewVegetables.setLayoutManager(layoutManagerVegetables);

        return root;
    }
}