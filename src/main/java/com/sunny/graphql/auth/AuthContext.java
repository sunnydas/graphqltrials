package com.sunny.graphql.auth;

import com.sunny.graphql.data.User;
import graphql.servlet.GraphQLContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by sundas on 12/6/2017.
 */
public class AuthContext extends GraphQLContext {
  private final User user;

  public AuthContext(User user, Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
    super(request, response);
    this.user = user;
  }

  public User getUser() {
    return user;
  }
}
