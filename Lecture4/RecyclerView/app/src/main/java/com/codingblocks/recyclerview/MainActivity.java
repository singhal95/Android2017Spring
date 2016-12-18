package com.codingblocks.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("A", "Pandora", 18));
        students.add(new Student("B", "Pandora", 18));
        students.add(new Student("C", "Pandora", 18));
        students.add(new Student("D", "Pandora", 18));
        students.add(new Student("E", "Pandora", 18));
        students.add(new Student("F", "Pandora", 18));
        students.add(new Student("G", "Pandora", 18));
        students.add(new Student("H", "Pandora", 18));
        students.add(new Student("I", "Pandora", 18));
        students.add(new Student("A", "Elixir", 18));
        students.add(new Student("B", "Elixir", 18));
        students.add(new Student("C", "Elixir", 18));
        students.add(new Student("D", "Elixir", 18));
        students.add(new Student("E", "Elixir", 18));
        students.add(new Student("F", "Elixir", 18));
        students.add(new Student("G", "Elixir", 18));
        students.add(new Student("H", "Elixir", 18));
        students.add(new Student("I", "Elixir", 18));
        students.add(new Student("A", "Launchpad", 18));
        students.add(new Student("B", "Launchpad", 18));
        students.add(new Student("C", "Launchpad", 18));
        students.add(new Student("D", "Launchpad", 18));
        students.add(new Student("E", "Launchpad", 18));
        students.add(new Student("F", "Launchpad", 18));
        students.add(new Student("G", "Launchpad", 18));
        students.add(new Student("H", "Launchpad", 18));
        students.add(new Student("I", "Launchpad", 18));
        students.add(new Student("A", "Crux", 18));
        students.add(new Student("B", "Crux", 18));
        students.add(new Student("C", "Crux", 18));
        students.add(new Student("D", "Crux", 18));
        students.add(new Student("E", "Crux", 18));
        students.add(new Student("F", "Crux", 18));
        students.add(new Student("G", "Crux", 18));
        students.add(new Student("H", "Crux", 18));
        students.add(new Student("I", "Crux", 18));
        students.add(new Student("A", "Pandora", 18));
        students.add(new Student("B", "Pandora", 18));
        students.add(new Student("C", "Pandora", 18));
        students.add(new Student("D", "Pandora", 18));
        students.add(new Student("E", "Pandora", 18));
        students.add(new Student("F", "Pandora", 18));
        students.add(new Student("G", "Pandora", 18));
        students.add(new Student("H", "Pandora", 18));
        students.add(new Student("I", "Pandora", 18));
        students.add(new Student("A", "Elixir", 18));
        students.add(new Student("B", "Elixir", 18));
        students.add(new Student("C", "Elixir", 18));
        students.add(new Student("D", "Elixir", 18));
        students.add(new Student("E", "Elixir", 18));
        students.add(new Student("F", "Elixir", 18));
        students.add(new Student("G", "Elixir", 18));
        students.add(new Student("H", "Elixir", 18));
        students.add(new Student("I", "Elixir", 18));
        students.add(new Student("A", "Launchpad", 18));
        students.add(new Student("B", "Launchpad", 18));
        students.add(new Student("C", "Launchpad", 18));
        students.add(new Student("D", "Launchpad", 18));
        students.add(new Student("E", "Launchpad", 18));
        students.add(new Student("F", "Launchpad", 18));
        students.add(new Student("G", "Launchpad", 18));
        students.add(new Student("H", "Launchpad", 18));
        students.add(new Student("I", "Launchpad", 18));
        students.add(new Student("A", "Crux", 18));
        students.add(new Student("B", "Crux", 18));
        students.add(new Student("C", "Crux", 18));
        students.add(new Student("D", "Crux", 18));
        students.add(new Student("E", "Crux", 18));
        students.add(new Student("F", "Crux", 18));
        students.add(new Student("G", "Crux", 18));
        students.add(new Student("H", "Crux", 18));
        students.add(new Student("I", "Crux", 18));

        RecyclerView studentListView = (RecyclerView) findViewById(R.id.rvStudentList);
        StudentAdapter studentAdapter = new StudentAdapter(students, this);

        studentListView.setLayoutManager(new LinearLayoutManager(this));

        studentListView.setAdapter(studentAdapter);
    }
}
