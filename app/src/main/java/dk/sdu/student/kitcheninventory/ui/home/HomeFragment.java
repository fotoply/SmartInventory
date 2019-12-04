package dk.sdu.student.kitcheninventory.ui.home;

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
import dk.sdu.student.kitcheninventory.data.home.HomeExpiresSoonData;
import dk.sdu.student.kitcheninventory.data.home.HomeSuggestedRecipesData;
import dk.sdu.student.kitcheninventory.ui.recipes.RecipesRecyclerViewAdapter;

public class HomeFragment extends Fragment
{

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(root.getContext(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = root.findViewById(R.id.homeRecyclerViewTop);
        recyclerView.setAdapter(new HomeRecyclerViewAdapterTop(root.getContext(), HomeExpiresSoonData.GetData()));
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView recyclerViewBottom = root.findViewById(R.id.homeRecyclerViewBottom);
        recyclerViewBottom.setAdapter(new HomeRecyclerViewAdapterBottom(root.getContext(), HomeSuggestedRecipesData.GetData()));
        recyclerViewBottom.setLayoutManager(new LinearLayoutManager(root.getContext()));

        return root;
    }
}