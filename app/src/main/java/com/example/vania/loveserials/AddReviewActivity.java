package com.example.vania.loveserials;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.fragments.MainFragment;
import com.example.vania.loveserials.models.MainUser;
import com.example.vania.loveserials.models.Review;
import com.example.vania.loveserials.models.Serial;

import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddReviewActivity extends AppCompatActivity {
    private ArrayList<String> listSerialName = new ArrayList<>();
    private Spinner spinner;
    private RatingBar ratingSerial;
    Serial serialReview;
    float serialRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);
        startSpinnerSetup();
        setButtonsOnClickListener();
        setRatingBarReaction();
    }

    public void startSpinnerSetup() {

        spinner = (Spinner) findViewById(R.id.SpinnerListSerials);
        for(Serial serial : MainFragment.mainUser.watchedSerial)
        {
            listSerialName.add(serial.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listSerialName);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                serialReview = MainFragment.mainUser.watchedSerial.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setAdapter(adapter);
    }

    public void setButtonsOnClickListener() {
        Button cancelButton = (Button) findViewById(R.id.cancelButton);
        Button addButton = (Button) findViewById(R.id.addReviewButton);
        final EditText editText = (EditText) findViewById(R.id.ReviewText);
        final EditText editTextTitle = (EditText) findViewById(R.id.ReviewTitle);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddReviewActivity.super.onBackPressed();
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Review review = new Review(editText.getText().toString(), new Date().toString(), serialRating, editTextTitle.getText().toString(), MainFragment.mainUser);
                MainFragment.mainUser.reviews.add(review);
                Toast.makeText(getApplicationContext(), "Ревю успішно додано", Toast.LENGTH_LONG).show();
                AddReviewActivity.super.onBackPressed();
            }
        });

    }

    public void setRatingBarReaction()
    {
        ratingSerial = (RatingBar) findViewById(R.id.SerialRatingBar);

        ratingSerial.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                serialRating = rating;
                ratingSerial.setRating(rating);
            }
        });
    }
}
