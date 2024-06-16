package org.technikum.backend.repository;

import org.technikum.backend.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (" +
           "SELECT b.roomId FROM Booking b WHERE " +
           "(:startDate <= b.endDate AND :endDate >= b.startDate))")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate, 
                                  @Param("endDate") LocalDate endDate, 
                                  Pageable pageable);
}