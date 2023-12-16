package com.apsrtc.busmanagement.validation;

import com.apsrtc.busmanagement.model.BusRouteMapping;
import com.apsrtc.busmanagement.repository.BusRouteMappingRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class NoOverlapValidator implements ConstraintValidator<NoOverlap, BusRouteMapping> {

    private final BusRouteMappingRepository busRouteMappingRepository;

    public NoOverlapValidator(BusRouteMappingRepository busRouteMappingRepository) {
        this.busRouteMappingRepository = busRouteMappingRepository;
    }

    @Override
    public void initialize(NoOverlap constraintAnnotation) {
    }

    @Override
    public boolean isValid(BusRouteMapping busRouteMapping, ConstraintValidatorContext context) {
        if (busRouteMapping.getStartTime() != null && busRouteMapping.getEndTime() != null) {
            List<BusRouteMapping> existingMappings =
                    busRouteMappingRepository.getBusRouteMappingsByBusAndRoute(
                            busRouteMapping.getBus(), busRouteMapping.getRoute());

            for (BusRouteMapping existingMapping : existingMappings) {
                if (doSchedulesOverlap(busRouteMapping, existingMapping)) {
                    return false; // Overlapping schedules found
                }
            }
        }
        return true; // No overlapping schedules found or start/end time not specified
    }

    private boolean doSchedulesOverlap(BusRouteMapping newMapping, BusRouteMapping existingMapping) {
        // Implement logic to check if schedules overlap
        return newMapping.getStartTime().isBefore(existingMapping.getEndTime()) &&
                newMapping.getEndTime().isAfter(existingMapping.getStartTime());
    }
}