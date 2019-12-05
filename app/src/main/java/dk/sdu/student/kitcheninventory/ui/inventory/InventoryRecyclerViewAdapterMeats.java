package dk.sdu.student.kitcheninventory.ui.inventory;

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

public class InventoryRecyclerViewAdapterMeats extends RecyclerView.Adapter<InventoryRecyclerViewAdapterMeats.RecyclerViewHolder>
{
    private final LayoutInflater inflater;
    private List<Ingredient> data = Collections.emptyList();

    public InventoryRecyclerViewAdapterMeats(Context context, List<Ingredient> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.inventory_recyclerview_meats_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
        Ingredient currentRecipe = data.get(position);
        holder.name.setText(currentRecipe.getProduct().getName());
        holder.icon.setImageResource(R.drawable.milk);
        holder.amount.setText(Double.toString(currentRecipe.getAmount()));
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
        public final TextView name;
        public final ImageView icon;
        public final TextView amount;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.meatsProductNameTextView);
            icon = itemView.findViewById(R.id.meatsProductIconImageView);
            amount = itemView.findViewById(R.id.meatsAmountTextView);
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