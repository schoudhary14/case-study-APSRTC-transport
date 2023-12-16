package com.apsrtc.busmanagement.repository;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusRouteMappingRepository extends JpaRepository<BusRouteMapping, Long> {
    List<BusRouteMapping> findByRouteId(Long routeId);

    List<BusRouteMapping> getBusRouteMappingsByBusAndRoute(Bus bus, Route route);

}