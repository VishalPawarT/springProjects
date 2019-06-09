package com.techames.reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.techames.reactive.model.Account;

public interface AccountMongoRepository extends ReactiveMongoRepository<Account, String> {
}
