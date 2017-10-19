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

import prithwimig16.visitnortheast.R;

/**
 * Created by Prithwi on 16/09/17.
 */

public class ShowListAdapter extends ArrayAdapter {
    Context context;
    int layoutResourceId;



    public ShowListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
        this.context = context;
        this.layoutResourceId = resource;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Holder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new Holder();
            holder.txtImgTitle = (TextView) row.findViewById(R.id.tv_img_tag);
            holder.tvCityInfo = (TextView) row.findViewById(R.id.tv_city_info);
            holder.imageItem = (ImageView) row.findViewById(R.id.img_show_list);

            row.setTag(holder);
        } else {
            holder = (Holder) row.getTag();
        }

        return convertView;
    }

    static class Holder {
        TextView txtImgTitle, tvCityInfo;
        ImageView imageItem;
    }
}
