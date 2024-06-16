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
            "SELECT b.room.id FROM Booking b WHERE " +
            "(:startDate <= b.endDate AND :endDate >= b.startDate))")
    List<Room> findAvailableRooms(@Param("startDate") LocalDate startDate,
                                  @Param("endDate") LocalDate endDate,
                                  Pageable pageable);

    @Query("SELECT DISTINCT r FROM Room r JOIN r.extras e WHERE e.name IN :extras GROUP BY r HAVING COUNT(DISTINCT e) = :numExtras")
    List<Room> findRoomsByExtras(@Param("extras") List<String> extras, @Param("numExtras") long numExtras, Pageable pageable);

    @Query("SELECT DISTINCT r FROM Room r " +
           "JOIN r.extras e " +
           "WHERE e.name IN :extras " +
           "AND r.id NOT IN (" +
           "   SELECT b.room.id FROM Booking b WHERE " +
           "   (:startDate <= b.endDate AND :endDate >= b.startDate)" +
           ") " +
           "GROUP BY r HAVING COUNT(DISTINCT e) = :numExtras")
    List<Room> findRoomsByAvailabilityAndExtras(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("extras") List<String> extras,
            @Param("numExtras") long numExtras,
            Pageable pageable);

    @Query("SELECT CASE WHEN COUNT(b) = 0 THEN TRUE ELSE FALSE END " +
           "FROM Booking b WHERE b.room.id = :roomId AND " +
           "(:startDate <= b.endDate AND :endDate >= b.startDate)")
    boolean checkRoomAvailability(
            @Param("roomId") int roomId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate);
}