package in.championswimmer.listview2;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainAct";

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

    static class StudentViewHolder {
        TextView tvName, tvAge, tvCourse;
    }



    class StudentListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return studentList.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (getItem(position).getCourse().equals("Pandora")) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public int getViewTypeCount() {
            return 2;
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
//            Log.d(TAG, "getView: " + position);
//            Log.d(TAG, "getView: " + convertView);

            long startTime = System.currentTimeMillis();

            LayoutInflater li = getLayoutInflater();
            Student student = getItem(position);
            StudentViewHolder svHolder;

            if (convertView == null) {

                switch (getItemViewType(position)) {
                    case 0:
                        convertView = li.inflate(R.layout.list_item_student_pandora, null);
                        break;
                    case 1:default:
                        convertView = li.inflate(R.layout.list_item_student_elixir, null);
                        break;
                }


                svHolder = new StudentViewHolder();
                svHolder.tvName = (TextView) convertView.findViewById(R.id.tvName);
                svHolder.tvAge = (TextView) convertView.findViewById(R.id.tvAge);
                svHolder.tvCourse = (TextView) convertView.findViewById(R.id.tvCourse);
                convertView.setTag(svHolder);
            } else {
                svHolder = (StudentViewHolder) convertView.getTag();
            }




            svHolder.tvName.setText(student.getName());
            svHolder.tvAge.setText(student.getAge().toString());
            svHolder.tvCourse.setText(student.getCourse());

            Log.d(TAG, "getView: " + position + " time taken = " + (System.currentTimeMillis() - startTime) + "ms");

            return convertView;
        }
    }
}
