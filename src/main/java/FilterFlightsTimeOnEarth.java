import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightsTimeOnEarth implements FlightFilter{

    int hour;

    public FilterFlightsTimeOnEarth(int hour) {

        this.hour=hour;
    }
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {


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
    }

