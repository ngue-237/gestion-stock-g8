package com.logonedigital.gestion_stock_g8.service.location;

import com.logonedigital.gestion_stock_g8.entities.Location;

import java.util.List;

public interface LocationService {
    void addLocation(Location location);
    Location getLocationById(Integer locationId);
    List<Location> getLocation();
    void updateLocation(Integer locationId, Location location);
    void deleteLocation(Integer locationId);
}
