package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import prithwimig16.visitnortheast.R;

public class HomeActivity extends AppCompatActivity {

    TextView tvSigInLater;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.tvSigInLater = (TextView) findViewById(R.id.tv_signin_ltr);
        this.tvSigInLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, CityListActivity.class);
                startActivity(i);
            }
        });
    }


}
