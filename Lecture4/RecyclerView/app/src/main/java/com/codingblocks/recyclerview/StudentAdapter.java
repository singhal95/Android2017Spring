package com.codingblocks.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by championswimmer on 18/12/16.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

    private ArrayList<Student> studentList;
    private Context context;

    public StudentAdapter(ArrayList<Student> studentList, Context context) {
        this.studentList = studentList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {

        String course = studentList.get(position).getCourse();

        if (course.equals("Pandora") || course.equals("Elixir")) {
            return 1;
        }

        return 0;
    }





    @Override
    public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(
                viewType == 1 ? R.layout.list_item_student_advanced : R.layout.list_item_student_basic,
                parent, false);


        return new StudentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentHolder holder, int position) {
        Student thisStudent = studentList.get(position);

        holder.tvName.setText(thisStudent.getName());
        holder.tvCourse.setText(thisStudent.getCourse());
        holder.tvAge.setText(String.valueOf(thisStudent.getAge()));

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    static class StudentHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge, tvCourse;

        public StudentHolder(View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);

        }
    }
}