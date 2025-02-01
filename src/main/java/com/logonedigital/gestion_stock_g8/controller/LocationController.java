package com.logonedigital.gestion_stock_g8.controller;

import com.logonedigital.gestion_stock_g8.entities.Location;
import com.logonedigital.gestion_stock_g8.service.location.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping(path = "api/location/add")
    public ResponseEntity<String> addLocation(@RequestBody Location location){
        this.locationService.addLocation(location);

        return ResponseEntity
                .status(201)
                .body("Created successfully !");
    }

    @GetMapping(path = "api/location/get_all")
    public ResponseEntity<List<Location>> getLocations(){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocation());
    }
    @GetMapping(path = "api/location/get_by_id/{locationId}")
    public ResponseEntity<Location> getLocation(@PathVariable Integer locationId){

        return ResponseEntity
                .status(200)
                .body(this.locationService.getLocationById(locationId));
    }

    @PutMapping(path = "api/location/update_by_id/{locationId}")
    public ResponseEntity<String> updateLocation(@PathVariable Integer locationId, @RequestBody Location location){
        this.locationService.updateLocation(locationId,location);
        return ResponseEntity
                .status(202)
                .body("Updated successfully !");
    }

    @DeleteMapping(path = "api/location/delete_by_id/{locationId}")
    public ResponseEntity<String> deleteById(@PathVariable Integer locationId){
        this.locationService.deleteLocation(locationId);
        return ResponseEntity
                .status(202)
                .body("Deleted successfully !");
    }


}
