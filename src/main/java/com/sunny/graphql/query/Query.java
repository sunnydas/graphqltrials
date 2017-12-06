package com.sunny.graphql.query;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.sunny.graphql.data.Link;
import com.sunny.graphql.data.repository.LinkRepository;

import java.util.List;

/**
 * Created by sundas on 12/6/2017.
 */
public class Query implements GraphQLRootResolver {

  private final LinkRepository linkRepository;

  public Query(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  public List<Link> allLinks() {
    return linkRepository.getAllLinks();
  }

}
