package om.graphql.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.graphql.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, Long> {

}
