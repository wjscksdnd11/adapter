package com.example.tacademy.samplelist.widget;

import android.database.DataSetObserver;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.example.tacademy.samplelist.data.ChildItem;
import com.example.tacademy.samplelist.data.GroupItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tacademy on 2016-07-15.
 */
public class ExpandableAdapter implements ExpandableListAdapter {

    List<GroupItem> items = new ArrayList<>();

    public void put(String groupName, String childName) {
        GroupItem group = null;
        for(GroupItem g : items) {
            if (g.groupName.equals(groupName)) {
                group = g;
                break;
            }
        }
        if (group == null) {
            group = new GroupItem();
            group.groupName = groupName;
            items.add(group);
        }

        if (!TextUtils.isEmpty(childName)) {
            ChildItem child = new ChildItem();
            child.chileName = childName;
            group.childItems.add(child);
        }
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {

        return items.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(groupPosition).childItems.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return items.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(groupPosition).childItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView view;
        if(convertView==null){
            view= (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);;
            view.setBackgroundColor(Color.GREEN);
        }else{
            view=(TextView)convertView;
        }
        view.setText(items.get(groupPosition).groupName);
          return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView view;
                if (convertView == null) {
                        view = (TextView)LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                        view.setBackgroundColor(Color.YELLOW);
                    } else {
                        view = (TextView)convertView;
                    }

                        if (isLastChild) {
                        view.setBackgroundColor(Color.LTGRAY);
                    } else {
                        view.setBackgroundColor(Color.YELLOW);
                    }
                view.setText(items.get(groupPosition).childItems.get(childPosition).chileName);
               return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
