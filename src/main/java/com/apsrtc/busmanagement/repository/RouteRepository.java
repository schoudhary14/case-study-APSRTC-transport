package com.apsrtc.busmanagement.repository;

import com.apsrtc.busmanagement.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
    // You can add custom query methods here if needed
}