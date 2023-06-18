package de.remi.masterdetail;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.remi.masterdetail.databinding.SportsListItemBinding;
import de.remi.masterdetail.model.Sport;

public class SportsAdapter extends ListAdapter<Sport, SportsAdapter.SportsViewHolder> {
    private static final String TAG = "SportsAdapter";
    private final Context context;
    private ItemClickListener listener;

    public SportsAdapter(Context context, ItemClickListener listener){
        super(new SportDiffCallback());
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SportsListItemBinding binding = SportsListItemBinding.inflate(LayoutInflater.from(context));
        return new SportsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        Sport sport = getItem(position);
        Log.d(TAG, "onBindViewHolder: position " + position + " id " + sport.id );
        holder.bind(getItem(position));
        holder.itemView.setOnClickListener( view -> listener.itemClicked(sport));
    }


    class SportsViewHolder extends RecyclerView.ViewHolder {
        private SportsListItemBinding binding;

        public SportsViewHolder(SportsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind( Sport sport ){
            binding.title.setText( context.getString(sport.titleResourceId));
            binding.subTitle.setText( context.getString(sport.subTitleResourceId));
            // Load the images into the ImageView using the Coil library.
            binding.sportsImage.setImageResource (sport.imageResourceId);
        }
    }

    static class SportDiffCallback extends DiffUtil.ItemCallback<Sport> {

        @Override
        public boolean areItemsTheSame(@NonNull Sport oldItem, @NonNull Sport newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Sport oldItem, @NonNull Sport newItem) {
            return oldItem.titleResourceId == newItem.titleResourceId;
        }
    }

    interface ItemClickListener {
        void itemClicked( Sport sport );
    }
}
