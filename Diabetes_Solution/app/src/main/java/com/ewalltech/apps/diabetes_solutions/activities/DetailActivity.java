package com.ewalltech.apps.diabetes_solutions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.ewalltech.apps.diabetes_solutions.R;

public class DetailActivity extends AppCompatActivity {

    TextView gitUrl_p, Username,dateCreated,repoUrl,repoSize,gitScore,hasDownloads,Description,lastUpdate;
    ImageView imageView;
    public  void onCreate(Bundle saveInstBundle){
        super.onCreate(saveInstBundle);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ////TODO:: Mapping id with the layout file
        imageView= findViewById(R.id.user_image_header);
        Username= findViewById(R.id.username);
        gitUrl_p= findViewById(R.id.git_url);
        dateCreated= findViewById(R.id.date_created);
        lastUpdate= findViewById(R.id.last_updated);
        repoUrl= findViewById(R.id.repo_url);
        repoSize= findViewById(R.id.repo_size);
        gitScore= findViewById(R.id.git_score);
        hasDownloads= findViewById(R.id.has_download);
        Description= findViewById(R.id.desc);

////TODO:: pick content from the previous Activity

        String username=getIntent().getExtras().getString("username");
        String avatarURL=getIntent().getExtras().getString("avatar");
        String description=getIntent().getExtras().getString("description");
        String date_created=getIntent().getExtras().getString("date_created");
        String last_updated=getIntent().getExtras().getString("last_updated");
        String repo_url=getIntent().getExtras().getString("repo_url");
        int repo_size=getIntent().getExtras().getInt("repo_size");
        float git_score=getIntent().getExtras().getFloat("git_score");
        Boolean has_downloads=getIntent().getExtras().getBoolean("has_downloads");
        String git_url=getIntent().getExtras().getString("git_url");

        gitUrl_p.setText(git_url);
        Linkify.addLinks(gitUrl_p,Linkify.WEB_URLS);
        Username.setText(username);
        dateCreated.setText(date_created);
        lastUpdate.setText(last_updated);
        repoUrl.setText(repo_url);
        repoSize.setText(""+repo_size+" Kilobytes");
        gitScore.setText(""+git_score);
        hasDownloads.setText(""+has_downloads);
        Description.setText(description);
        Glide.with(this)
                .load(avatarURL)
                .placeholder(R.drawable.load)
                .into(imageView);
        getSupportActionBar().setTitle("Details Activity");

    }

    private Intent createShareFocusedIntent(){
        String username = getIntent().getExtras().getString("username");
        String link = getIntent().getExtras().getString("git_url");
        Intent shareIntent= ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText("Check out this Diabetes Solutions Developer @ "+username + " , "+link)
                .getIntent();
        return shareIntent;

    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.detail,menu);
        MenuItem menuItem=menu.findItem(R.id.action_share);
        menuItem.setIntent(createShareFocusedIntent());
        return true;
    }
}
