package lilja.kiiski.codingforchangeapp.ui.welcome;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome4Binding;

public class Welcome4 extends Fragment {

    private @NonNull FragmentWelcome4Binding binding;

    private TextView welcome_text;

    public static Welcome4 newInstance() { return new Welcome4();}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcome4Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        welcome_text = (TextView) root.findViewById(R.id.niceToMeetYou);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
        String user_name = settings.getString("user_name", "");

        welcome_text.setText("It great to meet you " + user_name + "!");

        view.findViewById(R.id.low).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user_status", "low");
                editor.apply();

                NavHostFragment.findNavController(Welcome4.this)
                        .navigate(R.id.action_welcome_4_to_welcome_5);
            }
        });

        view.findViewById(R.id.med_low).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user_status", "med_low");
                editor.apply();

                NavHostFragment.findNavController(Welcome4.this)
                        .navigate(R.id.action_welcome_4_to_welcome_5);
            }
        });

        view.findViewById(R.id.med).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user_status", "med");
                editor.apply();

                NavHostFragment.findNavController(Welcome4.this)
                        .navigate(R.id.action_welcome_4_to_welcome_5);
            }
        });

        view.findViewById(R.id.med_high).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user_status", "med_high");
                editor.apply();

                NavHostFragment.findNavController(Welcome4.this)
                        .navigate(R.id.action_welcome_4_to_welcome_5);
            }
        });

        view.findViewById(R.id.high).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("user_status", "high");
                editor.apply();

                NavHostFragment.findNavController(Welcome4.this)
                        .navigate(R.id.action_welcome_4_to_welcome_5);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}