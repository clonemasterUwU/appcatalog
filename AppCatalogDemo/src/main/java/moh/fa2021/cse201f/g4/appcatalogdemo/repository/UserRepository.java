package moh.fa2021.cse201f.g4.appcatalogdemo.repository;

import moh.fa2021.cse201f.g4.appcatalogdemo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);


}
