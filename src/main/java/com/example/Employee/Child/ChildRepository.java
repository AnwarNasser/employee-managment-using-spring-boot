package com.example.Employee.Child;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChildRepository extends CrudRepository<ChildData,Long> {
    @Query(value = "select * from child_data", nativeQuery = true)
    Optional<List<ChildData>> getAllChildData();
    // when add more than one entity
    ChildData findByChildName(String child);
    // currentUser
    List<ChildData> findByuserId(UserDetails userId);
}
