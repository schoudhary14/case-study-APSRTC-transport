package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.repository.BusRepository;
import com.apsrtc.busmanagement.repository.BusRouteMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusRouteMappingRepository busRouteMappingRepository;

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public Bus getBusById(Long busId) {
        return busRepository.findById(busId).orElse(null);
    }

    public void addBus(Bus bus) {
        busRepository.save(bus);
    }

    public String updateBus(Long busId, Bus updatedBus) {
        Bus existingBus = busRepository.findById(busId).orElse(null);
        if (existingBus != null) {
            // Update fields as needed
            existingBus.setBusRegNumber(updatedBus.getBusRegNumber());
            existingBus.setBusType(updatedBus.getBusType());
            // Update other fields

            busRepository.save(existingBus);
            return "updated";
        } else {
            return "not found";
        }
    }

    public void deleteBus(Long busId) {
        busRepository.deleteById(busId);
    }
}