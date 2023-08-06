package lilja.kiiski.codingforchangeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

        growth_path.setText("You are on your path to " + settings.getString("user_path", "null"));


    }
}