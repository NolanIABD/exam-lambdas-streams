import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import exo.Partie4;
import factory.TripFactory;
import models.Trip;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Trip> trips = TripFactory.generateTrips(50);

        Partie1 p1 = new Partie1();
        Partie2 p2 = new Partie2();
        Partie3 p3 = new Partie3();
        Partie4 p4 = new Partie4();

        System.out.println("===== PARTIE 1 =====");

        List<Trip> longTrips = p1.longAndExpensiveTrips(trips);
        System.out.println("Long & expensive trips: " + longTrips.size());

        List<Trip> badTrips = p1.badTrips(trips);
        System.out.println("Bad trips: " + badTrips.size());

        List<Trip> recentTrips = p1.recentTrips(trips);
        System.out.println("Recent trips: " + recentTrips.size());


        System.out.println("\n===== PARTIE 2 =====");

        System.out.println("Count by city:");
        System.out.println(p2.countByCity(trips));

        System.out.println("\nRevenue by driver:");
        System.out.println(p2.revenueByDriver(trips));

        System.out.println("\nAvg duration by city:");
        System.out.println(p2.avgDurationByCity(trips));


        System.out.println("\n===== PARTIE 3 =====");

        List<Trip> topTrips = p3.top10ExpensiveTrips(trips);
        System.out.println("Top 10 expensive trips:");
        topTrips.forEach(trip -> System.out.println(trip));

        System.out.println("\nBest trip:");
        System.out.println(p3.bestTrip(trips).orElse(null));


        System.out.println("\n===== PARTIE 4 =====");

        double seq = p4.totalRevenueSequential(trips);
        double par = p4.totalRevenueParallel(trips);

        System.out.println("Total revenue sequential: " + seq);
        System.out.println("Total revenue parallel:   " + par);

        System.out.println("\nCount by city (parallel):");
        System.out.println(p4.countByCityParallel(trips));

        List<Trip> premium = p4.premiumTripsParallel(trips);
        System.out.println("\nPremium trips: " + premium.size());

        // afficher juste 3 exemples max
        premium.stream().limit(3).forEach(System.out::println);
    }
}