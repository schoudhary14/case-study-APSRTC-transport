package com.apsrtc.busmanagement.repository;

import com.apsrtc.busmanagement.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
    // You can add custom query methods here if needed
}