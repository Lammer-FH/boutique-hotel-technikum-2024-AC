package org.technikum.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.technikum.backend.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}