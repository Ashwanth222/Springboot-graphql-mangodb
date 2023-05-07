package com.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.model.Author;
import com.graphql.model.Tutorial;

import om.graphql.repository.AuthorRepository;
import om.graphql.repository.TutorialRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;

  @Autowired
  public Mutation(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
  }

  public Author createAuthor(String name, Integer age) {
    Author author = new Author();
    author.setName(name);
    author.setAge(age);

    authorRepository.save(author);

    return author;
  }

  public Tutorial createTutorial(String title, String description, Long authorId) {
    Tutorial tutorial = new Tutorial();
    tutorial.setAuthor(new Author(authorId));
    tutorial.setTitle(title);
    tutorial.setDescription(description);

    tutorialRepository.save(tutorial);

    return tutorial;
  }

  public boolean deleteTutorial(Long id) {
    tutorialRepository.deleteById(id);
    return true;
  }

//  public Tutorial updateTutorial(Long id, String title, String description)  {
//    Optional<Tutorial> optTutorial = tutorialRepository.findById(id).;
//
//    if (optTutorial.isPresent()) {
//      Tutorial tutorial = optTutorial.get();
//
//      if (title != null)
//        tutorial.setTitle(title);
//      if (description != null)
//        tutorial.setDescription(description);
//
//      tutorialRepository.save(tutorial);
//      return tutorial;
//    }
//
//   // throw new NotFoundException("Not found Tutorial to update!");
//  }

}
