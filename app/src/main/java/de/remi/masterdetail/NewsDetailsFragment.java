package de.remi.masterdetail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import de.remi.masterdetail.databinding.FragmentSportsNewsBinding;
import de.remi.masterdetail.model.Sport;

public class NewsDetailsFragment extends Fragment  {
    private static final String TAG = "NewsDetailsFragment";

    private SportsViewModel sportsViewModel;
    private FragmentSportsNewsBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //important: get a common ViewModel from the activity
        sportsViewModel = new ViewModelProvider(requireActivity()).get(SportsViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSportsNewsBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated: called");
        super.onViewCreated(view, savedInstanceState);
        sportsViewModel.getCurrentRecord().observe(this, sport -> {
            Log.d(TAG, "onViewCreated: " + sport.id );
            String title = getString(sport.titleResourceId);
            String detailText = getString(sport.newsDetails);
            binding.titleDetail.setText( title );
            binding.newsDetail.setText( title + "\n" + detailText);
            binding.sportsImageDetail.setImageResource (sport.sportsImageBanner);

        });
    }
}
