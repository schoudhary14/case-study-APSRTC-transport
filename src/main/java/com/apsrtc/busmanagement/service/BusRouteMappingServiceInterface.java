package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.BusRouteMapping;

import java.util.List;

public interface BusRouteMappingServiceInterface {

    List<BusRouteMapping> getAllMappings();
    List<BusRouteMapping> getMappingsForRoute(Long routeId);
    void mapBusToRoute(BusRouteMapping mapping);
    void unmapBusFromRoute(Long mappingId);

}
