import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Flight> allFlights = FlightBuilder.createFlights();

        FlightFilter filterFlightsBeforeNow = new FilterFlightsBeforeNow();
        FlightFilter filterFlightsArrivalBeforeDeparture = new FilterFlightsArrivalBeforeDeparture();
        FlightFilter filterFlightsTimeOnEarthMore = new FilterFlightsTimeOnEarth(2);

       List<Flight> flightsBeforeNow = filterFlightsBeforeNow.filterFlights(allFlights);
       List<Flight> flightsArrivalBeforeDeparture = filterFlightsArrivalBeforeDeparture.filterFlights(allFlights);
       List<Flight> flightsTimeOnEarthMore = filterFlightsTimeOnEarthMore.filterFlights(allFlights);

        System.out.println("Flights that was till now:");
        for(Flight f:flightsBeforeNow)
            System.out.println(f);
        System.out.println("");

        System.out.println("Flights where exist segments with arrival time less than departure time:");
        for(Flight f:flightsArrivalBeforeDeparture)
            System.out.println(f);
        System.out.println("");

        System.out.println("Flights where total time on earth is more than 2 hours:");
        for(Flight f:flightsTimeOnEarthMore)
            System.out.println(f);
        System.out.println("");
    }
}
