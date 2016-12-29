package in.championswimmer.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class RVActivity extends AppCompatActivity {

    RecyclerView rvStudentList;
    ArrayList<Student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);

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


        rvStudentList = (RecyclerView) findViewById(R.id.rvStudentList);
        StudentAdapter stuAdapter = new StudentAdapter();

        rvStudentList.setLayoutManager(new LinearLayoutManager(this));

        rvStudentList.setAdapter(stuAdapter);

    }

    class StudentHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvAge, tvCourse;
        Button btnBirthday;

        public StudentHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvAge = (TextView) itemView.findViewById(R.id.tvAge);
            this.tvCourse = (TextView) itemView.findViewById(R.id.tvCourse);
            this.btnBirthday = (Button) itemView.findViewById(R.id.btnAgeIncrement);
        }
    }

    class StudentAdapter extends RecyclerView.Adapter<StudentHolder> {

        @Override
        public int getItemViewType(int position) {

            if (studentList.get(position).getCourse().equals("Pandora")) {
                return 1;
            }

            return 0;
        }


        @Override
        public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = getLayoutInflater();
            View itemView;

            switch (viewType) {
                case 1:
                    itemView = li.inflate(R.layout.list_item_student_pandora, parent, false);
                    break;
                default:
                    itemView = li.inflate(R.layout.list_item_student_elixir, parent, false);
                    break;
            }

            return new StudentHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final StudentHolder holder, int position) {

            final Student student = studentList.get(position);

            holder.tvName.setText(student.getName());
            holder.tvAge.setText(student.getAge().toString());
            holder.tvCourse.setText(student.getCourse());
            holder.btnBirthday.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.tvAge.setText(student.incrementAge().toString());
                }
            });
        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }
    }
}
