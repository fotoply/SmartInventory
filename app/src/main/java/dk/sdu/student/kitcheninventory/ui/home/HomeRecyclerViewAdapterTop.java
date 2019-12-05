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

public class HomeRecyclerViewAdapterTop extends RecyclerView.Adapter<HomeRecyclerViewAdapterTop.RecyclerViewHolder>
{
    private final LayoutInflater inflater;
    private List<Ingredient> data = Collections.emptyList();

    public HomeRecyclerViewAdapterTop(Context context, List<Ingredient> data)
    {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.home_recyclerview_top_row, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position)
    {
        Ingredient currentRecipe = data.get(position);
        holder.name.setText(currentRecipe.getProduct().getName());
        switch (currentRecipe.getProduct().getCategory()) {
            case "Kød":
                holder.icon.setImageResource(R.drawable.meat);
                break;

            case "Grøntsag":
                holder.icon.setImageResource(R.drawable.broccoli);
                break;

            case "Drikkelse":
                holder.icon.setImageResource(R.drawable.milk);
                break;

            case "Frugt":
                holder.icon.setImageResource(R.drawable.apple);
                break;

        }
        holder.expiration.setText(currentRecipe.getProduct().getFormattedExpiration());
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
        public final TextView expiration;

        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            name = itemView.findViewById(R.id.productNameTextView);
            icon = itemView.findViewById(R.id.productIconImageView);
            expiration = itemView.findViewById(R.id.expirationDateTextView);
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