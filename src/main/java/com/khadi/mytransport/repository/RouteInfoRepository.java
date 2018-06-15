package com.khadi.mytransport.repository;

import com.khadi.mytransport.model.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteInfoRepository extends CrudRepository<Route, Long> {

}
