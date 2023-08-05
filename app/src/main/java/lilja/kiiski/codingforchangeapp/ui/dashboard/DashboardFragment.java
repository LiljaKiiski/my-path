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
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    PieChart pieChart;
    PieDataSet pieDataSet;

    PieData pieData;
    ArrayList<PieEntry> pieEntries;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pieChart = view.findViewById(R.id.idBarChart);
        getPieEntries();
        pieDataSet = new PieDataSet(pieEntries, "Your mood");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);

        pieDataSet.setValueTextSize(16f);
        pieChart.getDescription().setEnabled(false);
    }

    private void getPieEntries() {
        pieEntries = new ArrayList<>();

        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("user_mood", 0);
        String user_name = settings.getString("user_name", "");

        for(int x = 1; x <= 7; x++){
            int num = settings.getInt(x + "", 0);
            pieEntries.add(new PieEntry(num, "⛈️"));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}