package com.apsrtc.busmanagement.controller;

import com.apsrtc.busmanagement.model.Bus;
import com.apsrtc.busmanagement.model.BusRouteMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface BusControllerInterface {
    ResponseEntity<List<Bus>> getAllBuses();
    ResponseEntity<Bus> getBusById(@PathVariable Long busId);
    ResponseEntity<Map<String,Object>> addBus(@RequestBody Bus bus);

    ResponseEntity<Map<String,Object>> updateBus(@PathVariable Long busId, @RequestBody Bus updatedBus);
    ResponseEntity<Map<String,Object>> deleteBus(@PathVariable Long busId);

    ResponseEntity<Map<String,Object>> MapRoute(@RequestBody BusRouteMapping busRouteMapping);

}
