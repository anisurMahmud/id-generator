package com.id.controller;

import com.id.model.Location;
import com.id.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping(path = "/")
    public @ResponseBody List<Location> getAllLocation() {
        return locationService.getAllLocation();
    }

    @PostMapping(path = "/add")
    public @ResponseBody Location addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }
}
