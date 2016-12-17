package com.codingblocks.layouts;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "LV";

    ListView studentListView;
    ArrayList<Student> studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentList = new ArrayList<>();
        studentList.add(new Student("Ram", 15, "Pandora"));
        studentList.add(new Student("Shyam", 16, "Elixir"));
        studentList.add(new Student("Rahul", 14, "Pandora"));
        studentList.add(new Student("Madhav", 15, "Crux"));
        studentList.add(new Student("Kumar", 17, "Pandora"));
        studentList.add(new Student("Arun", 18, "Launchpad"));
        studentList.add(new Student("Ram", 17, "Pandora"));

        studentListView = (ListView) findViewById(R.id.studentList);
        StudentListAdapter slAdapter = new StudentListAdapter();
        studentListView.setAdapter(slAdapter);

    }

    class StudentListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return studentList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();
            View itemView = li.inflate(R.layout.list_item_student, null);

            Log.d(TAG, "getView: ");

            ((TextView) itemView.findViewById(R.id.tvName))
                    .setText(studentList.get(position).getName());
            ((TextView) itemView.findViewById(R.id.tvAge))
                    .setText(String.valueOf(studentList.get(position).getAge()));
            ((TextView) itemView.findViewById(R.id.tvCourse))
                    .setText(studentList.get(position).getCourse());

            return itemView;
        }
    }
}
