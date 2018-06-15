package com.khadi.mytransport.repository;

import com.khadi.mytransport.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    Optional<User> findByPhoneNumber(String phoneNumber);

}
