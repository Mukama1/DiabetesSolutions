package com.ewalltech.apps.diabetes_solutions.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ewalltech.apps.diabetes_solutions.R;
import com.ewalltech.apps.diabetes_solutions.db.SaveGitRepository;
import com.ewalltech.apps.diabetes_solutions.db.SaveGitUser;
import com.ewalltech.apps.diabetes_solutions.fragments.HomeFragment;
import com.ewalltech.apps.diabetes_solutions.model.Item;
import com.ewalltech.apps.diabetes_solutions.model.RepoOwner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList) {
        this.context = applicationContext;
        this.items = itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user, viewGroup, false);
        return new ViewHolder(view);

    }

    @Override

    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        RepoOwner repoDetails = items.get(i).getData();
        ////ToDo:: saving a new GitHub Diabetes Solution Developer
        new SaveGitUser(context).saveGitUser(items.get(i).getRepo_url(), items.get(i).getRepo_name(),
                items.get(i).getRepo_name(), items.get(i).getLanguage(), items.get(i).getRepo_name(),
                "" + 1, items.get(i).getRepo_name());


        ////TODO:: Saving the repository of the user in the database
        new SaveGitRepository(context).saveGitRepository(items.get(i).getRepo_url(), items.get(i).getCreated_at(), items.get(i).getDescription(), items.get(i).getRepo_name(),
                items.get(i).getUpdated_at(), items.get(i).getRepo_size(), items.get(i).getLanguage(), items.get(i).getArchived(), items.get(i).getWatchers(), items.get(i).getScore(),
                items.get(i).getHas_issues(), items.get(i).getHas_projects(), items.get(i).getHas_downloads(), items.get(i).getDefault_branch(), repoDetails.getLogin());


        viewHolder.title.setText(repoDetails.getLogin());
        viewHolder.githublink1.setText(repoDetails.getHtml_url());

        Picasso.with(context)
                .load(repoDetails.getAvatar_url())
                .placeholder(R.drawable.load)
                .into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, githublink1;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            githublink1 = view.findViewById(R.id.githublink1);
            imageView = view.findViewById(R.id.cover);

            //onitemclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION) {
                        RepoOwner repoDetails = items.get(pos).getData();
                        //Item clickedDataItem=items.get(pos);
                        Intent intent = new Intent(context, DetailActivity.class);
                        intent.putExtra("username", repoDetails.getLogin());
                        intent.putExtra("description", items.get(pos).getDescription());
                        intent.putExtra("date_created", items.get(pos).getCreated_at());
                        intent.putExtra("last_update", items.get(pos).getUpdated_at());
                        intent.putExtra("repo_url", items.get(pos).getRepo_url());
                        intent.putExtra("repo_size", items.get(pos).getRepo_size());
                        intent.putExtra("git_score", items.get(pos).getScore());
                        intent.putExtra("has_downloads", items.get(pos).getHas_downloads());
                        intent.putExtra("git_url", repoDetails.getHtml_url());
                        intent.putExtra("avatar", repoDetails.getAvatar_url());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(context, "You clicked " + repoDetails.getLogin(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}
