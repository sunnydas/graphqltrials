package com.sunny.graphql.data.repository;

import com.mongodb.client.MongoCollection;
import com.sunny.graphql.data.Link;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by sundas on 12/6/2017.
 */
public class LinkRepository {

  private final MongoCollection<Document> links;

  public LinkRepository(MongoCollection<Document> links) {
    this.links = links;
  }

  public List<Link> getAllLinks() {
    List<Link> allLinks = new ArrayList<>();
    for (Document doc : links.find()) {
      Link link = new Link(
          doc.get("_id").toString(),
          doc.getString("url"),
          doc.getString("description"),
          doc.getString("postedBy")
      );
      allLinks.add(link);
    }
    return allLinks;
  }

  public void saveLink(Link link) {
    Document doc = new Document();
    doc.append("url", link.getUrl());
    doc.append("description", link.getDescription());
    doc.append("postedBy", link.getUserId());
    links.insertOne(doc);
  }
}
