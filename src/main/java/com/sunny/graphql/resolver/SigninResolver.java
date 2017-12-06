package com.sunny.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.sunny.graphql.data.SigninPayload;
import com.sunny.graphql.data.User;

/**
 * Created by sundas on 12/6/2017.
 */
public class SigninResolver implements GraphQLResolver<SigninPayload> {

  public User user(SigninPayload payload) {
    return payload.getUser();
  }

}
