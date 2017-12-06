package com.sunny.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sunny.graphql.data.Link;
import com.sunny.graphql.data.User;
import com.sunny.graphql.data.repository.UserRepository;

/**
 * Created by sundas on 12/6/2017.
 */
public class LinkResolver implements GraphQLResolver<Link> {
  private final UserRepository userRepository;

  public LinkResolver(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User postedBy(Link link) {
    if (link.getUserId() == null) {
      return null;
    }
    return userRepository.findById(link.getUserId());
  }
}
