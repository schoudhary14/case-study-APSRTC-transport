package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.Route;
import com.apsrtc.busmanagement.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Route getRouteById(Long routeId) {
        return routeRepository.findById(routeId).orElse(null);
    }

    public void addRoute(Route route) {
        routeRepository.save(route);
    }
}
