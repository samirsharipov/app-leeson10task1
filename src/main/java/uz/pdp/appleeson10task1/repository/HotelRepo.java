package uz.pdp.appleeson10task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appleeson10task1.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,Integer> {
}
