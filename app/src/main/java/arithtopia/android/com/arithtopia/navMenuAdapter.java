package arithtopia.android.com.arithtopia;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hossein on 02/09/2017.
 */

public class navMenuAdapter extends ArrayAdapter {

    public int resourceId;
    public Activity context;
    public ArrayList<navMenuListItem> object;

    public navMenuAdapter(@NonNull Activity context, @LayoutRes int resource, @NonNull ArrayList objects) {
        super(context, resource, objects);
        this.resourceId = resource;
        this.context = context;
        this.object = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        view = this.context.getLayoutInflater().inflate(this.resourceId , null);

        ImageView imgMenuList = view.findViewById(arithtopia.android.com.arithtopia.R.id.imgMenuList);
        TextView txtMenuList = view.findViewById(arithtopia.android.com.arithtopia.R.id.txtMenulist);

        navMenuListItem buyMenuListItem = object.get(position);
        txtMenuList.setText(buyMenuListItem.title);
        imgMenuList.setImageResource(buyMenuListItem.img);

        return view;

    }

}
