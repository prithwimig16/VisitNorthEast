package prithwimig16.visitnortheast.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import prithwimig16.visitnortheast.R;

public class CityListDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView backButton;
    String stateName;
    TextView stateNameTag, downLoadTag;
    RelativeLayout rlBackgroundImage, rlOneToSeven, rlThingsToDo, rlSights, rlMaps, rlMyPlan, rlTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_list_details);
        Bundle extras = getIntent().getExtras();
        init();

        if (extras != null) {
            this.stateName = extras.getString("stateName");
            if (this.stateName.matches("0")) {
                this.stateName = "Assam";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.assam);
            } else if (this.stateName.matches("1")) {
                this.stateName = "Meghalaya";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.meghalaya);
            } else if (this.stateName.matches("2")) {
                this.stateName = "Arunachal";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.arunachal);
            } else if (this.stateName.matches("3")) {
                this.stateName = "Sikkim";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.sikkim);
            } else if (this.stateName.matches("4")) {
                this.stateName = "Tripura";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.tripura);
            } else if (this.stateName.matches("5")) {
                this.stateName = "Mizoram";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.mizoram);
            } else if (this.stateName.matches("6")) {
                this.stateName = "Manipur";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.manipur);
            } else if (this.stateName.matches("7")) {
                this.stateName = "Nagaland";
                this.rlBackgroundImage.setBackgroundResource(R.drawable.nagaland);
            }
        }


        updateUi();
    }

    private void init() {
        this.backButton = (ImageView) findViewById(R.id.img_back);
        this.backButton.setOnClickListener(this);
        this.stateNameTag = (TextView) findViewById(R.id.tv_city_list_details_tag);
        this.rlBackgroundImage = (RelativeLayout) findViewById(R.id.rel_image_background);
        this.downLoadTag = (TextView) findViewById(R.id.tv_download_tag);

        this.rlOneToSeven = (RelativeLayout) findViewById(R.id.rl_one_to_saven_days);
        this.rlOneToSeven.setOnClickListener(this);

        this.rlThingsToDo = (RelativeLayout) findViewById(R.id.rl_things_to_do);
        this.rlThingsToDo.setOnClickListener(this);

        this.rlSights = (RelativeLayout) findViewById(R.id.rl_sights);
        this.rlSights.setOnClickListener(this);

        this.rlMaps = (RelativeLayout) findViewById(R.id.rl_maps);
        this.rlMaps.setOnClickListener(this);

        this.rlMyPlan = (RelativeLayout) findViewById(R.id.rl_my_plan);
        this.rlMyPlan.setOnClickListener(this);

        this.rlTips = (RelativeLayout) findViewById(R.id.rl_tips);
        this.rlTips.setOnClickListener(this);

    }

    private void updateUi() {
        this.stateNameTag.setText(this.stateName + " " + "Travel Guide");
        this.downLoadTag.setText("Download" + " " + this.stateName + " " + "maps and information for offline use.");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;

            case R.id.rl_one_to_saven_days:
                finish();
                break;

            case R.id.rl_things_to_do:
                finish();
                break;

            case R.id.rl_sights:
                finish();
                break;

            case R.id.rl_maps:
                finish();
                break;

            case R.id.rl_my_plan:
                finish();
                break;

            case R.id.rl_tips:
                finish();
                break;
        }
    }
}
