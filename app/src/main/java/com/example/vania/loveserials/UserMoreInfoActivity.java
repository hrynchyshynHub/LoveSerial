package com.example.vania.loveserials;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.fragments.MainFragment;
import com.example.vania.loveserials.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserMoreInfoActivity extends AppCompatActivity {
    User userToShowMoreInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent myIntent = getIntent();
        String userToDrawId = myIntent.getStringExtra("userId");
        for(User user : User.fakeUsers)
        {
            if(userToDrawId.equals(user.id.toString()))
            {
                userToShowMoreInfo = user;
                break;
            }
        }
        setContentView(R.layout.activity_user_more_info);
        setMoreInformationUser();
    }

    public void setMoreInformationUser()
    {
        TextView firstSecondName = (TextView) findViewById(R.id.UserMoreInfoFirstSecondName);
        TextView dateOfBirth = (TextView) findViewById(R.id.UserMoreInfoDateOfBirth);
        TextView homeTown = (TextView) findViewById(R.id.UserMoreInfoHomeTown);
        TextView phoneNumber = (TextView) findViewById(R.id.UserMoreInfoPhoneNumber);
        TextView status = (TextView) findViewById(R.id.UserMoreInfoStatus);
        TextView countUsersFollows = (TextView) findViewById(R.id.UserMoreInfoCountUsersFollows);
        TextView countSerialFollows = (TextView) findViewById(R.id.UserMoreInfoCountSerialsFollows);
        TextView countWatchedSerials = (TextView) findViewById(R.id.UserMoreInfoCountWatchedSerials);
        TextView countPosts = (TextView) findViewById(R.id.UserMoreInfoCountPosts);
        TextView countReviews = (TextView) findViewById(R.id.UserMoreInfoCountReview);

        firstSecondName.setText(userToShowMoreInfo.fName + " " + userToShowMoreInfo.lName);
        dateOfBirth.setText(userToShowMoreInfo.dateOfBirth);
        homeTown.setText(userToShowMoreInfo.homeTown);
        phoneNumber.setText(userToShowMoreInfo.phoneNumber);
        status.setText(userToShowMoreInfo.status);
        if(userToShowMoreInfo.subscribeToUsers.size()==0)
        {
            countUsersFollows.setText("0");
        }
        else {
            countUsersFollows.setText(userToShowMoreInfo.subscribeToUsers.size());
        }
        if(userToShowMoreInfo.subscribeToSerials.size()==0)
        {
            countSerialFollows.setText("0");
        }
        else {
            countSerialFollows.setText(userToShowMoreInfo.subscribeToSerials.size());
        }
        if(userToShowMoreInfo.watchedSerial.size()==0||userToShowMoreInfo.watchedSerial==null)
        {
            countWatchedSerials.setText("0");
        }
        else {
            countWatchedSerials.setText(String.valueOf(userToShowMoreInfo.watchedSerial.size()));
        }
        /*if(userToShowMoreInfo.posts.size()==0)
        {
            countPosts.setText("0");
        }*/
       /* else {
           // countPosts.setText(userToShowMoreInfo.posts.size());
        }*/
        if(userToShowMoreInfo.reviews.size()==0)
        {
            countReviews.setText("0");
        }
        else {
            countReviews.setText(String.valueOf(userToShowMoreInfo.reviews.size()));
        }
    }
}
