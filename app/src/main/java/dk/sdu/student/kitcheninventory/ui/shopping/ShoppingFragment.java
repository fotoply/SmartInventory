package dk.sdu.student.kitcheninventory.ui.shopping;

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
import dk.sdu.student.kitcheninventory.data.shopping.ShoppingGroceryListData;
import dk.sdu.student.kitcheninventory.ui.recipes.RecipesRecyclerViewAdapter;

public class ShoppingFragment extends Fragment
{

    private ShoppingViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        notificationsViewModel =
                ViewModelProviders.of(this).get(ShoppingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_shopping, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ShoppingRecyclerViewAdapter(root.getContext(), ShoppingGroceryListData.GetData()));
        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));

        return root;
    }
}