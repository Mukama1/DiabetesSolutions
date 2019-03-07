package com.ewalltech.apps.diabetes_solutions.db;

import com.ewalltech.apps.diabetes_solutions.constants.Constants;

/**
 * Created by Mukama 22/02/2019
 */

public class Create_Table {
    public abstract class create {
        //todo: queries to create the table
        public static final String CREATE_DEVELOPERS =
                "CREATE TABLE " + Constants.config.DEVELOPERS_TABLE + " (" + Constants.config.USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        " " + Constants.config.REPO_LINK + " TEXT," + Constants.config.USER_LOCATION + " TEXT, " + Constants.config.USER_IMAGE + " TEXT, " +
                        " " + Constants.config.USER_NAME + " TEXT," + Constants.config.USER_EMAIL + " TEXT," + Constants.config.TAG + " TEXT," +
                        " " + Constants.config.GIT_ID + " TEXT );";

        public static final String CREATE_REPOSITORIES =
                "CREATE TABLE " + Constants.config.REPOSITORY_TABLE + " (" + Constants.config.REPOSITORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + Constants.config.REPOSITORY_URL + " TEXT," +
                        " " + Constants.config.DATE_CREATED + " TEXT, " + Constants.config.DESCRIPTION + " TEXT, " +
                        " " + Constants.config.REPOSITORY_NAME + " TEXT," + Constants.config.LAST_UPDATE + " TEXT," + Constants.config.REPO_SIZE + " TEXT," +
                        " " + Constants.config.REPO_LANGUAGE + " TEXT," + Constants.config.ARCHIVED + " TEXT, " + Constants.config.WATCHERS + " TEXT, " +
                        " " + Constants.config.GIT_SCORE + " TEXT," + Constants.config.HAS_ISSUES + " TEXT," + Constants.config.HAS_PROJECTS + " TEXT," +
                        " " + Constants.config.HAS_DOWNLOADS + " TEXT," + Constants.config.DEFAULT_BRANCH + " TEXT, " + Constants.config.GIT_USER + " TEXT );";

    }
}
