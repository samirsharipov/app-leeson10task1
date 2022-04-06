package uz.pdp.appleeson10task1.payload;

import lombok.Data;

@Data
public class RoomDto {
    private Integer number;
    private Integer floor;
    private Long siz;
    private Integer hotelId;
}
