package in.championswimmer.listview2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> studentList;
    ListView lvStudentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentList = new ArrayList<>();
        studentList.add(new Student("A", 18, "Pandora"));
        studentList.add(new Student("B", 19, "Elixir"));
        studentList.add(new Student("C", 18, "Pandora"));
        studentList.add(new Student("D", 20, "Pandora"));
        studentList.add(new Student("E", 18, "Elixir"));
        studentList.add(new Student("F", 19, "Pandora"));
        studentList.add(new Student("G", 18, "Elixir"));
        studentList.add(new Student("H", 19, "Pandora"));
        studentList.add(new Student("I", 20, "Pandora"));
        studentList.add(new Student("J", 20, "Elixir"));
        studentList.add(new Student("K", 18, "Pandora"));
        studentList.add(new Student("L", 18, "Elixir"));

        lvStudentList = (ListView) findViewById(R.id.lvStudentList);

        StudentListAdapter slAdapter = new StudentListAdapter();
        lvStudentList.setAdapter(slAdapter);


    }


    class StudentListAdapter extends BaseAdapter {

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
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater li = getLayoutInflater();

            View itemView = li.inflate(R.layout.list_item_student, null);
            Student student = getItem(position);


            ((TextView)itemView.findViewById(R.id.tvName)).setText(student.getName());
            ((TextView)itemView.findViewById(R.id.tvAge)).setText(student.getAge().toString());
            ((TextView)itemView.findViewById(R.id.tvCourse)).setText(student.getCourse());

            return itemView;
        }
    }
}
