package com.example.vania.loveserials.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by naliv on 11.08.2017.
 */

public class Actor {
    private UUID id;
    private String dateOfBirth;
    private String description;
    public String fName;
    public String sName;
    private List<Serial> actorSeries;
    public static ArrayList<Actor> fakeActors = new ArrayList<>();

    public Actor(String dateOfBirth, String description, String fName, String sName) {
        this.dateOfBirth = dateOfBirth;
        this.description = description;
        this.fName = fName;
        this.sName = sName;
        id = UUID.randomUUID();
    }


        public static void initialise(){
            Actor actor1 = new Actor("1954","","Bryan", "Cranston");
            Actor actor2 = new Actor("1983","","Aaron", "Paul");
            Actor actor3 = new Actor("1975","","Tom", "Hardy");
            Actor actor4 = new Actor("1956","","Bill", "Leo");
            Actor actor5 = new Actor("1965","","Hue", "Lory");
            Actor actor6 = new Actor("1985","","Liza", "Edelshtein");
            Actor actor7 = new Actor("1945","","Antony","Hopkins");
            Actor actor8 = new Actor("1957","","Ed", "Harris");
            Actor actor9 = new Actor("1978","","Matthew", "Fox");
            Actor actor10 = new Actor("1987","","Evengelin","Lilley");
            Actor actor11 = new Actor("1976","","Kelsi", "Grimmer");
            Actor actor12 = new Actor("1988","","Franki", "Muniz");

            fakeActors.add(actor1);
            fakeActors.add(actor2);
            fakeActors.add(actor3);
            fakeActors.add(actor4);
            fakeActors.add(actor5);
            fakeActors.add(actor6);
            fakeActors.add(actor7);
            fakeActors.add(actor8);
            fakeActors.add(actor9);
            fakeActors.add(actor10);
            fakeActors.add(actor11);
            fakeActors.add(actor12);
        }

}
