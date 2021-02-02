import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightsBeforeNow implements FlightFilter {
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
