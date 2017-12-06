package com.sunny.graphql.data;

/**
 * Created by sundas on 12/6/2017.
 */
public class Link {

  public String getId() {
    return id;
  }

  private final String id; //the new field
  private final String url;
  private final String description;
  private final String userId;

  public String getUserId() {
    return userId;
  }

  public Link(String url, String description, String userId) {
    this(null, url, description, userId);
  }

  public Link(String id, String url, String description, String userId) {
    this.id = id;
    this.url = url;
    this.description = description;
    this.userId = userId;
  }

  public String getUrl() {
    return url;
  }

  public String getDescription() {
    return description;
  }

}
