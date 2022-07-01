package uz.pdp.appleeson10task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appleeson10task1.entity.Hotel;
import uz.pdp.appleeson10task1.entity.Room;
import uz.pdp.appleeson10task1.payload.RoomDto;
import uz.pdp.appleeson10task1.repository.HotelRepo;
import uz.pdp.appleeson10task1.repository.RoomRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepo roomRepo;

    @Autowired
    HotelRepo hotelRepo;

    @PostMapping
    public String post(@RequestBody RoomDto roomDto){
        Room room = new Room();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setSize(roomDto.getSiz());
        Optional<Hotel> byId = hotelRepo.findById(roomDto.getHotelId());
        if (!byId.isPresent()) {
            return "not found Hotel";
        }
        Hotel hotel = byId.get();
        room.setHotel(hotel);
        return "saved";
    }

    @GetMapping("/{hotelId}")
    public Page<Room> getForHotel(@PathVariable Integer hotelId, @RequestParam int page){
        Pageable pageable = PageRequest.of(page,10);
        Page<Room> allBy_hotelId = roomRepo.findRoomByHotel_Id(hotelId, pageable);
        return allBy_hotelId;
    }

    @GetMapping
    public List<Room> getAll(){
        List<Room> all = roomRepo.findAll();
        return all;
    }
}
