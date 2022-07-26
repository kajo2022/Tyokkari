package fi.workery.front.domain;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;

import reactor.core.publisher.Mono;
@Repository
public interface SignupRepository extends CosmosRepository<Signup, String>{
	
	//Mono<Void> deleteById(String id); 
}
