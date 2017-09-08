package com.example.vania.loveserials.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by naliv on 22.08.2017.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsRecyclerViewHolder>{
    private List<Object> reviewsUserList = new ArrayList<>();


    public void addAll(List<Object> reviews)
    {
        reviewsUserList.addAll(reviews);
        notifyDataSetChanged();
    }
    @Override
    public NewsRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);
        return new NewsRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsRecyclerViewHolder holder, int position) {

        if(reviewsUserList.get(position) instanceof Post)
        holder.bind((Post)reviewsUserList.get(position));
        else if(reviewsUserList.get(position) instanceof Review)
        holder.bind((Review)reviewsUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewsUserList.size();
    }
}

class NewsRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView postAuthorName;
    TextView time;
    TextView text;
    ImageView postImage;
    ImageView imageToPost;

    public NewsRecyclerViewHolder(View itemView) {
        super(itemView);
        postImage = (ImageView) itemView.findViewById(R.id.postImage);
        text = (TextView) itemView.findViewById(R.id.postText);
        time = (TextView) itemView.findViewById(R.id.postTime);
        postAuthorName = (TextView) itemView.findViewById(R.id.postAuthor);
        imageToPost = (ImageView) itemView.findViewById(R.id.ImageToPost);

    }

    public void bind(Post postModel) {
        if(postModel.user!=null) {
            postAuthorName.setText(postModel.user.fName + " " + postModel.user.lName);
            time.setText(String.valueOf(postModel.date));
            text.setText(postModel.text);
            postImage.setImageResource(postModel.user.contents.get(0));
            imageToPost.setImageResource(postModel.imgId);
        }
        else
        {
            postAuthorName.setText(postModel.serial.name);
            time.setText(String.valueOf(postModel.date));
            text.setText(postModel.text);
            postImage.setImageResource(postModel.serial.contents.get(0));
            imageToPost.setImageResource(postModel.imgId);
        }
    }

    public void bind(Review reviewModel)
    {
        postAuthorName.setText(reviewModel.user.fName + " " + reviewModel.user.lName);
        postImage.setImageResource(reviewModel.user.contents.get(0));
        time.setText(reviewModel.serial.name);
        text.setText(String.valueOf(reviewModel.rating));
        imageToPost.setImageResource(0);
    }
}

