package com.example.vania.loveserials.adapters;


import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vania.loveserials.NavigationMenu;
import com.example.vania.loveserials.R;
import com.example.vania.loveserials.fragments.SerialContentFragment;
import com.example.vania.loveserials.models.Serial;
import java.util.ArrayList;
import java.util.List;

public class SearchSerialsListAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private ArrayList<Serial> serialModels = new ArrayList<>();
    private ArrayList<Serial> copySerialModels = new ArrayList<>();
    public void addAll(List<Serial> fakeSerials)
    {
        int pos = getItemCount();
        this.serialModels.addAll(fakeSerials);
        this.copySerialModels.addAll(fakeSerials);
        notifyItemRangeInserted(pos, this.serialModels.size());
        notifyItemRangeInserted(pos, this.copySerialModels.size());
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.serial_card, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationMenu navigationMenu = (NavigationMenu) v.getContext();
                SerialContentFragment serialContentFragment = new SerialContentFragment();
                TextView textView = (TextView) view.findViewById(R.id.serialName);
                Bundle myBundle = new Bundle();
                myBundle.putString("Name", textView.getText().toString());
                serialContentFragment.setArguments(myBundle);
                navigationMenu.getFragmentManager().beginTransaction().replace(R.id.container,serialContentFragment).addToBackStack(null).commit();

            }
        });
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.bind(copySerialModels.get(position));
    }

    @Override
    public int getItemCount() {
        return copySerialModels.size();
    }

    public void filter(String text) {
        copySerialModels.clear();
        if(text.isEmpty()){
            copySerialModels.addAll(serialModels);
        } else{
            text = text.toLowerCase();
            for(Serial item: serialModels){
                if(item.name.toLowerCase().contains(text)){
                    copySerialModels.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}
class RecyclerViewHolder extends RecyclerView.ViewHolder
{
    TextView serialName;
    TextView countFollowers;
    TextView description;
    TextView rating;
    ImageView serialImage;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        serialName = (TextView) itemView.findViewById(R.id.serialName);
        countFollowers = (TextView) itemView.findViewById(R.id.countFollowers);
        description = (TextView) itemView.findViewById(R.id.description);
        serialImage = (ImageView) itemView.findViewById(R.id.serialImage);
        rating = (TextView) itemView.findViewById(R.id.SerialRating);
    }
    public void bind(Serial serialModel)
    {
        serialName.setText(serialModel.name);
        if(serialModel.usersWhoWatched==null||serialModel.usersWhoWatched.size()==0)
        {
            countFollowers.setText("0 " + " followers");
        }
        else {
            countFollowers.setText(String.valueOf(serialModel.usersWhoWatched.size()) + " followers");
        }
        description.setText(serialModel.description);
        description.setMaxLines(4);
        serialImage.setImageResource(serialModel.contents.get(0));
        rating.setText("3.7");
    }
}

