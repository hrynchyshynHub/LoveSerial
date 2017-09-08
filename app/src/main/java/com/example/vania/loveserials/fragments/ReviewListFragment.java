package com.example.vania.loveserials.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.adapters.ReviewAdapter;
import com.example.vania.loveserials.adapters.SearchFriendsAdapter;
import com.example.vania.loveserials.adapters.SearchSerialsListAdapter;
import com.example.vania.loveserials.models.User;


public class ReviewListFragment extends Fragment {
    private User userToDraw;
    private ReviewAdapter reviewAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_review);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        reviewAdapter = new ReviewAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(reviewAdapter);
        Bundle bundle = getArguments();
        String userId = bundle.getString("userId");
        for(User user: User.fakeUsers)
        {
            if(user.id.toString().equals(userId))
            {
                userToDraw = user;
                break;
            }
        }
        if(userToDraw.reviews==null||userToDraw.reviews.size()==0)
        {
            Toast.makeText(this.getActivity(),"Жодного ревю",Toast.LENGTH_LONG).show();
        }
        else {
            reviewAdapter.addAll(userToDraw.reviews);
        }
        return view;
    }
}
