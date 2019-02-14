package com.example.zadatakjelov1masterfinal.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zadatakjelov1masterfinal.R;
import com.example.zadatakjelov1masterfinal.model.NavigationItem;

import java.util.ArrayList;

public class DrawerAdapter extends BaseAdapter {

    Context context;
    ArrayList<NavigationItem> navigationItems;

    public DrawerAdapter(Context context, ArrayList<NavigationItem> navigationItems) {
        this.context = context;
        this.navigationItems = navigationItems;
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navigationItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.drawer_item,null);

        }

        TextView tvTitle =  convertView.findViewById(R.id.title);
        TextView tvSubtitle =  convertView.findViewById(R.id.subtitle);
        ImageView ivIcon =  convertView.findViewById(R.id.icon);

        tvTitle.setText(navigationItems.get(position).getTitle());
        tvSubtitle.setText(navigationItems.get(position).getSubTitle());
        ivIcon.setImageResource(navigationItems.get(position).getIcon());

        return convertView;

    }
}
