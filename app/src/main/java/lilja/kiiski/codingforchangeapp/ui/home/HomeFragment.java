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
import lilja.kiiski.codingforchangeapp.databinding.FragmentHomeBinding;
import lilja.kiiski.codingforchangeapp.ui.welcome.Welcome2;
import lilja.kiiski.codingforchangeapp.ui.welcome.Welcome4;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView welcome_text;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        welcome_text = (TextView) root.findViewById(R.id.welcome);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
        String user_name = settings.getString("user_name", "");

        welcome_text.setText("\uD83D\uDE4B Welcome, " + user_name + "!");

        view.findViewById(R.id.startBreathBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DeepBreathActivity.class));
            }
        });

        view.findViewById(R.id.discoverBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_navigation_home_to_discover);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}