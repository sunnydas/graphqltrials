package com.sunny.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sunny.graphql.data.Link;
import com.sunny.graphql.data.User;
import com.sunny.graphql.data.Vote;
import com.sunny.graphql.data.repository.LinkRepository;
import com.sunny.graphql.data.repository.UserRepository;

/**
 * Created by sundas on 12/6/2017.
 */
public class VoteResolver implements GraphQLResolver<Vote> {

  private final LinkRepository linkRepository;
  private final UserRepository userRepository;

  public VoteResolver(LinkRepository linkRepository, UserRepository userRepository) {
    this.linkRepository = linkRepository;
    this.userRepository = userRepository;
  }

  public User user(Vote vote) {
    return userRepository.findById(vote.getUserId());
  }

  public Link link(Vote vote) {
    return linkRepository.findById(vote.getLinkId());
  }

}
