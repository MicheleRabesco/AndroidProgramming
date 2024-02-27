package it.unisa.gennaio24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private byte valoreByte;
    private boolean modalitaSinistra = true;
    private TextView displayDecimale;
    private TextView[] tvBinarie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inizializza i componenti dell'interfaccia utente
        displayDecimale = findViewById(R.id.displayDecimale);
        tvBinarie = new TextView[8];
        for (int i = 0; i < 8; i++) {
            int resID = getResources().getIdentifier("bit" + i, "id", getPackageName());
            tvBinarie[i] = findViewById(resID);
        }

        generateRandomByte();


        // imposta il listener per il pulsante shuffle a coppie
        Button buttonShuffleCoppie = findViewById(R.id.buttonShuffleCoppie);
        buttonShuffleCoppie.setOnClickListener(v -> shuffleCoppie());

        // imposta il listener per il pulsante Shuffle a Quattro Bit
        Button buttonShuffleQuattro = findViewById(R.id.buttonShuffleQuattro);
        buttonShuffleQuattro.setOnClickListener(v -> shuffleQuattro());
    }

    // genera un byte casuale e aggiorna l'interfaccia
    private void generateRandomByte() {
        Random random = new Random();
        valoreByte = (byte) random.nextInt(256);
        updateDisplayBinario();
    }

    // aggiorna il display binario e decimale con il valore attuale del byte
    private void updateDisplayBinario() {
        for (int i = 0; i < 8; i++) {
            int bitValue = (valoreByte >> (7 - i)) & 1;
            tvBinarie[i].setText(String.valueOf(bitValue));
            tvBinarie[i].setTag(i);
            final int bitIndex = i;
            tvBinarie[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    shiftCircolare(bitIndex);
                }
            });
        }
        // aggiorna il display decimale
        displayDecimale.setText("Decimale: " + valoreByte);
    }

    // effettua lo shift circolare a sinistra o a destra a seconda della modalità selezionata
    private void shiftCircolare(int bitIndice) {
        if (modalitaSinistra) {
            valoreByte = (byte) ((valoreByte << 1) | ((valoreByte & (1 << (7 - bitIndice))) >> (7 - bitIndice)));
        } else {
            valoreByte = (byte) ((valoreByte >>> 1) | ((valoreByte & (1 << bitIndice)) << (7 - bitIndice)));
        }
        updateDisplayBinario();
    }

    // effettua lo shuffle a coppie di bit
    private void shuffleCoppie() {
        int nuovoValore = 0;
        for (int i = 0; i < 8; i += 2) {
            int bitCorrente = (valoreByte >> i) & 1;
            int bitSuccessivo = (valoreByte >> (i + 1)) & 1;
            nuovoValore |= (bitSuccessivo << i);
            nuovoValore |= (bitCorrente << (i + 1));
        }
        valoreByte = (byte) nuovoValore;
        updateDisplayBinario();
    }


    // effettua lo shuffle a quattro bit
    private void shuffleQuattro() {
        byte nuovoValore = 0;
        for (int i = 0; i < 4; i++) {
            byte bitCorrente = (byte) ((valoreByte >> i) & 1);
            byte bitCorrispondente = (byte) ((valoreByte >> (i + 4)) & 1);
            nuovoValore |= (bitCorrispondente << i);
            nuovoValore |= (bitCorrente << (i + 4));
        }
        valoreByte = nuovoValore;
        updateDisplayBinario();
    }

    // imposta la modalità di shift (sinistra o destra)
    public void onModalitaShiftClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.modalitaSinistra:
                if (checked)
                    modalitaSinistra = true;
                break;
            case R.id.modalitaDestra:
                if (checked)
                    modalitaSinistra = false;
                break;
        }
    }
}
