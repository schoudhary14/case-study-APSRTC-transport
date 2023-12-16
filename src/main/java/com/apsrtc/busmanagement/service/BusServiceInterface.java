package com.apsrtc.busmanagement.service;

import com.apsrtc.busmanagement.model.Bus;

import java.util.List;

public interface BusServiceInterface {

    List<Bus> getAllBuses();
    Bus getBusById(Long busId);
    void addBus(Bus bus);
    String updateBus(Long busId, Bus updatedBus);
    void deleteBus(Long busId);
}
