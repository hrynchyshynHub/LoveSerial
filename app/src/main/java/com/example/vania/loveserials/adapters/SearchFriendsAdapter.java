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
import com.example.vania.loveserials.fragments.UserFragment;
import com.example.vania.loveserials.models.Content;
import com.example.vania.loveserials.models.User;

import java.util.ArrayList;
import java.util.List;


public class SearchFriendsAdapter extends RecyclerView.Adapter<FriendsRecyclerViewHolder> {
    public static ArrayList<User> allUserList = new ArrayList<>();
    ArrayList<User> copyAllUserList = new ArrayList<>();
    public void addAll(List<User> fakeUsers)
    {
        int pos = getItemCount();
        this.allUserList.addAll(fakeUsers.subList(1,fakeUsers.size()));
        this.copyAllUserList.addAll(fakeUsers.subList(1, fakeUsers.size()));
        notifyItemRangeInserted(pos, this.allUserList.size());
        notifyItemRangeInserted(pos, this.copyAllUserList.size());

    }

    @Override
    public FriendsRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card, parent, false);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationMenu navigationMenu = (NavigationMenu) v.getContext();
                UserFragment profileFragment = new UserFragment();
                TextView textViewFirstName = (TextView) view.findViewById(R.id.UserFirstName);
                TextView textViewSecondName = (TextView) view.findViewById(R.id.UserSecondName);
                Bundle myBundle = new Bundle();
                myBundle.putString("FirstName", textViewFirstName.getText().toString());
                myBundle.putString("SecondName", textViewSecondName.getText().toString());
                profileFragment.setArguments(myBundle);
                navigationMenu.getFragmentManager().beginTransaction().replace(R.id.container,profileFragment).addToBackStack(null).commit();

            }
        });
        return new FriendsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FriendsRecyclerViewHolder holder, int position) {

        holder.bind(allUserList.get(position));
    }
    @Override
    public int getItemCount() {
        return allUserList.size();
    }

    public void filter(String text) {
        allUserList.clear();
        if(text.isEmpty()){
            allUserList.addAll(copyAllUserList);
        } else{
            text = text.toLowerCase();
            for(User item: copyAllUserList){
                if((item.fName + " " + item.lName).toLowerCase().contains(text)){
                    allUserList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}

class FriendsRecyclerViewHolder extends RecyclerView.ViewHolder
{
    ImageView userAva;
    TextView userFirstName;
    TextView userSecondName;
    TextView userAge;

    public FriendsRecyclerViewHolder(View itemView) {
        super(itemView);
        userAge = (TextView) itemView.findViewById(R.id.UserAge);
        userFirstName = (TextView) itemView.findViewById(R.id.UserFirstName);
        userSecondName = (TextView) itemView.findViewById(R.id.UserSecondName) ;
        userAva = (ImageView) itemView.findViewById(R.id.UserAva);

    }
    public void bind(User user)
    {
        userAge.setText(user.dateOfBirth.toString());
        userFirstName.setText(user.fName + " ");
        userSecondName.setText(user.lName);
        userAva.setImageResource(user.contents.get(0));
        }
}
