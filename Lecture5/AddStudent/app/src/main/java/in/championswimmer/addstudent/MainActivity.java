package in.championswimmer.addstudent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvStudent;
    Button btnAdd;
    ArrayList<Student> studentList = new ArrayList<>();
    StudentAdapter sAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.addBtn);
        rvStudent = (RecyclerView) findViewById(R.id.rvStudentList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivityForResult(i, 121);
            }
        });

        sAdapter = new StudentAdapter();
        rvStudent.setLayoutManager(new LinearLayoutManager(this));
        rvStudent.setAdapter(sAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 121 && resultCode == RESULT_OK) {
            Student newStudent = new Student(
                    data.getStringExtra("name"),
                    Integer.valueOf(data.getStringExtra("age")),
                    data.getStringExtra("course")
            );
            studentList.add(newStudent);
            sAdapter.notifyDataSetChanged();
        }
    }

    class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {

        @Override
        public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = getLayoutInflater().inflate(android.R.layout.two_line_list_item, parent, false);


            return new StudentHolder(itemView);
        }

        @Override
        public void onBindViewHolder(StudentHolder holder, int position) {

            Student stu = studentList.get(position);
            holder.text1.setText(stu.getName() + "  " + stu.getAge());
            holder.text2.setText(stu.getCourse());

        }

        @Override
        public int getItemCount() {
            return studentList.size();
        }

        class StudentHolder extends RecyclerView.ViewHolder {

            TextView text1, text2;

            public StudentHolder(View itemView) {
                super(itemView);
                text1 = (TextView) itemView.findViewById(android.R.id.text1);
                text2 = (TextView) itemView.findViewById(android.R.id.text2);
            }
        }
    }
}
