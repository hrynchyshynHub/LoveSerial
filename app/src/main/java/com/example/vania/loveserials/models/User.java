package com.example.vania.loveserials.models;

import android.provider.ContactsContract;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.fragments.UserFragment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by naliv on 11.08.2017.
 */

public class User {
    public UUID id;
    public String fName;
    public String lName;
    public String dateOfBirth;
    public String homeTown;
    public String description;
    public String status;
    public String phoneNumber;

    public List<Post> posts = new ArrayList<>();
    public List<Review> reviews = new ArrayList<>();
    public List<Integer> contents = new ArrayList<>();
    public List<Serial> watchedSerial = new ArrayList<>();
    public List<SubscribeToUser> subscribeToUsers = new ArrayList<>();
    public List<SubscribeToSerial> subscribeToSerials = new ArrayList<>();
    public static ArrayList<User> fakeUsers = new ArrayList<>();

    public User(String description, String fName, String lName, String homeTown, String phoneNumber, String status, String dateOfBirth, List<Integer> contents) {
        id = UUID.randomUUID();
        this.fName = fName;
        this.lName = lName;
        this.dateOfBirth = dateOfBirth;
        this.homeTown = homeTown;
        this.description = description;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.contents = contents;


    }

    public static void initialise() {
        Actor.initialise();

        User user = new User("Main user", "Andriy", "Glynka", "Lviv", "3807653131", "Happy to be here", "12-08-17", Arrays.asList(R.drawable.firstusermain));
        User user1 = new User("First User that i create", "Petro", "Karabyn", "Lviv", "380681231243", "Wait to return to USA", "03-07-1994",  Arrays.asList(R.drawable.firstusermain, R.drawable.firstuserfirst));
        User user2 = new User("Second user that i create", "Pavlo", "Shumylo", "Iowa", "380981123123", "Return to Ukraine((", "12-12-1987", Arrays.asList(R.drawable.secondusermain));
        User user3 = new User("Third user that i create", "Tadey", "Syhlovuy", "Lviv", "381231231256", "Study in Politechnick university", "12-12-1991", Arrays.asList(R.drawable.thirdusermain, R.drawable.thirduserfirst, R.drawable.thirdusersecond));
        User user4 = new User("Fourth user that i create", "Vania", "Hrynchyshyn", "Ternopil", "38138543456", "Works in Eleks and happy", "07-11-1997", Arrays.asList(R.drawable.fourthusermain, R.drawable.fourthuserfirst));
        fakeUsers.add(user);
        fakeUsers.add(user1);
        fakeUsers.add(user2);
        fakeUsers.add(user3);
        fakeUsers.add(user4);

        Review.initialise();

        user1.posts = Arrays.asList(Post.fakePost.get(0),Post.fakePost.get(1),Post.fakePost.get(2));
        user2.posts = Arrays.asList(Post.fakePost.get(3),Post.fakePost.get(4),Post.fakePost.get(5));
        user3.posts = Arrays.asList(Post.fakePost.get(6));
        user4.posts = Arrays.asList(Post.fakePost.get(7),Post.fakePost.get(8));

        user1.watchedSerial = Arrays.asList(Serial.fakeSerial.get(4));
        user2.watchedSerial = Arrays.asList(Serial.fakeSerial.get(0), Serial.fakeSerial.get(1));
        user3.watchedSerial = Arrays.asList(Serial.fakeSerial.get(2),Serial.fakeSerial.get(4));
        user4.watchedSerial = Arrays.asList(Serial.fakeSerial.get(3),Serial.fakeSerial.get(5),Serial.fakeSerial.get(6));

        user1.reviews = Arrays.asList(Review.fakeReview.get(0),Review.fakeReview.get(1));
        user2.reviews = Arrays.asList(Review.fakeReview.get(2));
        user3.reviews = Arrays.asList(Review.fakeReview.get(3),Review.fakeReview.get(4),Review.fakeReview.get(5));
        user4.reviews = Arrays.asList(Review.fakeReview.get(6),Review.fakeReview.get(7));

        fakeUsers.clear();
        fakeUsers.add(user);
        fakeUsers.add(user1);
        fakeUsers.add(user2);
        fakeUsers.add(user3);
        fakeUsers.add(user4);

    }
}
