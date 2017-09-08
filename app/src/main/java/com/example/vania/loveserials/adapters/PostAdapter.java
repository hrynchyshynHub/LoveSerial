package com.example.vania.loveserials.adapters;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vania.loveserials.R;
import com.example.vania.loveserials.fragments.MainFragment;
import com.example.vania.loveserials.models.MainUser;
import com.example.vania.loveserials.models.Post;
import com.example.vania.loveserials.models.Serial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by naliv on 12.08.2017.
 */

public class PostAdapter extends RecyclerView.Adapter<PostRecyclerViewHolder>{
    private List<Post> postList = new ArrayList<>();

    public void add(Post post)
    {
        postList.add(post);
        notifyDataSetChanged();
    }
    public void addAll(List<Post> posts)
    {
        postList.addAll(posts);
        notifyDataSetChanged();
    }
    @Override
    public PostRecyclerViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);

        return new PostRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostRecyclerViewHolder holder, int position) {

        holder.bind(postList.get(position));
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}

class PostRecyclerViewHolder extends RecyclerView.ViewHolder
{
    TextView postAuthorName;
    TextView time;
    TextView text;
    ImageView postImage;
    ImageView imageToPost;

    public PostRecyclerViewHolder(View itemView) {
        super(itemView);
        postImage = (ImageView) itemView.findViewById(R.id.postImage);
        text = (TextView) itemView.findViewById(R.id.postText);
        time = (TextView) itemView.findViewById(R.id.postTime);
        postAuthorName = (TextView) itemView.findViewById(R.id.postAuthor);
        imageToPost = (ImageView) itemView.findViewById(R.id.ImageToPost);
    }
    public void bind(Post postModel)
    {
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
}


