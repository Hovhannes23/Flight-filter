import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class filter flights and return list of flights where departure time of first segment was till now
 */
public class FilterFlightsBeforeNow implements FlightFilter {

    /**
     *
     * @param flights - list of filtered flights
     * @return   filtered list of flights where departure time of first segment was till now
     */
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {

            List<Flight> filteredFlights = new ArrayList<>();

            for(Flight f:flights){
                if(f.getSegments().get(0).getDepartureDate().isBefore(LocalDateTime.now()))
                    filteredFlights.add(f);
            }

            return filteredFlights;


    }
}
