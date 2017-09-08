package com.example.vania.loveserials.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.adapters.NewsAdapter;
import com.example.vania.loveserials.adapters.PostAdapter;
import com.example.vania.loveserials.adapters.SearchSerialsListAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.MainUser;
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Review;
import com.example.vania.loveserials.models.Serial;
import com.example.vania.loveserials.models.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;

    private LinearLayoutManager horizontalLinearLayoutManager;
    private NewsAdapter newsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.all_posts_recycler);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        newsAdapter = new NewsAdapter();

        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(newsAdapter);


        List<Post> postList = new ArrayList<>();
        List<Review> reviewList = new ArrayList<>();
        for(User user : User.fakeUsers)
        {
            postList.addAll(user.posts);
            reviewList.addAll(user.reviews);
        }
        for(Serial serial : Serial.fakeSerial)
        {
            if(serial.serialPosts!=null)
            postList.addAll(serial.serialPosts);
        }

        newsAdapter.addAll((List)postList);
        newsAdapter.addAll((List)reviewList);
        return view;
    }
}
