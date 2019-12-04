package dk.sdu.student.kitcheninventory.ui.recipes;

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

public class RecipesFragment extends Fragment
{

    private RecipesViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        notificationsViewModel =
                ViewModelProviders.of(this).get(RecipesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recipes, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new RecipesRecyclerViewAdapter(root.getContext(), RecipesRecyclerViewData.GetData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        return root;
    }
}