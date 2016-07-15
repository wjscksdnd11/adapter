package com.example.tacademy.samplelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class SampleListActivity extends AppCompatActivity {



    EditText editText;
    ListView listView;
    ArrayAdapter<String>  mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list);
        editText = (EditText)findViewById(R.id.edit_list);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_add);
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String text = editText.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            mAdapter.add(text);
            editText.setText("");
            listView.smoothScrollToPosition(mAdapter.getCount() - 1);
        }
    }
});
        initData();
    }


    private void initData(){
        //여기서 리소스 연결
        String [] text = getResources().getStringArray(R.array.items);
        mAdapter.addAll(text);
    }
}
