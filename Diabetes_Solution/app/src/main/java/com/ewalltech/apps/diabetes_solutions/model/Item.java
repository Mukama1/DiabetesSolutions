package com.ewalltech.apps.diabetes_solutions.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item {
    /*
    Some elements returned from the API are in a nested array. Therefore need for using a list
     */
    @SerializedName("owner")
    @Expose
    private RepoOwner details;

    /*
    Normal listings. No need for manipulating this
     */
    @SerializedName("url")
    @Expose
    private String repo_url;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("name")
    @Expose
    private String repo_name;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

    @SerializedName("size")
    @Expose
    private int repo_size;

    @SerializedName("language")
    @Expose
    private String language;

    @SerializedName("archived")
    @Expose
    private Boolean archived;

    @SerializedName("watchers")
    @Expose
    private int watchers;

    @SerializedName("score")
    @Expose
    private float score;

    @SerializedName("has_issues")
    @Expose
    private Boolean has_issues;

    @SerializedName("has_projects")
    @Expose
    private Boolean has_projects;

    @SerializedName("has_downloads")
    @Expose
    private Boolean has_downloads;

    @SerializedName("id")
    @Expose
    private int repo_id;

    @SerializedName("default_branch")
    @Expose
    private String default_branch;

    /*
    Setter and Getters
     */
    public RepoOwner getData() {
        return details;
    }
    public void setData(RepoOwner data) {
        this.details = data;
    }

    public String getRepo_url(){
        return repo_url;
    }

    public void setRepo_url(String repo_url) {
        this.repo_url = repo_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRepo_name() {
        return repo_name;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getRepo_size() {
        return repo_size;
    }

    public void setRepo_size(int repo_size) {
        this.repo_size = repo_size;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Boolean getHas_issues() {
        return has_issues;
    }

    public void setHas_issues(Boolean has_issues) {
        this.has_issues = has_issues;
    }

    public Boolean getHas_projects() {
        return has_projects;
    }

    public void setHas_projects(Boolean has_projects) {
        this.has_projects = has_projects;
    }

    public Boolean getHas_downloads() {
        return has_downloads;
    }

    public void setHas_downloads(Boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public int getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(int repo_id) {
        this.repo_id = repo_id;
    }

    public String getDefault_branch() {
        return default_branch;
    }

    public void setDefault_branch(String default_branch) {
        this.default_branch = default_branch;
    }
}
