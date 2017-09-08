package com.example.vania.loveserials.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.adapters.SearchFriendsAdapter;
import com.example.vania.loveserials.adapters.SearchSerialsListAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFriendsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private SearchFriendsAdapter searchFriendsAdapter;
    private SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_friends, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.search_recycler_friends);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        searchFriendsAdapter = new SearchFriendsAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(searchFriendsAdapter);
        searchFriendsAdapter.addAll(User.fakeUsers);
        setFriendsSearchTypeListener();
        return view;
    }
    public void setFriendsSearchTypeListener()
    {
        searchView = (SearchView) view.findViewById(R.id.SearchFriendsView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchFriendsAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchFriendsAdapter.filter(newText);
                return true;
            }
        });
    }

}
