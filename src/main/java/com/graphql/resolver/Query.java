package com.graphql.resolver;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;


import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.model.Author;
import com.graphql.model.Tutorial;

import om.graphql.repository.AuthorRepository;
import om.graphql.repository.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;

  @Autowired
  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
  }

  public Iterable<Author> findAllAuthors() {
    return authorRepository.findAll();
  }

  public Iterable<Tutorial> findAllTutorials() {
    return tutorialRepository.findAll();
  }

  public long countAuthors() {
    return authorRepository.count();
  }

  public long countTutorials() {
    return tutorialRepository.count();
  }

}
