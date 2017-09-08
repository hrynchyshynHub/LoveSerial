package com.example.vania.loveserials.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.TestMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.adapters.PostAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.Actor;
import com.example.vania.loveserials.models.Serial;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SerialContentFragment extends Fragment {
    Serial serialModelToDraw = null;
    PostAdapter postAdapter;
    View view;
    LinearLayoutManager horizontalLinearLayoutManager;
    RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        String name = bundle.getString("Name");
        view = inflater.inflate(R.layout.fragment_serial_content, container, false);
        for(Serial serial:Serial.fakeSerial)
        {
            if(name.toLowerCase().equals(serial.name.toLowerCase()))
            {
                serialModelToDraw = serial;
                break;
            }
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.SerialPost);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(postAdapter);
        if(serialModelToDraw.serialPosts!=null)
            postAdapter.addAll(serialModelToDraw.serialPosts);
        drawPage();
        setToAddInWatchedListener();
        setClickFollowSerialListener();
        return view;
    }

    public void drawPage()
    {
        TextView textView = (TextView) view.findViewById(R.id.MainSerialName);
        textView.setText(serialModelToDraw.name);

        ImageView imageView = (ImageView) view.findViewById(R.id.MainSerialImage);
        imageView.setImageResource(serialModelToDraw.contents.get(0));

        TextView descriptionTextView = (TextView) view.findViewById(R.id.SerialMainDescription);
        descriptionTextView.setText(serialModelToDraw.description);

        TextView textViewActors = (TextView) view.findViewById(R.id.Actors);
        String actors = "";
        for(Actor actor : serialModelToDraw.actors)
        {
            actors+=actor.fName + " " + actor.sName + ", ";
        }
        textViewActors.setText(actors);

        TextView textViewCountSeasons = (TextView) view.findViewById(R.id.SeasonCount);
        textViewCountSeasons.setText(String.valueOf(serialModelToDraw.countOfSeason));
    }

    public void setToAddInWatchedListener()
    {
        final Button button = (Button) view.findViewById(R.id.AddToWatchedListButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("Додати в список улюблених"))
                {
                    button.setText("Серіал в улюблених");
                }
                else {
                    button.setText("Додати в список улюблених");
                }
            }
        });
    }
    public void setClickFollowSerialListener()
    {
        final Button button = (Button)view.findViewById(R.id.FollowSerialButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(button.getText().equals("Підписатися"))
                {
                    button.setText("Ви підписані");
                }
                else {
                    button.setText("Підписатися");
                }
            }
        });

    }

}
