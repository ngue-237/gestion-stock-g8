package com.logonedigital.gestion_stock_g8.service.location;

import com.logonedigital.gestion_stock_g8.entities.Location;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.repositories.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{
    private final LocationRepo locationRepo;

    public LocationServiceImpl(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    @Override
    public void addLocation(Location location) {
        location.setCreatedAt(new Date());
        location.setStatus(true);
        this.locationRepo.save(location);
    }

    @Override
    public Location getLocationById(Integer locationId) {
        Optional<Location> location = this.locationRepo.findById(locationId);
        if(location.isEmpty())
            throw  new ResourceNotFoundException("Resource not found !");
        return location.get();
    }

    @Override
    public List<Location> getLocation() {
        return this.locationRepo.findAll();
    }

    @Override
    public void updateLocation(Integer locationId, Location location) {
        Location locationToUpdated = this.locationRepo
                .findById(locationId)
                .get();

        locationToUpdated.setTown(location.getTown());
        locationToUpdated.setStreet(location.getStreet());
        locationToUpdated.setPostalCode(location.getPostalCode());
        locationToUpdated.setUpdatedAt(new Date());
        this.locationRepo.saveAndFlush(locationToUpdated);
    }

    @Override
    public void deleteLocation(Integer locationId) {
        this.locationRepo.deleteById(locationId);
    }
}
