import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class filter flights and return list of flights where
 *  date of departure is between two dates
 */

public class FilterFlightsDateOfDepartureIsBetween implements FlightFilter{

    /**
     *  date of the min time of departure
     */
    private LocalDateTime dateOfBegin;
    /**
     *  date of the max time of departure
     */
    private LocalDateTime dateOfEnd;

    /**
     * @return   field dateOfBegin
     */
    public LocalDateTime getDateOfBegin() {
        return dateOfBegin;
    }

    /**
     * set field dateOfBegin
     */
    public void setDateOfBegin(LocalDateTime dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }

    /**
     * @return  field dateOfEnd
     */
    public LocalDateTime getDateOfEnd() {
        return dateOfEnd;
    }

    /**
     * set field dateOfEnd
     */
    public void setDateOfEnd(LocalDateTime dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }

    /**
     *
     * @param dateOfBegin - date of the min time of departure
     * @param dateOfEnd - date of the max time of departure
     */
    public FilterFlightsDateOfDepartureIsBetween(LocalDateTime dateOfBegin, LocalDateTime dateOfEnd) {
        this.dateOfBegin = dateOfBegin;
        this.dateOfEnd = dateOfEnd;
    }

    /**
     *
     * @param flights list of flights that must be filtered
     * @return  list of filtered flights
     */
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {

            List<Flight> filteredFlights = new ArrayList<>();

            for (Flight f : flights) {
                if ((f.getSegments().get(0).getDepartureDate().isAfter(dateOfBegin))
                        && (f.getSegments().get(0).getDepartureDate().isBefore(dateOfEnd)))
                    filteredFlights.add(f);
            }

            return filteredFlights;
        }
    }

