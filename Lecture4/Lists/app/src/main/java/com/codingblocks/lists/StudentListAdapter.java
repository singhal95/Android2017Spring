package com.codingblocks.lists;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 18/12/16.
 */

public class StudentListAdapter extends BaseAdapter {

    public static final String TAG = "SLA";

    private Context context;
    private ArrayList<Student> studentList;

    public StudentListAdapter(Context c, ArrayList<Student> studentList) {
        this.context = c;
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Student getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {

        String course = getItem(position).getCourse();

        if (course.equals("Pandora") ||
                course.equals("Elixir")) {
            return 1;
        }

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        long startTime = System.currentTimeMillis();
        Log.d(TAG, "getView: " + position + " " + convertView);

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        StudentViewHolder svHolder;

        if (convertView == null) {
            convertView = li.inflate(
                    getItemViewType(position) == 0 ? R.layout.list_item_student : R.layout.list_item_student_advanced,
                    null);

            svHolder = new StudentViewHolder();
            svHolder.tvAge = (TextView) convertView.findViewById(R.id.tvAge);
            svHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
            svHolder.tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
            convertView.setTag(svHolder);
        } else {
            svHolder = (StudentViewHolder) convertView.getTag();
        }

        Student thisStudent = getItem(position);

        svHolder.tvName.setText(thisStudent.getName());
        svHolder.tvCourse.setText(thisStudent.getCourse());
        svHolder.tvAge.setText(String.valueOf(thisStudent.getAge()));

        long timeTaken = System.currentTimeMillis() - startTime;
        Log.d(TAG, "getView: time taken to create view " + position + " = " + timeTaken);
        return convertView;
    }

    static class StudentViewHolder {
        TextView tvAge, tvName, tvCourse;
    }
}
