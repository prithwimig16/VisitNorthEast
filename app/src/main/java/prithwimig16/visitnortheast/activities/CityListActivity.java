package prithwimig16.visitnortheast.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.adapter.CityListAdapter;

public class CityListActivity extends AppCompatActivity implements View.OnClickListener {
    GridView gridView;
    CityListAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        init();
        this.gridView.setAdapter(this.adapter);
    }

    private void init() {
        this.gridView = (GridView) findViewById(R.id.gridview_city_activity);
        this.adapter = new CityListAdapter(this, this, R.layout.single_view_city_list);

    }

    @Override
    public void onClick(View v) {

    }

}
