package it.unisa.calculatorwithfragments;

import static android.widget.Toast.LENGTH_LONG;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BgChanger extends Fragment implements View.OnClickListener {

    private TextView text;
    RelativeLayout extLayout;
    Random rand = new Random();
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_bg_changer, container, false);


        v.findViewById(R.id.sfondoTesto).setOnClickListener(this);
        v.findViewById(R.id.sfondoApp).setOnClickListener(this);
        text = v.findViewById(R.id.text);
        extLayout = v.findViewById(R.id.extLayout);

        return v;
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
        String msg = "Cambiando colore..";
        Toast toast = Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG);
        toast.show();
    }

}