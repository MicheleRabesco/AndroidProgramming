package it.unisa.rubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    CustomAdapter customAdapter;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        v.findViewById(R.id.fullContact).setOnClickListener((View.OnClickListener) this);


        String[] nomi = {"Pasquale","Alfonso","Michele","Giuseppe", "Luca", "Fabio", "Cristina", "Andrea", "Alessandro", "Anna"};

        String[] cognomi = {"Ruocco", "Pepe", "Rabesco", "Nuschese", "Eufrate", "Cappotto", "Accardi", "Aceto", "Falcone", "Ventura"};

        listView = (ListView) findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.custom_list_view, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);

        for (int i=0; i<nomi.length; i++) {
            Contatto c = new Contatto(
                    nomi[i], cognomi[i],
                    "111-2222-333",getResources().getDrawable(R.drawable.ic_launcher_foreground));
            customAdapter.add(c);
        }

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String  str  = listView.getItemAtPosition(position).toString();
            // Show Toast
            Toast.makeText(getApplicationContext(),
                            "Click su posizione n."+position+": " +str, Toast.LENGTH_LONG)
                    .show();
        });
    }

    public void onPhotoClick(View v) {
        Log.d("DEBUG","Picture has been clicked: position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                        "Click su Foto - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
                .show();
    }

    public void onNameClick(View v) {
        Log.d("DEBUG","Name has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                        "Click su Nome - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
                .show();
    }

    public void onSurnameClick(View v) {
        Log.d("DEBUG","Surname has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                        "Click su Cognome - posizione n."+position+": " +c.getSurname(), Toast.LENGTH_LONG)
                .show();
    }

    public void onPhoneClick(View v) {
        Log.d("DEBUG","Tel has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                        "Click su Tel - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG).show();	}
}