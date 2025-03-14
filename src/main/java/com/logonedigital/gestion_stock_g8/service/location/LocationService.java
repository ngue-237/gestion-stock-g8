package com.logonedigital.gestion_stock_g8.service.location;

import com.logonedigital.gestion_stock_g8.dto.LocationReqDTO;
import com.logonedigital.gestion_stock_g8.dto.LocationResDTO;
import com.logonedigital.gestion_stock_g8.entities.Location;

import java.util.List;

public interface LocationService {
    void addLocation(LocationReqDTO locationReqDTO);
    LocationResDTO getLocationById(Integer locationId);
    List<LocationResDTO> getLocation();
    void updateLocation(Integer locationId, Location location);
    void deleteLocation(Integer locationId);
}
