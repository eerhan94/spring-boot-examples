package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Account;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends ElasticsearchRepository<Account, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"ad\": \"?0\"}}]}}")
    List<Account> getByCustomQuery(String search);

    List<Account> findByUsernameLikeOrPasswordLike(String username, String password);
}
