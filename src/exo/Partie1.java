package exo;

import models.Trip;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Partie1 {

    // Lambda Exercice 1 : trajet long ET cher
    private final Predicate<Trip> isLongAndExpensive = trip ->
            trip.distanceKm() > 10 && trip.price() > 20;

    // Lambda Exercice 2 : mauvais trajet
    private final Predicate<Trip> isBadTrip = trip ->
            trip.rating() < 3;

    // Lambda Exercice 3 : trajet d'aujourd'hui ou d'hier
    private final Predicate<Trip> isRecentTrip = trip -> {
        LocalDate tripDate = trip.startTime().toLocalDate();
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        return tripDate.equals(today) || tripDate.equals(yesterday);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isLongAndExpensive)
                .toList();
    }

    public List<Trip> badTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isBadTrip)
                .toList();
    }
    public List<Trip> recentTrips(List<Trip> trips) {
        return trips.stream()
                .filter(isRecentTrip)
                .toList();
    }
}