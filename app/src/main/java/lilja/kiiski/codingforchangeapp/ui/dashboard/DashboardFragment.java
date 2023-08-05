package lilja.kiiski.codingforchangeapp.ui.dashboard;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import lilja.kiiski.codingforchangeapp.R;
import lilja.kiiski.codingforchangeapp.databinding.FragmentDashboardBinding;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList<BarEntry> barEntriesArrayList;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barChart = view.findViewById(R.id.idBarChart);
        getBarEntries();
        barDataSet = new BarDataSet(barEntriesArrayList, "Your mood");
        barData = new BarData(barDataSet);
        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);

        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

    }

    private void getBarEntries() {
        barEntriesArrayList = new ArrayList<>();

        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
        String user_name = settings.getString("user_name", "");

        for(int x = 1; x <= 7; x++){
            int num = settings.getInt(x + "", 0);
            barEntriesArrayList.add(new BarEntry(x, num));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}