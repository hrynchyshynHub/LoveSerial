package com.example.vania.loveserials.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by naliv on 11.08.2017.
 */

public class Review {
    public UUID id;
    public String text;
    public String date;
    public float rating;
    public String title;
    public Serial serial;
    public String userId;
    public User user;
    public static ArrayList<Review> fakeReview = new ArrayList();

    public Review(String text, String date, float rating, String title, User user) {
        this.text = text;
        this.date = date;
        this.rating = rating;
        this.title = title;
        id = UUID.randomUUID();
        this.user = user;
    }

    public static void initialise(){


        Review review1 = new Review("Let me put it simply. I am a physician, and as an inviolable rule, I HATE medical shows. Granted, TV series tend to be one dimensional, due to inherent difficulties in the genre, but \"doctor shows\" are something I avoid like the proverbial plague. And then one evening I caught \"House, MD\" and was completely drawn into the show. In House I find the anti-hero that I've been waiting for in a medical show. The guy who knows everything, but is wrong often enough to keep us all guessing. I enjoy the contrast of House and his cadre of young fresh faced colleagues, complete with starched white lab coats, who struggle as much with their professionally imposed constraints, and sense of decorum, as they do with his personality. And, wonder of wonders, the use of ironic and tragic comedy is without peer in what I've seen in the TV world in recent memory. In a nutshell, I really never know what any given character will say or do and it's that freshness that will keep me coming back for more. Somewhere there is a team of writers who actually know their craft, and an acting ensemble that knows how to pull it off. Now I can watch my TV one hour a week........","",3f,"", User.fakeUsers.get(1));
        Review review2 = new Review("I probably haven't been hooked to a TV show like I am to Breaking Bad before. This beautiful piece of art is incredibly well written and directed, furthermore the actors are doing a tremendous job! I've read a few remarks about the pace of the show, saying it is too slow. I completely disagree, there are so many aspects which get their place in the series, every single one in its own way and it would be horrible if we'd see a too fast paced show containing ridiculous cliffhangers like we see them on the major networks. Because this way you can entirely fall in love with the show, the characters and every tiny detail of the story and the best part of it, it is unbelievably addictive and makes you starve for more week after week! ",new Date().toString(),4.5f,"",User.fakeUsers.get(1));
        Review review3 = new Review("Imagine a man with the shaman-like charisma and borderline madness of Jim Morrison (at least as he was depicted in Oliver Stone's film 'The Doors') but equipped with the vicious fighting skills of Wolverine. Add to that the intellect and strategic talents of Francis Underwood from 'House of Cards' as well as a - very large - dose of trauma induced mental problems (especially mother issues; well: some sister issues as well) – and you've almost got James Keziah Delaney (Tom Hardy), the central character of the new show 'Taboo'. And let me tell you: he just so happens to be one of the most compelling and original protagonists I've seen in a TV-show since Ian McShane blessed us with the character of Al Swearengen in 'Deadwood' (ok, there was that other guy from that cooking show, you know: 'Baking Bread' or something like that - he was pretty singular too)",new Date().toString(),2,"", User.fakeUsers.get(2));
        Review review4 = new Review("was 10 years old when the film Westworld was first released. At the time it struck me as a less than satisfying synthesis of cool robot movie and boring western. Forty-odd years later, in anticipation of the debut of HBO’s TV series, Westworld (Sky Atlantic), I was inclined to think the opposite: why ruin a good horse opera with robots? This is actually the second TV series spawned by the film. The first, Beyond Westworld, emerged in 1980 and lasted just five episodes. The new one is already a huge deal: the first episode aired in the States on Sunday night, and was HBO’s biggest series debut in three years.",new Date().toString(),5,"", User.fakeUsers.get(3));
        Review review5 = new Review("*** This review may contain spoilers ***. LOST is a cool experimental TV series. It has been wrongly labeled as a simple concoction of well known stories (e.g. Lord of the flies, The beach). Due to its complexity, you feel lost at times. The unnumbered flashbacks, which were conceived as a novelty at first, have turned off many unprepared viewers. A few flashbacks didn't seem to contribute to the overall plots and only broke the flow of the story, especially when the viewers were eager to know more about what's happening on the island. Admittedly, they helped build the characters and explained their behaviors and the choices they made, but in a very short-lived manner. ",new Date().toString(),1.5f,"", User.fakeUsers.get(3));
        Review review6 = new Review("This is without doubt the most entertaining family show on TV. Why? Because it not the same boring story that you normally see in family show – that at the end they will forgive and forget each family member for the wrong they have done.Story: One family, Two Parents, Fours Boys from hell – What could go right? Yeah all you see here is the mischief, and more mischief. The real life situation which being transform into a total hilarious story. That what make Malcolm so special and it very unique story for each week make this make this series fool-proof from boredom, cause you'll never know what next.",new Date().toString(),3,"", User.fakeUsers.get(3));
        Review review7 = new Review("The age of Bryan Cranston has returned. Once universally lauded for his work in Malcolm In The Middle, there had yet to be a good vehicle for this man's particular talents. He has that rare gift of generating sympathy and manic-energy at the same time. For those that would be content to label this show a Weeds knock-off, bear in mind that Breaking Bad is a new kind of monster. It touches on the very same themes, \"living realistically as a middle class in the United States\" which often makes us resort to extremes to survive. Like the mother and daughter team that robbed that bank. But the weed selling antics of Showtime's hit show is really nothing like \"Bad.\" The Pilot was about as perfect a Pilot as I've ever seen, and much of it rests on Bryan Cranston's shoulders.\n",new Date().toString(),2.5f,"", User.fakeUsers.get(4));
        Review review8 = new Review("With so many high-quality shows ending or getting cancelled recently (Friends, Frasier, Buffy the Vampire Slayer, Angel), and with the decline in quality of many others (The West Wing, Smallville), not to mention the egregious rise of turgid and tasteless \"reality\" programming, I'd just about written off TV as an entertainment medium. I was seriously considering ditching my TV and cable subscription in favour of my computer screen and broadband Internet connection.Then along comes \"Lost\". I missed the first few episodes, but was able to catch up thanks to BitTorrent. Now I'm hooked. There are several things to like about this show, but here's a quick list: ",new Date().toString(),1,"", User.fakeUsers.get(4));
        fakeReview.add(review1);
        fakeReview.add(review2);
        fakeReview.add(review3);
        fakeReview.add(review4);
        fakeReview.add(review5);
        fakeReview.add(review6);
        fakeReview.add(review7);
        fakeReview.add(review8);

        Serial.initialise();

        review1.serial = Serial.fakeSerial.get(1);
        review2.serial = Serial.fakeSerial.get(4);
        review3.serial = Serial.fakeSerial.get(0);
        review4.serial = Serial.fakeSerial.get(2);
        review5.serial = Serial.fakeSerial.get(3);
        review6.serial = Serial.fakeSerial.get(6);
        review7.serial = Serial.fakeSerial.get(4);
        review8.serial = Serial.fakeSerial.get(3);

        fakeReview.clear();

        fakeReview.add(review1);
        fakeReview.add(review2);
        fakeReview.add(review3);
        fakeReview.add(review4);
        fakeReview.add(review5);
        fakeReview.add(review6);
        fakeReview.add(review7);
        fakeReview.add(review8);
    }

}
