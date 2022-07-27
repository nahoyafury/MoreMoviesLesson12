package sg.edu.rp.c346.id21009632.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class EditDeleteActivity extends AppCompatActivity {
    TextView tvTitle, tvMovieID, tvyear, tvGenre, tvrating, tvID;
    EditText etTitle, etGenre, etyear;
    Spinner spinRating;
    Button btnUpdate, btnDelete, btnCancel;
    Movie data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        tvID = findViewById(R.id.tvID);
        tvMovieID = findViewById(R.id.tvMovieID);
        tvrating = findViewById(R.id.tvrating);
        tvTitle = findViewById(R.id.tvTitle);
        tvyear = findViewById(R.id.tvyear);
        tvGenre = findViewById(R.id.tvGenre);
        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etyear = findViewById(R.id.etyear);
        spinRating = findViewById(R.id.spinRating);

        //initialize the variables with UI here

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");
        tvID.setText("Song ID : " + data.getId() + "");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditDeleteActivity.this);
                data.setTitle(etTitle.getText().toString());
                data.setGenre(etGenre.getText().toString());
                data.setYear(Integer.parseInt(etyear.getText().toString()));
//                data.setRating(spinRating.getText().toString());

                dbh.updateMovie(data);
                dbh.close();
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditDeleteActivity.this);
                int id = data.getId();
                Log.d("song id: ", id + "");

                dbh.deleteMovie(data.getId());
                finish();

            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

