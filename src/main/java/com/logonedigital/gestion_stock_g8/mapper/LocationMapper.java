package com.logonedigital.gestion_stock_g8.mapper;

import com.logonedigital.gestion_stock_g8.dto.LocationReqDTO;
import com.logonedigital.gestion_stock_g8.dto.LocationResDTO;
import com.logonedigital.gestion_stock_g8.entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    Location getLocationFromLocationReqDTO(LocationReqDTO locationReqDTO);
    LocationResDTO getLocationResDTOFromlocation(Location location);
}
