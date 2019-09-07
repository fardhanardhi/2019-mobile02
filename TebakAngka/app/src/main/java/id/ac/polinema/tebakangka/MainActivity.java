package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //  TODO: deklarasikan variabel di sini
    private EditText angkaInput;
    private Button tombolTebak;

    private int angkaTebakan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: bind layout di sini
        angkaInput = findViewById(R.id.number_input);
        tombolTebak = findViewById(R.id.guess_button);

        initRandomNumber();
    }

    // TODO: generate angka random di sini
    private void initRandomNumber() {
        Random rand = new Random();
        angkaTebakan = rand.nextInt(100);
        angkaTebakan += 1;
    }

    public void handleGuess(View view) {
        // TODO: Tambahkan logika untuk melakukan pengecekan angka
        String stringAngkaIsian = angkaInput.getText().toString();

        if (!stringAngkaIsian.isEmpty()) {
            int angkaIsian = Integer.parseInt(stringAngkaIsian);
            if (angkaIsian != angkaTebakan) {
                if (angkaIsian > angkaTebakan) {
                    Toast.makeText(this, "Tebakan anda terlalu besar!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Tebakan anda terlalu kecil!", Toast.LENGTH_SHORT).show();
                }
                angkaInput.setText("");
            } else {
                Toast.makeText(this, "Tebakan anda benar!", Toast.LENGTH_LONG).show();
                tombolTebak.setEnabled(false);
            }
        }
    }


    public void handleReset(View view) {
        // TODO: Reset tampilan
        tombolTebak.setEnabled(true);
        initRandomNumber();
        angkaInput.setText("");
        Toast.makeText(this, "Reset!", Toast.LENGTH_SHORT).show();
    }
}
