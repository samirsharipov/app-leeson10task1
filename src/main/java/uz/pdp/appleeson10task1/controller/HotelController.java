package uz.pdp.appleeson10task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appleeson10task1.entity.Hotel;
import uz.pdp.appleeson10task1.repository.HotelRepo;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepo hotelRepo;

    @GetMapping
    public List<Hotel> get(){
        List<Hotel> all = hotelRepo.findAll();
        return all;
    }

    @PostMapping
    public String post(@RequestBody Hotel hotel){
        Hotel hotel1 = new Hotel(hotel.getName());
        hotelRepo.save(hotel1);
        return "saved";
    }
}
