package biz.golek.whattodofordinner.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import biz.golek.whattodofordinner.R;
import biz.golek.whattodofordinner.business.contract.response_data.DinnerListItem;

/**
 * Created by bg on 08.02.16.
 */
public class DinnerListItemArrayAdapter extends ArrayAdapter<DinnerListItem> {
    public DinnerListItemArrayAdapter(Context context, List<DinnerListItem> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DinnerListItem dinner = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.dinner_listview_item, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.dinner_name);
        // Populate the data into the template view using the data object
        tvName.setText(dinner.name);

        // Return the completed view to render on screen
        return convertView;
    }


}
