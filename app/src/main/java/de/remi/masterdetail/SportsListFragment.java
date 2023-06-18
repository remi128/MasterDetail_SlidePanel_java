package de.remi.masterdetail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import de.remi.masterdetail.databinding.FragmentSportsListBinding;
import de.remi.masterdetail.model.Sport;

public class SportsListFragment extends Fragment implements SportsAdapter.ItemClickListener {

    private static final String TAG = "SportsListFragment";

    private SportsViewModel sportsViewModel;
    private FragmentSportsListBinding binding;

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
        binding = FragmentSportsListBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SportsAdapter adapter = new SportsAdapter(requireContext(), this);
        binding.recyclerView.setAdapter(adapter);
        sportsViewModel.getSportList().observe(this, sportList -> adapter.submitList(sportList));
    }

    @Override
    public void itemClicked(Sport sport) {
        Log.d(TAG, "itemClicked: " + sport.id);
        sportsViewModel.setCurrentRecord(sport);
        NavDirections action =
                SportsListFragmentDirections.actionSportsListFragmentToSportsNewsFragment();
        Navigation.findNavController(requireView()).navigate(action);
    }
}
