package lilja.kiiski.codingforchangeapp.ui.welcome;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.databinding.FragmentWelcome3Binding;

public class Welcome3 extends Fragment {

    private @NonNull FragmentWelcome3Binding binding;

    private TextView welcome_text;
    private EditText name_area_text;

    public static Welcome3 newInstance() { return new Welcome3();}
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentWelcome3Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        welcome_text = (TextView) root.findViewById(R.id.greeting);
        name_area_text = root.findViewById(R.id.nameTextArea);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (name_area_text.getText().toString().length() > 0) {
            SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_details", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("user_name", name_area_text.getText().toString());
            editor.apply();

            NavHostFragment.findNavController(Welcome3.this)
                    .navigate(R.id.action_welcome_2_to_welcome_3);
        }

        view.findViewById(R.id.enterBtn).setOnClickListener(new View.OnClickListener() {
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