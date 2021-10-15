package moh.fa2021.cse201f.g4.appcatalogdemo.repository;

import moh.fa2021.cse201f.g4.appcatalogdemo.models.App;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AppRepository extends MongoRepository<App, String> {

}
