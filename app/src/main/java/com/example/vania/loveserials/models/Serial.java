package com.example.vania.loveserials.models;

import com.example.vania.loveserials.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;


public class Serial {
    public UUID id;
    public String name;
    public String description;
    public String country;
    public String endYear;
    public String release;
    public static ArrayList<Serial> fakeSerial = new ArrayList<>();
    public int countOfSeason;

    public ArrayList<Season> serialSeasons;
    public ArrayList<User> usersWhoWatched = new ArrayList<>();
    public List<Post> serialPosts = new ArrayList<>();
    public List<Review> serialReviews = new ArrayList<>();
    public List<SubscribeToSerial> subscribeToSerials;
    public List<Integer> contents;
    public List<Actor> actors = new ArrayList<>();

    public Serial(String name, String description, String country, String endYear, String release, List<Review> serialReviews, List<Integer> contents, int countOfSeason, List<Actor> actors) {
        this.name = name;
        this.description = description;
        this.country = country;
        this.endYear = endYear;
        this.release = release;
        this.serialReviews = serialReviews;
        this.contents = contents;
        this.countOfSeason = countOfSeason;
        this.actors = actors;
    }

    public static void initialise(){
        Serial serial1 = new Serial("Taboo", "Adventurer James Keziah Delaney returns to London during the War of 1812 to rebuild his late father's shipping empire. However, both the government and his biggest competitor want his inheritance at any cost - even murder.", "USA", "2018", "2016", Arrays.asList(Review.fakeReview.get(2)),Arrays.asList(R.drawable.taboomain, R.drawable.taboofirst),2,Arrays.asList(Actor.fakeActors.get(0), Actor.fakeActors.get(1)));
        Serial serial2 = new Serial("Dr House", "An antisocial maverick doctor who specializes in diagnostic medicine does whatever it takes to solve puzzling cases that come his way using his crack team of doctors and his wits.", "Great Britain", "2008", "2002", Arrays.asList(Review.fakeReview.get(0)),Arrays.asList(R.drawable.drhousemain, R.drawable.drhousefirst),6,Arrays.asList(Actor.fakeActors.get(2), Actor.fakeActors.get(3)));
        Serial serial3 = new Serial("WestWorld", "Set at the intersection of the near future and the reimagined past, explore a world in which every human appetite, no matter how noble or depraved, can be indulged without consequence.", "USA", "2020", "2016", Arrays.asList(Review.fakeReview.get(3)),Arrays.asList(R.drawable.westworldmain) ,2,Arrays.asList(Actor.fakeActors.get(4), Actor.fakeActors.get(5)));
        Serial serial4 = new Serial("Lost", "The survivors of a plane crash are forced to work together in order to survive on a seemingly deserted tropical island.", "Germany", "2006", "2000",  Arrays.asList(Review.fakeReview.get(4), Review.fakeReview.get(7)),Arrays.asList(R.drawable.lostmain, R.drawable.lostfirst) , 7,Arrays.asList(Actor.fakeActors.get(6)));
        Serial serial5 = new Serial("Breaking bad", "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.", "USA", "2010", "2006", Arrays.asList(Review.fakeReview.get(1), Review.fakeReview.get(6)),Arrays.asList(R.drawable.breakingbadmain, R.drawable.breakingbadfirst, R.drawable.breakingbadfirstsecond) ,6,Arrays.asList( Actor.fakeActors.get(7), Actor.fakeActors.get(8)));
        Serial serial6 = new Serial("Frasier", "Dr. Frasier Crane moves back to his hometown of Seattle where he lives with his father and works as a radio psychiatrist.", "USA", "2008", "2006", Collections.<Review>emptyList(), Arrays.asList(R.drawable.frasiermain),4, Arrays.asList(Actor.fakeActors.get(9), Actor.fakeActors.get(10)));
        Serial serial7 = new Serial("Malcolm in center", "A gifted young teen tries to survive life with his dimwitted, dysfunctional family.", "USA", "2006", "2002", Arrays.asList(Review.fakeReview.get(5)), Arrays.asList(R.drawable.malcolmain),5,Arrays.asList(Actor.fakeActors.get(11)));
        fakeSerial.add(serial1);
        fakeSerial.add(serial2);
        fakeSerial.add(serial3);
        fakeSerial.add(serial4);
        fakeSerial.add(serial5);
        fakeSerial.add(serial6);
        fakeSerial.add(serial7);

        Post.initialise();

        serial1.serialPosts = Arrays.asList(Post.fakePost.get(10));
        serial2.serialPosts = Arrays.asList(Post.fakePost.get(11));
        serial3.serialPosts = Arrays.asList(Post.fakePost.get(12), Post.fakePost.get(13));
        serial4.serialPosts = null;
        serial5.serialPosts = Arrays.asList(Post.fakePost.get(9));
        serial6.serialPosts = Arrays.asList(Post.fakePost.get(15));
        serial7.serialPosts = Arrays.asList(Post.fakePost.get(16), Post.fakePost.get(14));
        fakeSerial.clear();
        fakeSerial.add(serial1);
        fakeSerial.add(serial2);
        fakeSerial.add(serial3);
        fakeSerial.add(serial4);
        fakeSerial.add(serial5);
        fakeSerial.add(serial6);
        fakeSerial.add(serial7);
    }

}
