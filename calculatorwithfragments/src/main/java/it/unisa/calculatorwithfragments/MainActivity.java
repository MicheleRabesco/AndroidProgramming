package it.unisa.calculatorwithfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calculatorBtn, bgChangerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculatorBtn = findViewById(R.id.frag1btn);
        bgChangerBtn = findViewById(R.id.frag2btn);

        calculatorBtn.setOnClickListener(v -> replaceFragment(new Calculator()));

        bgChangerBtn.setOnClickListener(v -> replaceFragment(new BgChanger()));

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.commit();
    }
}