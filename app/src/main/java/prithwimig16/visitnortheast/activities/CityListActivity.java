package prithwimig16.visitnortheast.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import org.json.JSONObject;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.adapter.CityListAdapter;

public class CityListActivity extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    CityListAdapter adapter;

    JSONObject fbResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        Intent intent = getIntent();
        String jsondata = intent.getStringExtra("userProfile");

        try {
            fbResponse = new JSONObject(jsondata);
            String user_email = fbResponse.get("email").toString();
            String user_name = fbResponse.get("name").toString();


        } catch (Exception e) {
            e.printStackTrace();
        }
        init();
        this.gridView.setAdapter(this.adapter);
    }

    private void init() {
        this.gridView = (GridView) findViewById(R.id.gridview_city_activity);
        this.adapter = new CityListAdapter(this, this, R.layout.single_view_city_list);


    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(CityListActivity.this, CityListDetailsActivity.class);
        i.putExtra("stateName", v.getTag().toString());
        startActivity(i);

    }


}
