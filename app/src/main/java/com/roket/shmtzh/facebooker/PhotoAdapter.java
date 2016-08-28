package com.roket.shmtzh.facebooker;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by shmtzh on 8/28/16.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private List<FacebookPhotoModel> contentList;
    private Context context;

    public PhotoAdapter(List<FacebookPhotoModel> android, Context context) {
        this.contentList = android;
        this.context = context;
    }

    @Override
    public PhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.matrix_element, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PhotoAdapter.ViewHolder viewHolder, int i) {
        Picasso.with(context).load("https://graph.facebook.com/" + contentList.get(i).getId() + "/picture?type=normal").resize(50,50).into(viewHolder.element);
        Log.d("TAG", "onBindViewHolder: " + "http://graph.facebook.com/" + contentList.get(i).getId() + "/picture?type=normal");
    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView element;

        public ViewHolder(View view) {
            super(view);
            element = (ImageView) view.findViewById(R.id.matrix_item);
        }

        public ImageView getView() {
            return element;
        }
    }

}
