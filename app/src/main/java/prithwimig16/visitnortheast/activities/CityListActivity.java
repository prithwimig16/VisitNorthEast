package prithwimig16.visitnortheast.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.json.JSONObject;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.adapter.CityListAdapter;
import prithwimig16.visitnortheast.utils.CustomTitleTextView;

public class CityListActivity extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    CityListAdapter adapter;
    FirebaseUser firebaseUser;
    JSONObject fbResponse;
    CustomTitleTextView tvLogout;
    FirebaseAuth firebaseAuth;
    boolean isSigninLater = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        Bundle intent = getIntent().getExtras();
        if (intent != null) {
            this.isSigninLater = intent.getBoolean("isSigninLater");
        }

        this.firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if (firebaseUser != null) {
            // User is signed in
            String name = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();
            String uid = firebaseUser.getUid();
        }
        init();
        this.gridView.setAdapter(this.adapter);

        //  Log.d("Firebase", "token "+ FirebaseInstanceId.getInstance().getToken());

        this.tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logOutAction();
            }
        });

    }

    private void init() {
        this.gridView = (GridView) findViewById(R.id.gridview_city_activity);
        this.adapter = new CityListAdapter(this, this, R.layout.single_view_city_list);
        this.tvLogout = (CustomTitleTextView) findViewById(R.id.tv_logout);
        if (this.isSigninLater) {
            this.tvLogout.setVisibility(View.INVISIBLE);
        }
        this.firebaseAuth = FirebaseAuth.getInstance();



    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(CityListActivity.this, CityListDetailsActivity.class);
        i.putExtra("stateName", v.getTag().toString());
        startActivity(i);

    }

    private void logOutAction() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setTitle("Confirm"); // Sets title for your alertbox

        alertDialog.setMessage("Do you want to Logout ?"); // Message to be displayed on alertbox

        // alertDialog.setIcon(R.drawable.logout1); // Icon for your alertbox

/* When positive (yes/ok) is clicked */
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
                logout();

//                if (!DashBoardActivity.this.isFinishing()){
//                    logout();
//                }


            }
        });

/* When negative (No/cancel) button is clicked*/
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        //alertDialog.show();

        AlertDialog alert = alertDialog.create();
        alert.show();


        TextView nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
        nbutton.setTextColor(getResources().getColor(R.color.colorSky));
        TextView pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
        pbutton.setTextColor(getResources().getColor(R.color.colorSky));


    }

    private void logout() {
        firebaseAuth.signOut();
        //closing activity
        finish();
        //starting login activity
        startActivity(new Intent(CityListActivity.this, HomeActivity.class));
    }


}
