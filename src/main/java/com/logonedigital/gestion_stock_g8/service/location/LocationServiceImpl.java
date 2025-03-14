package com.logonedigital.gestion_stock_g8.service.location;

import com.logonedigital.gestion_stock_g8.dto.LocationReqDTO;
import com.logonedigital.gestion_stock_g8.dto.LocationResDTO;
import com.logonedigital.gestion_stock_g8.entities.Customer;
import com.logonedigital.gestion_stock_g8.entities.Location;
import com.logonedigital.gestion_stock_g8.exception.ResourceNotFoundException;
import com.logonedigital.gestion_stock_g8.mapper.LocationMapper;
import com.logonedigital.gestion_stock_g8.repositories.CustomerRepo;
import com.logonedigital.gestion_stock_g8.repositories.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{
    private final LocationRepo locationRepo;
    private final CustomerRepo customerRepo;
    private final LocationMapper locationMapper;

    public LocationServiceImpl(LocationRepo locationRepo, CustomerRepo customerRepo, LocationMapper locationMapper) {
        this.locationRepo = locationRepo;
        this.customerRepo = customerRepo;
        this.locationMapper = locationMapper;
    }

    @Override
    public void addLocation(LocationReqDTO locationReqDTO) {
        Location location = this.locationMapper
                .getLocationFromLocationReqDTO(locationReqDTO);
        location.setCreatedAt(new Date());
        location.setStatus(true);




        this.locationRepo.save(location);
    }

    @Override
    public LocationResDTO getLocationById(Integer locationId) {
        Optional<Location> location = this.locationRepo.findById(locationId);
        if(location.isEmpty())
            throw  new ResourceNotFoundException("Resource not found !");
        return this.locationMapper.getLocationResDTOFromlocation(location.get());
    }

    @Override
    public List<LocationResDTO> getLocation() {
        return this.locationRepo.findAll()
                .stream()
                .map(location->this.locationMapper.getLocationResDTOFromlocation(location))
                .toList();
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
