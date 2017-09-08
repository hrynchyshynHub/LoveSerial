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
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Review;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naliv on 08.09.2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter <ReviewRecyclerViewHolder>{
    private List<Review> reviewList = new ArrayList<>();

    public void add(Review review)
    {
        reviewList.add(review);
        notifyDataSetChanged();
    }
    public void addAll(List<Review> reviews)
    {
        reviewList.addAll(reviews);
        notifyDataSetChanged();
    }
    @Override
    public ReviewRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_card, parent, false);

        return new ReviewRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewRecyclerViewHolder holder, int position) {

        holder.bind(reviewList.get(position));
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }
}

class ReviewRecyclerViewHolder extends RecyclerView.ViewHolder
{
    TextView serialName;
    ImageView postImage;
    TextView rating;
    TextView reviewText;

    public ReviewRecyclerViewHolder(View itemView) {
        super(itemView);
        postImage = (ImageView) itemView.findViewById(R.id.reviewSerialImage);
        serialName = (TextView) itemView.findViewById(R.id.serialName);
        rating = (TextView) itemView.findViewById(R.id.SerialRating);
        reviewText = (TextView) itemView.findViewById(R.id.ReviewListText);
    }
    public void bind(Review reviewModel)
    {
            postImage.setImageResource(reviewModel.serial.contents.get(0));
            serialName.setText(reviewModel.serial.name);
            rating.setText(String.valueOf(reviewModel.rating));
            reviewText.setText(reviewModel.text);
    }
}
