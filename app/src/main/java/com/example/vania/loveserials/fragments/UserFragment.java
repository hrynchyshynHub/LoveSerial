package com.example.vania.loveserials.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.UserMoreInfoActivity;
import com.example.vania.loveserials.adapters.PostAdapter;
import com.example.vania.loveserials.adapters.SearchFriendsAdapter;
import com.example.vania.loveserials.models.Content;
import com.example.vania.loveserials.models.User;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserFragment extends Fragment {

    private boolean isImageScaled = false;
    private View view;
    private TextView statusTv;
    private SerialsListFragment serialsListFragment;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;
    private PostAdapter postAdapter;
    ReviewListFragment reviews;

    private User userToDraw = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        serialsListFragment = new SerialsListFragment();
        view = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.postRecycler);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(postAdapter);
        Bundle bundle = this.getArguments();
        String firstName = bundle.getString("FirstName");
        String secondName = bundle.getString("SecondName");
        reviews = new ReviewListFragment();
        for(User user: User.fakeUsers)
        {
            if(firstName.toLowerCase().equals(user.fName.toLowerCase() + " ")&&secondName.toLowerCase().equals(user.lName.toLowerCase()))
            {
                userToDraw = user;
            }
        }
        if(userToDraw.posts!=null)
        postAdapter.addAll(userToDraw.posts);
        startDraw();
        return view;
    }

    public void startDraw()
    {

        if(userToDraw.contents != null) {
            showAllPhoto();
        }
        else{
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.MyPhotoGallery);
            TextView photoTextView = new TextView(view.getContext());
            photoTextView.setText("Тут будуть ваші фотографії");
            linearLayout.addView(photoTextView);
        }
        setMainTextView();
        setShowMoreInfoListener();
        setFollowUserListener();
        setMainListSerialsListener();
        setShowReviewsListener();
    }

    public void setShowMoreInfoListener()
    {
        TextView textView = (TextView)view.findViewById(R.id.TextViewShowMoreMyProfile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserMoreInfoActivity.class);
                intent.putExtra("userId", userToDraw.id.toString());
                startActivity(intent);
            }
        });
    }
    public void setMainListSerialsListener()
    {
        TextView listSerialsTextView = (TextView)view.findViewById(R.id.ListSerials);
        listSerialsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userId", userToDraw.id.toString());
                serialsListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, serialsListFragment).commit();
            }
        });
    }

    public void setFollowUserListener()
    {
        final Button button = (Button)view.findViewById(R.id.FollowButton);
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

    public void showAllPhoto() {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.MyPhotoGallery);

            for(int content : userToDraw.contents)
            {
            ImageView imageView = new ImageView(this.getActivity());
            imageView.setImageResource(content);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 150));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isImageScaled)
                        v.setLayoutParams(new LinearLayout.LayoutParams(500, 500));
                    if (isImageScaled) {
                        v.setLayoutParams(new LinearLayout.LayoutParams(300, 150));
                    }
                    isImageScaled = !isImageScaled;
                }
            });
            linearLayout.addView(imageView);
        }
    }

    public void setMainTextView()
    {
        TextView mainFirstName = (TextView) view.findViewById(R.id.UserFirstName);
        mainFirstName.setText(userToDraw.fName + " ");

        TextView mainSecondName = (TextView) view.findViewById(R.id.UserSecondName);
        mainSecondName.setText(userToDraw.lName);

        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.MainImage);
        circleImageView.setImageResource(userToDraw.contents.get(0));
        LinearLayout cityLinearLayout = (LinearLayout) view.findViewById(R.id.CityLayout);
        TextView cityNameTv = new TextView(view.getContext());
        cityNameTv.setText(userToDraw.homeTown);

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(10, 0, 0, 0);
        cityNameTv.setLayoutParams(llp);
        cityLinearLayout.addView(cityNameTv);

        LinearLayout friendsLinearLayout = (LinearLayout) view.findViewById(R.id.FriendsLayout);
        TextView friendsCountTv = new TextView(view.getContext());
        if(userToDraw.subscribeToUsers==null)
        {
            friendsCountTv.setText("0");
        }
        else {
            friendsCountTv.setText(" " + userToDraw.subscribeToUsers.size());
        }        friendsCountTv.setLayoutParams(llp);
        friendsLinearLayout.addView(friendsCountTv);

        LinearLayout statusLinearLayout = (LinearLayout) view.findViewById(R.id.StatusLayout);
        statusTv = new TextView(view.getContext());

        statusTv.setText(userToDraw.status);

        statusTv.setLayoutParams(llp);
        statusLinearLayout.addView(statusTv);

    }
    public void setShowReviewsListener()
    {
        TextView listSerialsTextView = (TextView) view.findViewById(R.id.UserReviews);
        listSerialsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userId", userToDraw.id.toString());
                reviews.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, reviews).addToBackStack(null).commit();

            }
        });
    }
}
