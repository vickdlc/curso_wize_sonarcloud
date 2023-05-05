package com.wizeline.maven.learningjava.repository;

import com.wizeline.maven.learningjava.model.BankAccountDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingAccountRepository extends MongoRepository<BankAccountDTO, Long> {
}
