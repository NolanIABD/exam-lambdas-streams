package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Partie2 {

    // récupérer la ville
    Function<Trip, String> getCity = trip -> trip.city();

    // récupérer le chauffeur
    Function<Trip, String> getDriver = trip -> trip.driverId();

    public Map<String, Long> countByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getCity,
                        Collectors.counting()
                ));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getDriver,
                        Collectors.summingDouble(trip -> trip.price())
                ));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        return trips.stream()
                .collect(Collectors.groupingBy(
                        getCity,
                        Collectors.averagingDouble(trip -> trip.durationMin())
                ));
    }
}