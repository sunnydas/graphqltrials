package com.sunny.graphql.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sundas on 12/7/2017.
 */
public class LinkFilter {

  private String descriptionContains;
  private String urlContains;

  @JsonProperty("description_contains") //the name must match the schema
  public String getDescriptionContains() {
    return descriptionContains;
  }

  public void setDescriptionContains(String descriptionContains) {
    this.descriptionContains = descriptionContains;
  }

  @JsonProperty("url_contains")
  public String getUrlContains() {
    return urlContains;
  }

  public void setUrlContains(String urlContains) {
    this.urlContains = urlContains;
  }

}