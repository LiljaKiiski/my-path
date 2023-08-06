package lilja.kiiski.codingforchangeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class PathActivity extends AppCompatActivity {

    private TextView growth_path;
    private TextView days_on_journey;
    private TextView start_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);

        findViewById(R.id.leave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SharedPreferences settings = getApplicationContext().getSharedPreferences("user_details", 0);
        SharedPreferences.Editor editor = settings.edit();

        growth_path = (TextView) findViewById(R.id.growth_path);
        days_on_journey = (TextView) findViewById(R.id.num_days);
        start_date = (TextView) findViewById(R.id.start_journey);

        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String formattedDate = df.format(c);

        growth_path.setText("You are on your path to " + settings.getString("user_path", "null"));
        start_date.setText("You started your journey on " + settings.getString("start_date", formattedDate));

        String CurrentDate= settings.getString("start_date", formattedDate);
        String FinalDate= formattedDate;
        Date date1;
        Date date2;
        SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date1 = dates.parse(CurrentDate);
            date2 = dates.parse(FinalDate);
            long difference = Math.abs(date1.getTime() - date2.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000) + 1;

            if (differenceDates > 1) {
                days_on_journey.setText("You have been on your journey " + differenceDates + " days");
            } else {
                days_on_journey.setText("You have been on your journey " + differenceDates + " day");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("EXCEPTION");
        }
    }
}