package prithwimig16.visitnortheast.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.adapter.CityListAdapter;

public class ShowListActivity extends AppCompatActivity {

    CityListAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_list);
        Bundle extras = getIntent().getExtras();
        init();
        if (extras != null) {

        }
        this.listView.setAdapter(this.adapter);
    }

    private void init() {
        this.adapter = new CityListAdapter(this, R.layout.single_list_item);
        this.listView = (ListView) findViewById(R.id.list_view_show_list_activity);
        this.listView.setEmptyView(findViewById(R.id.empty_list));


    }
}
