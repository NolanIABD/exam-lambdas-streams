import exo.Partie1;
import exo.Partie2;
import exo.Partie3;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {

    // pour tester mets petit volume
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 p1 = new Partie1();
    Partie2 p2 = new Partie2();
    Partie3 p3 = new Partie3();

    // Partie 1
    System.out.println("Long & expensive: " + p1.longAndExpensiveTrips(trips));
    System.out.println("Bad trips: " + p1.badTrips(trips));
    System.out.println("Recent trips: " + p1.recentTrips(trips));

    //  Partie 2
    System.out.println("Count by city: " + p2.countByCity(trips));
    System.out.println("Revenue by driver: " + p2.revenueByDriver(trips));
    System.out.println("Avg duration by city: " + p2.avgDurationByCity(trips));

    //  Partie 3
    System.out.println("Top 10 expensive: " + p3.top10ExpensiveTrips(trips));
    System.out.println("Best trip: " + p3.bestTrip(trips));
}