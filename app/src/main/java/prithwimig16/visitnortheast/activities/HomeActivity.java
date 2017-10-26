package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.util.Arrays;

import prithwimig16.visitnortheast.R;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {

    TextView tvSigInLater;
    ImageView loginManual, loginwithFb, loginWithGoogle;
    private CallbackManager callbackManager;

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
        this.callbackManager = CallbackManager.Factory.create();


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_login_logo:
                Intent loginIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;

            case R.id.img_fb_logo:
                LoginWithFacebook();
                break;

            case R.id.img_g_logo:
                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestEmail()
                        .build();
                break;

            case R.id.tv_signin_ltr:
                Intent i = new Intent(HomeActivity.this, CityListActivity.class);
                i.putExtra("isSigninLater", true);
                startActivity(i);
                break;
        }
    }

    private void LoginWithFacebook() {
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("email"));
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                String faceBookUserId = loginResult.getAccessToken().getUserId();
                getFbUserDetails(loginResult);
            }

            @Override
            public void onCancel() {

//                final Dialog alertDialog = new Dialog(HomeActivity.this);
//                alertDialog.setTitle("Facebook Login Failed");
//                alertDialog.show();
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(HomeActivity.this);

                alertDialog2.setTitle("Visit NorthEast");

                alertDialog2.setMessage("Facebook Login Failed");

            }

            @Override
            public void onError(FacebookException error) {
                AlertDialog.Builder alertDialog2 = new AlertDialog.Builder(HomeActivity.this);

                alertDialog2.setTitle("Visit NorthEast");

                alertDialog2.setMessage("Facebook Login Failed");

            }
        });
    }

    protected void getFbUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        Intent intent = new Intent(HomeActivity.this, CityListActivity.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
