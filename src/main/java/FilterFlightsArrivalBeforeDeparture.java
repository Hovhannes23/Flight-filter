import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class filter flights and return list of flights where arrival time of one segment
 *  is earlier than departure time of the next.
 */
public class FilterFlightsArrivalBeforeDeparture implements FlightFilter {

    /**
     *
     * @param flights - list of filtered flights
     * @return  filtered list of flights where arrival time of one segment
     *  *  is earlier than departure time of the next.
     */
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


