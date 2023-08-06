package lilja.kiiski.codingforchangeapp.ui.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

import lilja.kiiski.codingforchangeapp.DeepBreathActivity;
import lilja.kiiski.codingforchangeapp.DiscoverActivity;
import lilja.kiiski.codingforchangeapp.MainActivity;
import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.WelcomeActivity;
import lilja.kiiski.codingforchangeapp.databinding.FragmentHomeBinding;
import lilja.kiiski.codingforchangeapp.ui.welcome.Welcome2;
import lilja.kiiski.codingforchangeapp.ui.welcome.Welcome4;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TextView welcome_text;
    private TextView mood_text;

    private Button b1, b2, b3, b4, b5;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        welcome_text = (TextView) root.findViewById(R.id.welcome);
        mood_text = (TextView) root.findViewById(R.id.the_mood);

        b1 = ((Button)root.findViewById(R.id.low));
        b2 = ((Button)root.findViewById(R.id.med_low));
        b3 = ((Button)root.findViewById(R.id.med));
        b4 = ((Button)root.findViewById(R.id.med_high));
        b5 = ((Button)root.findViewById(R.id.high));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
        String user_name = settings.getString("user_name", "");

        welcome_text.setText("\uD83D\uDE4B Welcome, " + user_name + "!");

        view.findViewById(R.id.low).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
                SharedPreferences.Editor editor = settings.edit();
                int num = settings.getInt("num_entries", 0);
                editor.putInt(num + "", 1);
                editor.putInt("num_entries", num + 1);
                editor.apply();
                disappearAllButtons(view);
                mood_text.setText("⛈️");
                mood_text.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.med_low).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
                SharedPreferences.Editor editor = settings.edit();
                int num = settings.getInt("num_entries", 0);
                editor.putInt(num + "", 2);
                editor.putInt("num_entries", num + 1);
                editor.apply();
                disappearAllButtons(view);
                mood_text.setText("\uD83C\uDF27️");
                mood_text.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.med).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
                SharedPreferences.Editor editor = settings.edit();
                int num = settings.getInt("num_entries", 0);
                editor.putInt(num + "", 3);
                editor.putInt("num_entries", num + 1);
                editor.apply();
                disappearAllButtons(view);
                mood_text.setText("☁️");
                mood_text.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.med_high).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
                SharedPreferences.Editor editor = settings.edit();
                int num = settings.getInt("num_entries", 0);
                editor.putInt(num + "", 4);
                editor.putInt("num_entries", num + 1);
                editor.apply();
                disappearAllButtons(view);
                mood_text.setText("\uD83C\uDF24️");
                mood_text.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.high).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
                SharedPreferences.Editor editor = settings.edit();
                int num = settings.getInt("num_entries", 0);
                editor.putInt(num + "", 5);
                editor.putInt("num_entries", num + 1);
                editor.apply();
                disappearAllButtons(view);
                mood_text.setText("☀️️");
                mood_text.setVisibility(View.VISIBLE);
            }
        });

        view.findViewById(R.id.startBreathBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DeepBreathActivity.class));
            }
        });

        view.findViewById(R.id.discoverBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), DiscoverActivity.class));
            }
        });
    }

    public void disappearAllButtons(View view){
        b1.setVisibility(View.GONE);
        b2.setVisibility(View.GONE);
        b3.setVisibility(View.GONE);
        b4.setVisibility(View.GONE);
        b5.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}