package com.roket.shmtzh.facebooker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class ProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String id = getIntent().getStringExtra("token");
        new GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/" + id + "/photos",
                null,
                HttpMethod.GET,
                new GraphRequest.Callback() {
                    public void onCompleted(GraphResponse response) {
                        String object = response.getJSONObject().toString();
                        JsonParser parser = new JsonParser();
                        Gson gson = new Gson();
                        JsonElement mJson = parser.parse(object);
                        FacebookPhotosModel model = gson.fromJson(mJson, FacebookPhotosModel.class);
                        configureList(model);
                    }

                }
        ).executeAsync();
    }


    private void configureList(FacebookPhotosModel model) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);

        recyclerView.setLayoutManager(layoutManager);
        PhotoAdapter adapter = new PhotoAdapter(model.getModel(), getApplicationContext());
        recyclerView.setAdapter(adapter);

    }
}
