package com.ewalltech.apps.diabetes_solutions.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.ewalltech.apps.diabetes_solutions.constants.Constants;

public class SaveGitRepository {

    private Context context;
    private static final String TAG_ = "GIT_REPOSITORIES";

    public SaveGitRepository(Context context) {
        this.context = context;
    }

    public void saveGitRepository(String repo_url, String date_created, String description, String repository_name, String last_update, int repo_size,
                                  String repo_language, Boolean archived, int watchers, float git_score, Boolean has_issues, Boolean has_projects,
                                  Boolean has_downloads, String default_branch, String git_user) {
        SQLiteDatabase database = DBHelper.getHelper(context).getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.config.REPOSITORY_URL, repo_url);
            contentValues.put(Constants.config.DATE_CREATED, date_created);
            contentValues.put(Constants.config.DESCRIPTION, description);
            contentValues.put(Constants.config.REPOSITORY_NAME, repository_name);
            contentValues.put(Constants.config.LAST_UPDATE, last_update);
            contentValues.put(Constants.config.REPO_SIZE, repo_size);
            contentValues.put(Constants.config.REPO_LANGUAGE, repo_language);
            contentValues.put(Constants.config.ARCHIVED, archived);
            contentValues.put(Constants.config.WATCHERS, watchers);
            contentValues.put(Constants.config.GIT_SCORE, git_score);
            contentValues.put(Constants.config.HAS_ISSUES, has_issues);
            contentValues.put(Constants.config.HAS_PROJECTS, has_projects);
            contentValues.put(Constants.config.HAS_DOWNLOADS, has_downloads);
            contentValues.put(Constants.config.DEFAULT_BRANCH, default_branch);
            contentValues.put(Constants.config.GIT_USER, git_user);
            database.insert(Constants.config.REPOSITORY_TABLE, null, contentValues);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //database.close();
            //database.endTransaction();
        }
    }


}
