package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import prithwimig16.visitnortheast.R;


public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);

        final int SPLASH_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer.
             *
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start AllLoginActivity
                Intent startUpactivity = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(startUpactivity);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


}
