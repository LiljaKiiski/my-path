package lilja.kiiski.codingforchangeapp.ui.welcome;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome1Binding;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome5Binding;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome6Binding;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome7Binding;

public class Welcome7 extends Fragment {

    private FragmentWelcome7Binding binding;

    public static Welcome7 newInstance() {
        return new Welcome7();
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcome7Binding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.continueBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().finish();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}