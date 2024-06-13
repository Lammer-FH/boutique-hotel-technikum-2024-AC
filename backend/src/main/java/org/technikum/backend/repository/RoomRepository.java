package org.technikum.backend.repository;

import org.technikum.backend.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.id NOT IN (" +
           "SELECT b.room.id FROM Booking b WHERE " +
           "(:startDate BETWEEN b.startDate AND b.endDate OR " +
           ":endDate BETWEEN b.startDate AND b.endDate OR " +
           "b.startDate BETWEEN :startDate AND :endDate OR " +
           "b.endDate BETWEEN :startDate AND :endDate))")
    List<Room> findAvailableRooms(@Param("startDate") Date startDate, 
                                  @Param("endDate") Date endDate, 
                                  Pageable pageable);
}