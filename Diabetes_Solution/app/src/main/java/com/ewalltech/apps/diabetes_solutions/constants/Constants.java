package com.ewalltech.apps.diabetes_solutions.constants;
/**
 * Created by Mukama on 7/8/17.
 */
public class Constants {
    public abstract class config {
        //TODO:::: CHECKLIST>>>>
        public static final String DB_NAME = "diabetes_db";
        public static final int DB_VERSION = 1;
        public static final int TOTAL_TABLES = 2;


        /****** URL DECLARATION ******************************/
        public static final String GIT_API = "https://api.github.com";
        public static final String URL_REPOSITORIES = "/search/repositories?q=diabetes";
        public static final String URL_USERS = "/users/";

        /**************************** TABLE NAMES ****************************/

        public static final String DEVELOPERS_TABLE="github_developers";
        public static final String REPOSITORY_TABLE="github_repositories";


        //// TODO: 22/Feb/2019   DEVELOPERS - Table Columns
        public static final String USER_ID = "user_id";
        public static final String REPO_LINK = "repo_link";
        public static final String USER_LOCATION = "user_location";
        public static final String USER_IMAGE = "user_image";
        public static final String USER_NAME = "user_name";
        public static final String USER_EMAIL = "user_email";
        public static final String GIT_ID = "git_id";
        public static final String TAG = "tag";


        //// TODO: 22/Feb/2019   REPOSITORY CONTENT - Table Columns
        public static final String REPOSITORY_ID = "repo_id";
        public static final String REPOSITORY_URL = "repo_url";
        public static final String DATE_CREATED = "date_created";
        public static final String DESCRIPTION = "description";
        public static final String REPOSITORY_NAME = "repo_name";
        public static final String LAST_UPDATE = "last_update";
        public static final String REPO_SIZE = "repo_size";
        public static final String REPO_LANGUAGE = "repo_language";
        public static final String ARCHIVED = "archived";
        public static final String WATCHERS = "watchers";
        public static final String GIT_SCORE = "git_score";
        public static final String HAS_ISSUES = "has_issues";
        public static final String HAS_PROJECTS = "has_projects";
        public static final String HAS_DOWNLOADS = "has_downloads";
        public static final String DEFAULT_BRANCH = "default_branch";
        public static final String GIT_USER = "git_user";
    }
}
