package com.asi.addtags;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import taggroup.TagGroup;

public class MainActivity extends AppCompatActivity {

    private TagGroup mTagGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTagGroup = (TagGroup) findViewById(R.id.tag_group);


    }

    public void getData(View view) {
        ArrayList<String> tgs = null;
        String[] Tags = mTagGroup.getTags();
        for (String tags: Tags) {
            tgs=new ArrayList<>();
            tgs.add(tags);
           Toast.makeText(MainActivity.this,tags,Toast.LENGTH_SHORT).show();

        }



    }
}
