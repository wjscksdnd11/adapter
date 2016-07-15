package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.tacademy.samplelist.widget.ExpandableAdapter;

public class ExpandableListActivity extends AppCompatActivity {

    ExpandableListView listView;
    ExpandableAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        listView = (ExpandableListView)findViewById(R.id.expandableListView);
        mAdapter = new ExpandableAdapter();
        listView.setAdapter(mAdapter);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(ExpandableListActivity.this, "child click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(ExpandableListActivity.this, "group expand", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(ExpandableListActivity.this, "group collapse", Toast.LENGTH_SHORT).show();
                listView.expandGroup(groupPosition);
            }
        });
        initData();

        for (int i = 0; i < mAdapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }
    }

    private void initData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5 ; j++) {
                mAdapter.put("group" + i , "child:"+i+","+j);
            }
        }
    }
}
