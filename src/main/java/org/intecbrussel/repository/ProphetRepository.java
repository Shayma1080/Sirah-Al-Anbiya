package org.intecbrussel.repository;

import org.intecbrussel.model.Prophet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProphetRepository extends JpaRepository<Prophet,Long> {


}
