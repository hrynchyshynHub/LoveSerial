package com.example.vania.loveserials.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by naliv on 11.08.2017.
 */

public class Season {
    private UUID id;
    private byte number;
    private String description;
    private String releaseDate;
    private int photoId;
    private int serialId;

    ArrayList<Content> seasonContents;
}
