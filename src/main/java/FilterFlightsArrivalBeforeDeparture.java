import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightsArrivalBeforeDeparture implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {

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


