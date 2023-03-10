package it.unisa.calcolatrice;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class BackgroundChangerMain extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    RelativeLayout extLayout;
    Random rand = new Random();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_changer);

        findViewById(R.id.sfondoTesto).setOnClickListener(this);
        findViewById(R.id.sfondoApp).setOnClickListener(this);
        text = findViewById(R.id.text);
        extLayout = findViewById(R.id.extLayout);
    }

    @Override
    public void onClick(View v) {
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        switch (v.getId()){
            case R.id.sfondoApp:
                extLayout.setBackgroundColor(Color.rgb(r,g,b));
                toastMsg();
                break;
            case R.id.sfondoTesto:
                text.setBackgroundColor(Color.rgb(r,g,b));
                toastMsg();
                break;

        }
    }

    public void toastMsg() {
        Toast toast = Toast.makeText(this, "Cambiando colore..", Toast.LENGTH_LONG);
        toast.show();
    }



}
