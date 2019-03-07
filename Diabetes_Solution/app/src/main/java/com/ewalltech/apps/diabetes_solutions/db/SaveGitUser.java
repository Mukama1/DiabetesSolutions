package com.ewalltech.apps.diabetes_solutions.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import com.ewalltech.apps.diabetes_solutions.R;
import com.ewalltech.apps.diabetes_solutions.constants.Constants;
/**
 * Created by Mukama on 25/02/19.
 */

public class SaveGitUser {

    private Context context;
    private static final String TAG_ = "GIT_DEVELOPERS";

    public SaveGitUser(Context context) {
        this.context = context;
    }

    public void saveGitUser(String repo_link, String user_location, String user_image, String user_name, String user_email, String tag, String git_id) {
        SQLiteDatabase database = DBHelper.getHelper(context).getWritableDatabase();

        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.config.REPO_LINK, repo_link);
            contentValues.put(Constants.config.USER_LOCATION, user_location);
            contentValues.put(Constants.config.USER_IMAGE, user_image);
            contentValues.put(Constants.config.USER_NAME, user_name);
            contentValues.put(Constants.config.TAG, tag);
            contentValues.put(Constants.config.USER_EMAIL, user_email);
            contentValues.put(Constants.config.GIT_ID, git_id);
                        database.insert(Constants.config.DEVELOPERS_TABLE, null, contentValues);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //database.close();
            //database.endTransaction();
        }
    }


}
