package com.codingblocks.layouts;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public static final String[] students = new String[] {
            "Money",
            "Karan",
            "Mayank",
            "Rahul",
            "Saransh",
            "Piyush",
            "Manika",
            "Pavana",
            "Aishwarya",
            "Gurtej",
            "Deheem"
    };

    ListView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = (ListView) findViewById(R.id.studentList);

        ArrayAdapter<String> studentListAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                students
        );
        studentList.setAdapter(studentListAdapter);

    }
}
