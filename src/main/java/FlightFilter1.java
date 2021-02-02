
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilter1 {


    public static List<Flight> filterFlightsMoreHourOnEarth(List<Flight> flights, int hour) {

        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight f : flights) {

            List<Segment> segments = f.getSegments();
            long totalTimeOnEarth = 0;
            long timeOnEarth = 0;
            LocalDateTime arrival;
            LocalDateTime departure;

            for (int i = 0; i <segments.size()-1; i++) {
                arrival = segments.get(i).getArrivalDate();
                departure = segments.get(i + 1).getArrivalDate();

                Duration duration = Duration.between(arrival, departure);
                timeOnEarth = duration.toHours();
                totalTimeOnEarth += timeOnEarth;

                if (totalTimeOnEarth > hour)
                    filteredFlights.add(f);
            }
        }
        return filteredFlights;
    }


    public static List<Flight> filterFlightsBeforeNow (List<Flight> flights){

        List<Flight> filteredFlights = new ArrayList<>();

        for(Flight f:flights){
            if(f.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()))
                filteredFlights.add(f);
        }

        return filteredFlights;
    }


    public static List<Flight> filterFlightsArrivalBeforeDeparture (List<Flight> flights){
        List<Flight> filteredFlights = new ArrayList<>();

        for(Flight  f:flights){

           List<Segment> segments = f.getSegments();

            for(int i=0;i<segments.size()-1;i++) {

                LocalDateTime arrival = segments.get(i).getArrivalDate();
                LocalDateTime departure = segments.get(i + 1).getDepartureDate();

                if (arrival.isBefore(departure)) {
                    filteredFlights.add(f);
                    break;
                }
            }
        }

        return filteredFlights;

    }
}
