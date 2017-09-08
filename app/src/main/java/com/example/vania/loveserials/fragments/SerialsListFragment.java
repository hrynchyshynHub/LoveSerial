package com.example.vania.loveserials.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.adapters.SearchSerialsListAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.MainUser;
import com.example.vania.loveserials.models.Serial;
import com.example.vania.loveserials.models.User;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SerialsListFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private SearchSerialsListAdapter myWatchedSerials;
    User userToDraw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serials_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.watchedListRecycler);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        myWatchedSerials = new SearchSerialsListAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(myWatchedSerials);
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
        if(userToDraw.watchedSerial==null||userToDraw.watchedSerial.size()==0)
        {
            Toast.makeText(this.getActivity(),"Жодного улюбленого серіалу",Toast.LENGTH_LONG).show();
        }
        else {
            myWatchedSerials.addAll(userToDraw.watchedSerial);
        }
        return view;

    }

}
