package lilja.kiiski.codingforchangeapp.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import lilja.kiiski.codingforchangeapp.DeepBreathActivity;
import lilja.kiiski.codingforchangeapp.MainActivity;
import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.WelcomeActivity;
import lilja.kiiski.codingforchangeapp.databinding.FragmentDiscoverBinding;
import lilja.kiiski.codingforchangeapp.databinding.FragmentHomeBinding;
import lilja.kiiski.codingforchangeapp.ui.welcome.Welcome2;

public class DiscoverFragment extends Fragment {

    private FragmentDiscoverBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}