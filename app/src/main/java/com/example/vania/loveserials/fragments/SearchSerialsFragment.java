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
import com.example.vania.loveserials.adapters.SearchSerialsListAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.Serial;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSerialsFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private SearchSerialsListAdapter searchSerialsListAdapter;
    private SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search_serials, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.search_recycler);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        searchSerialsListAdapter = new SearchSerialsListAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(searchSerialsListAdapter);
        searchSerialsListAdapter.addAll(Serial.fakeSerial);
        setSearchTypeListener();
        return view;
    }

    public void setSearchTypeListener()
    {
        searchView = (SearchView) view.findViewById(R.id.SearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchSerialsListAdapter.filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchSerialsListAdapter.filter(newText);
                return true;
            }
        });
    }
}
