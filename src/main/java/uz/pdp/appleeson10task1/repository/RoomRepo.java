package uz.pdp.appleeson10task1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appleeson10task1.entity.Room;

public interface RoomRepo extends JpaRepository<Room,Integer> {
    Page<Room> findRoomByHotel_Id(Integer hotel_id, Pageable pageable);
}
