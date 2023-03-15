package it.unisa.rubrica;

import android.content.Context;
import android.location.GnssAntennaInfo;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contatto> {


    private LayoutInflater inflater;
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contatto> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View v, @NonNull ViewGroup parent) {

        if (v == null) {
            Log.d("DEBUG","Inflating view");
            v = inflater.inflate(R.layout.custom_list_view, null);
        }

        Contatto c = getItem(position);

        Log.d("DEBUG", "contact c = "+c);

        Button nameButton;
        Button surnameButton;
        Button phoneButton;
        ImageButton imageButton;

        nameButton = v.findViewById(R.id.onClickName);
        surnameButton = v.findViewById(R.id.onClickSurname);
        phoneButton = v.findViewById(R.id.onClickPhone);
        imageButton = v.findViewById(R.id.onClickImg);

        nameButton.setText(c.getName());
        surnameButton.setText(c.getSurname());
        phoneButton.setText(c.getPhone());
        imageButton.setImageDrawable(c.getPicture());

        nameButton.setTag(position);
        surnameButton.setTag(position);
        phoneButton.setTag(position);
        imageButton.setTag(position);


        return v;
    }
}
