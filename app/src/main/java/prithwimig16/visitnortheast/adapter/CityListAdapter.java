package prithwimig16.visitnortheast.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import prithwimig16.visitnortheast.R;
import prithwimig16.visitnortheast.activities.CityListActivity;

/**
 * Created by Prithwi on 10/09/17.
 */

public class CityListAdapter extends ArrayAdapter {
    Context context;
    int layoutResourceId;
    CityListActivity cityListActivity;
    private String[] placeName = new String[]{"  Assam  ", "  Tripura  ", "  Manipur  ", "  Mizoram  ", "  Sikkim  ", "  Arunachal  ", "  Meghalaya  "};
    private int[] imageArray = new int[]{
            R.drawable.assam, R.drawable.tripura, R.drawable.manipur, R.drawable.mizoram, R.drawable.sikkim, R.drawable.arunachal,
            R.drawable.shillong,

    };


    public CityListAdapter(@NonNull Context context, CityListActivity cityListActivity, @LayoutRes int layoutResourceId) {

        super(context, layoutResourceId);

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.cityListActivity = cityListActivity;
    }

    @Override
    public int getCount() {
        return this.imageArray.length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RecordHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.tv_city_name_city_list);
            holder.imageItem = (ImageView) row.findViewById(R.id.item_image);

            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }

        holder.imageItem.setTag("" + position);

        holder.txtTitle.setText(this.placeName[position]);
        try {
            Picasso.with(context).load(this.imageArray[position]).into(holder.imageItem);
        } catch (Exception e) {
            // holder.propimage.setImageResource(R.drawable.imagenotfound);
            holder.imageItem.setImageResource(R.drawable.noimage);
        }


        return row;
    }

    static class RecordHolder {
        TextView txtTitle;
        ImageView imageItem;
    }

}
