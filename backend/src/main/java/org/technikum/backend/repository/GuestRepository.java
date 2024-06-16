package org.technikum.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technikum.backend.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

}