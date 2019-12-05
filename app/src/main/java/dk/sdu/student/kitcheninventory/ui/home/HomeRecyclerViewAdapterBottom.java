package dk.sdu.student.kitcheninventory.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.Collections;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import dk.sdu.student.kitcheninventory.R;
import dk.sdu.student.kitcheninventory.model.recipes.Ingredient;

public class HomeRecyclerViewAdapterBottom extends RecyclerView.Adapter<HomeRecyclerViewAdapterBottom.RecyclerViewHolder>
{
    private final LayoutInflater inflater;
    private List<Ingredient> data = Collections.emptyList();

    public HomeRecyclerViewAdapterBottom(Context context, List<Ingredient> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.home_recyclerview_bottom_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
        Ingredient currentRecipe = data.get(position);
        holder.recipesNameTextView.setText("Cæsar salat");
        holder.recipesImageView.setImageResource(R.drawable.salad);
        holder.recipesTextView.setText("Servér hjemmelavet Cæsar Salat med lækker dressing, croutoner og ostechips..");
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public void Delete(int position)
    {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public final TextView recipesNameTextView;
        public final ImageView recipesImageView;
        public final TextView recipesTextView;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            recipesNameTextView = itemView.findViewById(R.id.homeRecipesNameTextView);
            recipesImageView = itemView.findViewById(R.id.homeRecipesImageView);
            recipesTextView = itemView.findViewById(R.id.homeRecipesTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Snackbar.make(v, "Item " + getPosition() + " has been deleted", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            Delete(getPosition());
        }
    }
}