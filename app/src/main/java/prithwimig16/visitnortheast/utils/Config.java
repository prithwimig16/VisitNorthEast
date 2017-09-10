package prithwimig16.visitnortheast.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by sanniv on 5/2/17.
 */

public class Config {

    public static final int TAB_DASHBOARD = 0;
    //"https://appmaster.clamhub.com/startup/master"; //prod
    public static final int TAB_LEADS = 1;
    public static final int TAB_REPORT = 2;
    public static final int TAB_PROPERTIES = 3;
    public static final int TAB_SETTINGS = 4;
    public static final int[] graphColor = {
            Color.rgb(17, 150, 227), Color.rgb(35, 52, 93), Color.rgb(111, 221, 216),
            Color.rgb(23, 164, 155),
    };
    public static Typeface OpenSans_Regular;
    public static Typeface OpenSans_Light;
    private static Config _instance = null;
    public String STARTUP_API = "http://appdev.clamhub.com/startup/master";//dev
    public String TRANSACTION_API = "";
    public int selectedTab;
    public String TRANSACTION_ACCESS_KEY = "";
    public String CONTROLLER_METHOD = "";
    public String ASSET_BASE_URL = "";
    public String REACHABILITY_URL = "";
    public int MAX_COUNT = 20;
    public boolean debugMode = true;
    public boolean suggestUpdate = false;
    public boolean forceUpdate = false;
    public String UPDATE_MESSAGE = "New Version of ClamHub is available, please update now!";
    public boolean maintenanceMode = false;
    public String MAINTENANCE_MESSAGE = "";
    public String B_AUTH = "";
    public String PLAYSTORE_URL = "";
    public String APP_ID = "";
    public Context applicationContext = null;
    public JSONObject propertyForOptions;
    public JSONObject propertyTypeOptions;
    public JSONArray probablityOptions;
    public JSONArray dealStatusOptions;
    public JSONArray brokerUsersOptions;
    public JSONObject constructionStatusOptions;
    public JSONArray brokerStatusOptions;
    public JSONArray brokersList;
    public JSONArray countryOptions;
    public JSONArray graphColorsArray;
    public boolean allowLandscape;
    public boolean allowNotification;
    public boolean allowNotificationSound;
    public boolean allowNotificationBadge;
    public boolean allowNotificationAlert;
    public HashMap<String, JSONArray> globalOptions;
    public boolean isInternetAvailable;

    public static Config getSharedInstance() {
        if (_instance == null) {
            _instance = new Config();
            _instance.isInternetAvailable = true;
            _instance.brokerStatusOptions = new JSONArray();
            _instance.brokerStatusOptions.put("Active");
            _instance.brokerStatusOptions.put("Inactive");


            _instance.propertyForOptions = new JSONObject();
            _instance.propertyTypeOptions = new JSONObject();
            _instance.probablityOptions = new JSONArray();
            _instance.dealStatusOptions = new JSONArray();
            _instance.brokerUsersOptions = new JSONArray();
            _instance.constructionStatusOptions = new JSONObject();
            //_instance.brokerRoleOptions = new JSONArray();
            _instance.brokersList = new JSONArray();
            _instance.countryOptions = new JSONArray();
            _instance.graphColorsArray = new JSONArray();


            _instance.globalOptions = new HashMap<String, JSONArray>();

            JSONArray brokerStatusOptions = new JSONArray();
            brokerStatusOptions.put("Active");
            brokerStatusOptions.put("Inactive");
            _instance.globalOptions.put("broker_status_options", brokerStatusOptions);


        }
        return _instance;
    }

    public void setMasterData(JSONObject object) {
        if (object != null) {
            this.TRANSACTION_API = object.optString("api");
            this.TRANSACTION_ACCESS_KEY = object.optString("api_key");
            this.CONTROLLER_METHOD = object.optString("main_method");
            this.ASSET_BASE_URL = object.optString("asset_base_url");
            this.MAX_COUNT = object.optInt("page_max_count", 20);
            this.REACHABILITY_URL = object.optString("reachability_url");
            this.B_AUTH = object.optString("b_auth");
            this.UPDATE_MESSAGE = object.optString("update_message");
            this.MAINTENANCE_MESSAGE = object.optString("maintenance_message");
            if (object.optString("suggest_update").equalsIgnoreCase("1"))
                this.suggestUpdate = true;
            if (object.optString("force_update").equalsIgnoreCase("1"))
                this.forceUpdate = true;
            if (object.optString("maintenance_mode").equalsIgnoreCase("1"))
                this.maintenanceMode = true;
            this.PLAYSTORE_URL = object.optString("appstore_url");
            this.APP_ID = object.optString("appstore_id");
        }
    }


}
