package com.example.vania.loveserials.models;

import com.example.vania.loveserials.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import retrofit2.http.POST;

/**
 * Created by naliv on 11.08.2017.
 */

public class Post {
    public UUID id;
    public String date;
    public int imgId;
    public String text;
    public boolean isUserPost;
    public int likes;
    public int dislikes;
    public static ArrayList<Post> fakePost = new ArrayList<>();

    public Serial serial;
    public User user;

    public Post(String date, String text, int imgId, Serial serial, User user, boolean isUserPost) {
        this.date = date;
        this.text = text;
        this.imgId = imgId;
        likes = 0;
        dislikes = 0;
        id = UUID.randomUUID();
        this.serial = serial;
        this.user = user;
        this.isUserPost = isUserPost;
    }

    public static void initialise() {
        Post post1 = new Post(new Date().toString(),"Hi. Happy to see you all",R.drawable.firstuser_firstpost, null, User.fakeUsers.get(1), true);
        Post post2 = new Post(new Date().toString(),"I watched first serial Breaking bad",R.drawable.firstuser_secondpost,null, User.fakeUsers.get(1), true);
        Post post3 = new Post(new Date().toString(),"What do you think about last episode of Breaking bad?",R.drawable.firstuser_thirdpost, null, User.fakeUsers.get(1), true);
        Post post4 = new Post(new Date().toString(),"Hey, what's up", R.drawable.seconduser_firstpost, null, User.fakeUsers.get(2), true);
        Post post5 = new Post(new Date().toString(),"I can't start wath new episode of Game of thrones", R.drawable.seconduser_secondpost,null, User.fakeUsers.get(2), true);
        Post post6 = new Post(new Date().toString(),"Oh amazing last episode, cant wait to last season", R.drawable.seconduser_thirdpost, null, User.fakeUsers.get(2), true);
        Post post7 = new Post(new Date().toString(),"Hi all. I am serial fan, please follow me", R.drawable.thirduser_firstpost, null, User.fakeUsers.get(3), true);
        Post post8 = new Post(new Date().toString(),"Hi everyone and happy to see you",R.drawable.fourthuser_firstpost, null, User.fakeUsers.get(4),true);
        Post post9 = new Post(new Date().toString(),"I am start watch Lost",R.drawable.fourthuser_secondpost, null, User.fakeUsers.get(4),true);
        Post post10 = new Post(new Date().toString(),"NICE TO MITTE YOU. Who is RJ Mitte, Breaking Bad star who quit Celebrity Island 2017and what’s he said about cerebral palsy?", R.drawable.firstserial_firstpost, Serial.fakeSerial.get(4),null, false);
        Post post11 = new Post(new Date().toString(),"11 burning questions we have after Taboo episode eight. The finale of the BBC period drama saw James Delaney’s plan come to life – but will there be another series?", R.drawable.secondserial_secondpost, Serial.fakeSerial.get(0), null, false);
        Post post12 = new Post(new Date().toString(),"Doctor Foster recap: series two, episode one – a warm welcome back to Simon. Just when you thought Gemma might be getting her life on track, her ex returns to Parminster. This means war ",R.drawable.thirdserial_firstpost, Serial.fakeSerial.get(1), null, false);
        Post post13 = new Post(new Date().toString(),"Westworld season 2: New footage released in HBO 2018 preview. Allow these to heighten your intrigue over the sci-fi western's forthcoming season",R.drawable.fourthserial_firstpost, Serial.fakeSerial.get(2), null, false);
        Post post14 = new Post(new Date().toString(),"Hackers Threaten HBO Again: ‘Westworld’ Season 2 Might Be Leaked",R.drawable.fifthserial_firstpost, Serial.fakeSerial.get(2), null, false);
        Post post15 = new Post(new Date().toString(),"Emmy Award winners to appear in benefit for Theatre Macon’s endowment campaign",R.drawable.sixthserial_firstpost, Serial.fakeSerial.get(6), null, false);
        Post post16 = new Post(new Date().toString(),"Frasier Revival is Unlikely, According to NBC Chairman",R.drawable.seventhserial_firstpost, Serial.fakeSerial.get(5), null, false);
        Post post17 = new Post(new Date().toString(),"Hi. Malcolm In The Middle's Frankie Muniz and Teen Beach Movie's Jordan Fisher 'set to join the cast of DWTS' along with former Lakers star Derek Fisher", R.drawable.eightsserial_firstpost, Serial.fakeSerial.get(6), null, false);

        fakePost.add(post1);
        fakePost.add(post2);
        fakePost.add(post3);
        fakePost.add(post4);
        fakePost.add(post5);
        fakePost.add(post6);
        fakePost.add(post7);
        fakePost.add(post8);
        fakePost.add(post9);
        fakePost.add(post10);
        fakePost.add(post11);
        fakePost.add(post12);
        fakePost.add(post13);
        fakePost.add(post14);
        fakePost.add(post15);
        fakePost.add(post16);
        fakePost.add(post17);
    }
}
