package prithwimig16.visitnortheast.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by Prithwi on 16/09/17.
 */

public class ShowListAdapter extends ArrayAdapter {


    public ShowListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
