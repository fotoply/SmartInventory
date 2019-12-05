package dk.sdu.student.kitcheninventory.ui.recipes;

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

public class RecipesRecyclerViewAdapter extends RecyclerView.Adapter<RecipesRecyclerViewAdapter.RecyclerViewHolder>
{
    private final LayoutInflater inflater;
    private List<Ingredient> data = Collections.emptyList();

    public RecipesRecyclerViewAdapter(Context context, List<Ingredient> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.recipes_recyclerview_row, parent, false);
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
            recipesNameTextView = itemView.findViewById(R.id.recipesRecipesNameTextView);
            recipesImageView = itemView.findViewById(R.id.recipesRecipesImageView);
            recipesTextView = itemView.findViewById(R.id.recipesRecipesTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {
            Snackbar.make(v, "Vare " + getPosition() + " er blevet slettet", Snackbar.LENGTH_SHORT).setAction("Action", null).show();
            Delete(getPosition());
        }
    }
}