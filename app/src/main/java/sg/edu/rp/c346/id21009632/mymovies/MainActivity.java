package sg.edu.rp.c346.id21009632.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etYear, etGenre;
    Button btnShow, btnInsert;
    Spinner spinRating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShow);
        spinRating = findViewById(R.id.spinRating);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String movieTitle = etTitle.getText().toString();
                String genre = etGenre.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                String rating = spinRating.getSelectedItem().toString();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long inserted_id = dbh.insertMovie(movieTitle, genre, year, rating);

                if (inserted_id != -1) {
                    Toast.makeText(MainActivity.this, "Added " + movieTitle + " to the movie list successfully!", Toast.LENGTH_LONG).show();

                    etTitle.setText("");
                    etGenre.setText("");
                    etYear.setText("");
                }
            }
        });
    }
}