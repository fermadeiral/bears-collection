package edu.harvard.h2ms.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.harvard.h2ms.domain.core.Answer;

@RepositoryRestResource(exported=false)
public interface AnswerRepository extends PagingAndSortingRepository<Answer, Long> {

}
