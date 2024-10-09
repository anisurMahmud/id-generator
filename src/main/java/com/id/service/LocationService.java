package com.id.service;

import com.id.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getAllLocation();

    Location addLocation(Location location);
}
