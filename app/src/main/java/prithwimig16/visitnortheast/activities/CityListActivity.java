package prithwimig16.visitnortheast.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import prithwimig16.visitnortheast.R;

public class CityListActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list);
        init();
    }

    private void init() {
        this.gridView = (GridView) findViewById(R.id.gridview_city_activity);

    }


}
