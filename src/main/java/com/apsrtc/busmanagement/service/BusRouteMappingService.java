package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.repository.BusRouteMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusRouteMappingService implements BusRouteMappingServiceInterface {

    @Autowired
    private BusRouteMappingRepository busRouteMappingRepository;

    public List<BusRouteMapping> getAllMappings() {
        return busRouteMappingRepository.findAll();
    }

    public List<BusRouteMapping> getMappingsForRoute(Long routeId) {
        return busRouteMappingRepository.findByRouteId(routeId);
    }

    public void mapBusToRoute(BusRouteMapping mapping) {
        // Add validation logic if needed (e.g., check for overlapping schedules)
        busRouteMappingRepository.save(mapping);
    }

    public void unmapBusFromRoute(Long mappingId) {
        busRouteMappingRepository.deleteById(mappingId);
    }
}