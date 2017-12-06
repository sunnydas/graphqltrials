package com.sunny.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.sunny.graphql.auth.AuthContext;
import com.sunny.graphql.data.User;
import com.sunny.graphql.data.repository.LinkRepository;
import com.sunny.graphql.data.repository.UserRepository;
import com.sunny.graphql.mutation.Mutation;
import com.sunny.graphql.query.Query;
import com.sunny.graphql.resolver.LinkResolver;
import com.sunny.graphql.resolver.SigninResolver;
import graphql.schema.GraphQLSchema;
import graphql.servlet.GraphQLContext;
import graphql.servlet.SimpleGraphQLServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by sundas on 12/6/2017.
 */
@WebServlet(urlPatterns = "/helloworld/graphql")
public class HelloWorldEndPoint extends SimpleGraphQLServlet {

  private static final LinkRepository linkRepository;

  private static final UserRepository userRepository;

  static {
    MongoDatabase mongo = new MongoClient().getDatabase("sunny_graphql_trials");
    linkRepository = new LinkRepository(mongo.getCollection("links"));
    userRepository = new UserRepository(mongo.getCollection("users"));
  }

  public HelloWorldEndPoint() {
    super(buildSchema());
  }

  private static GraphQLSchema buildSchema() {
    return SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(new Query(linkRepository),new Mutation(linkRepository,userRepository),new SigninResolver(),
            new LinkResolver(userRepository))
        .build()
        .makeExecutableSchema();
  }

  @Override
  protected GraphQLContext createContext(Optional<HttpServletRequest> request, Optional<HttpServletResponse> response) {
    User user = request
        .map(req -> req.getHeader("Authorization"))
        .filter(id -> !id.isEmpty())
        .map(id -> id.replace("Bearer ", ""))
        .map(userRepository::findById)
        .orElse(null);
    return new AuthContext(user, request, response);
  }
}
