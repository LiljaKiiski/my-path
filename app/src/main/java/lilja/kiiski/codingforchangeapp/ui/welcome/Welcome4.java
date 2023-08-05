package lilja.kiiski.codingforchangeapp.ui.welcome;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}