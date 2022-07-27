package sg.edu.rp.c346.id21009632.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class EditDeleteActivity extends AppCompatActivity {
    TextView tvTitle, tvMovieID, tvyear, tvGenre, tvrating, tvID;
    EditText etTitlee, etGenree, etyearr;
    Spinner spinRating;
    Button btnUpdate, btnDelete, btnCancel;
    Movie data;

    //wrfegtrhyjuyiko
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
        etTitlee = findViewById(R.id.etTitlee);
        etGenree = findViewById(R.id.etGenree);
        etyearr = findViewById(R.id.etyearr);
        spinRating = findViewById(R.id.spinRating);

        //initialize the variables with UI here

        Intent i = getIntent();
        data = (Movie) i.getSerializableExtra("data");
        tvID.setText("Movie ID : " + '\n' + data.getId() + "");

        etTitlee.setText(data.getTitle());
        etGenree.setText(data.getGenre());
        etyearr.setText(data.getYear() + "");

        if (data.getRating().equals("G")) {
            int position = 0;
            spinRating.setSelection(position);

        } else if (data.getRating().equals("PG")) {
            int position = 1;
            spinRating.setSelection(position);

        } else if (data.getRating().equals("PG13")) {
            int position = 2;
            spinRating.setSelection(position);

        } else if (data.getRating().equals("NC16")) {
            int position = 3;
            spinRating.setSelection(position);

        } else if (data.getRating().equals("M18")) {
            int position = 4;
            spinRating.setSelection(position);

        } else if (data.getRating().equals("R21")) {
            int position = 5;
            spinRating.setSelection(position);
        }




        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(EditDeleteActivity.this);
                data.setTitle(etTitlee.getText().toString());
                data.setGenre(etGenree.getText().toString());
                data.setYear(Integer.parseInt(etyearr.getText().toString()));
                data.setRating(spinRating.getSelectedItem().toString());

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
                Log.d("Movie id: ", id + "");

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

