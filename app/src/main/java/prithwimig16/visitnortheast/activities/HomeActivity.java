package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import prithwimig16.visitnortheast.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvSigInLater;
    ImageView loginManual, loginwithFb, loginWithGoogle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
    }

    private void init() {
        this.loginManual = (ImageView) findViewById(R.id.img_login_logo);
        this.loginManual.setOnClickListener(this);

        this.loginwithFb = (ImageView) findViewById(R.id.img_fb_logo);
        this.loginwithFb.setOnClickListener(this);

        this.loginWithGoogle = (ImageView) findViewById(R.id.img_g_logo);
        this.loginWithGoogle.setOnClickListener(this);

        this.tvSigInLater = (TextView) findViewById(R.id.tv_signin_ltr);
        this.tvSigInLater.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_login_logo:
                break;

            case R.id.img_fb_logo:
                break;

            case R.id.img_g_logo:
                break;

            case R.id.tv_signin_ltr:
                Intent i = new Intent(HomeActivity.this, CityListActivity.class);
                startActivity(i);
                break;
        }
    }
}
