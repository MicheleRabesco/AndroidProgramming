package it.unisa.calcolatrice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    RelativeLayout sfondo;
    Random rand = new Random();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        findViewById(R.id.sium).setOnClickListener(this);
        sfondo = findViewById(R.id.sfondo);
    }

    @Override
    public void onClick(View v) {

        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        sfondo.setBackgroundColor(Color.rgb(r,g,b));
    }
}
