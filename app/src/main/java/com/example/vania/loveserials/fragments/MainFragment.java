package com.example.vania.loveserials.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.vania.loveserials.AddReviewActivity;
import com.example.vania.loveserials.R;
import com.example.vania.loveserials.UserMoreInfoActivity;
import com.example.vania.loveserials.adapters.PostAdapter;
import com.example.vania.loveserials.api.App;
import com.example.vania.loveserials.models.Actor;
import com.example.vania.loveserials.models.Content;
import com.example.vania.loveserials.models.MainUser;
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Review;
import com.example.vania.loveserials.models.Serial;
import com.example.vania.loveserials.models.User;



import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;




public class MainFragment extends Fragment {
    private boolean isImageScaled = false;
    private View view;
    private TextView statusTv;
    private SerialsListFragment serialsListFragment;
    private RecyclerView recyclerView;
    private LinearLayoutManager horizontalLinearLayoutManager;
    ReviewListFragment reviews;
    private PostAdapter postAdapter;
    public static User mainUser ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        User.initialise();
        mainUser = User.fakeUsers.get(0);
        serialsListFragment = new SerialsListFragment();
        recyclerView = (RecyclerView) view.findViewById(R.id.MyPost);
        horizontalLinearLayoutManager = new LinearLayoutManager(getActivity());
        postAdapter = new PostAdapter();
        reviews = new ReviewListFragment();
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
        recyclerView.setAdapter(postAdapter);
        if(mainUser.posts!=null)
        postAdapter.addAll(mainUser.posts);
        startDraw();
        return view;
    }

    public void startDraw() {
        if (mainUser.contents != null) {
            showAllPhoto();
        }
        else
        {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.MainPhotoGallery);
            TextView photoTextView = new TextView(view.getContext());
            photoTextView.setText("Тут будуть ваші фотографії");
            linearLayout.addView(photoTextView);
        }
        setMainTextView();
        setAddPostListener();
        setShowMoreInfoListener();
        setMainListSerialsListener();
        setStatusAlertDialog();
        setAddReviewListener();
        setShowReviewsListener();
    }

    public void showAllPhoto() {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.MainPhotoGallery);
            for(int content : mainUser.contents) {
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

    public void setShowMoreInfoListener()
    {
        TextView textView = (TextView)view.findViewById(R.id.MyTextViewShowMoreMyProfile);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), UserMoreInfoActivity.class);
                intent.putExtra("userId", mainUser.id.toString());
                startActivity(intent);
            }
        });
    }

    public void setMainListSerialsListener()
    {
        TextView listSerialsTextView = (TextView) view.findViewById(R.id.MyListSerials);
        listSerialsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userId", mainUser.id.toString());
                serialsListFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, serialsListFragment).addToBackStack(null).commit();

            }
        });
    }
    public void setAddPostListener()
    {
        Button button = (Button) view.findViewById(R.id.AddPostButton);
        final EditText editText = (EditText) view.findViewById(R.id.TextToPost);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Post post = new Post(new Date().toString(), editText.getText().toString(), R.drawable.secondserial_secondpost, null, mainUser,true);
                            postAdapter.add(post);
            }
        });
    }

    public void setStatusAlertDialog()
    {
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.MyStatusLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(view.getContext());
                View promptsView = li.inflate(R.layout.change_status_dialog, null);
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(view.getContext());
                mDialogBuilder.setView(promptsView);
                final EditText userInput = (EditText) promptsView.findViewById(R.id.EnterStatusEditText);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        mainUser.status = userInput.getText().toString();
                                        statusTv.setText(userInput.getText());
                                    }
                                })
                        .setNegativeButton("Відміна",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();
            }
        });
    }

    public void setMainTextView()
    {
        TextView mainFirstName = (TextView) view.findViewById(R.id.MainUserFirstName);
        mainFirstName.setText(mainUser.fName + " ");

        TextView mainSecondName = (TextView) view.findViewById(R.id.MainUserSecondName);
        mainSecondName.setText(mainUser.lName);
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.MyImage);
        if (mainUser.contents != null) {
            circleImageView.setImageResource(mainUser.contents.get(0));
            }


        LinearLayout cityLinearLayout = (LinearLayout) view.findViewById(R.id.MyCityLayout);
        TextView cityNameTv = new TextView(view.getContext());

        if(mainUser.homeTown==null||mainUser.homeTown=="")
        {
            cityNameTv.setText("Type your city in preference");
        }
        else {
            cityNameTv.setText(mainUser.homeTown);
        }

        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(10, 0, 0, 0);
        cityNameTv.setLayoutParams(llp);
        cityLinearLayout.addView(cityNameTv);

        LinearLayout friendsLinearLayout = (LinearLayout) view.findViewById(R.id.MyFriendsLayout);
        TextView friendsCountTv = new TextView(view.getContext());
        if(mainUser.subscribeToUsers==null)
        {
            friendsCountTv.setText("0");
        }
        else {
            friendsCountTv.setText(" " + mainUser.subscribeToUsers.size());
        }
        friendsCountTv.setLayoutParams(llp);
        friendsLinearLayout.addView(friendsCountTv);

        LinearLayout statusLinearLayout = (LinearLayout) view.findViewById(R.id.MyStatusLayout);
        statusTv = new TextView(view.getContext());
        if(mainUser.status==null||mainUser.status=="")
        {
            statusTv.setText("Оберіть ваш статус");
        }
        else {
            statusTv.setText(mainUser.status);
        }
        statusTv.setTextColor(getResources().getColor(R.color.dodgerblue));
        statusTv.setLayoutParams(llp);
        statusLinearLayout.addView(statusTv);
    }

    public void setAddReviewListener()
    {
        Button button = (Button) view.findViewById(R.id.MainAddReview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddReviewActivity.class);
                startActivity(intent);
            }
        });
    }
    public void setShowReviewsListener()
    {
        TextView listSerialsTextView = (TextView) view.findViewById(R.id.MyReviews);
        listSerialsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("userId", mainUser.id.toString());
                reviews.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, reviews).addToBackStack(null).commit();

            }
        });
    }
}
