package fi.workery.front.domain;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;

import reactor.core.publisher.Mono;

public interface TaskRepository extends CosmosRepository<Task, String>{
	
}
