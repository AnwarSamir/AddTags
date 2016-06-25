package com.asi.addtags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import taggroup.TagGroup;

public class MainActivity extends AppCompatActivity {

    private TagGroup mTagGroup;
    TextView data;
    String json=null;
    StringBuilder stringBuilder = null;
    private TagGroup mTagGroupp;
    private TagGroup.OnTagClickListener mTagClickListener = new TagGroup.OnTagClickListener() {
        @Override
        public void onTagClick(String tag) {
            Toast.makeText(MainActivity.this, tag, Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTagGroup = (TagGroup) findViewById(R.id.tag_group);
        mTagGroupp = (TagGroup) findViewById(R.id.tag_groupp);
        data= (TextView) findViewById(R.id.textView);

        mTagGroupp.setOnTagClickListener(mTagClickListener);
    }

    public void getData(View view) {
        ArrayList<String> tgs =new ArrayList<>();
        String[] Tags = mTagGroup.getTags();
        for (String tags: Tags) {

            tgs.add(tags);
           json = new Gson().toJson(tgs);

        }
        data.setText(json.toString());


    }

    public void Settags(View view) throws JSONException {
        Type token = new TypeToken<List<String>>(){}.getType();
        List<String> r=new ArrayList<>();
        r=new Gson().fromJson(data.getText().toString(),token);
        for(int i =0; i<r.size();i++)
        {

            r.get(i);
        }
        data.setText(r.toString());
        mTagGroupp.setTags(r);
    }
}
