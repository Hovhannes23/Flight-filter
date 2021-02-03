import java.util.ArrayList;
import java.util.List;

/**
 *  This class filter flights and return list of flights where
 *  segments amount is less than variable "segmentsCount"
 */
public class FilterFlightsSegmentsAmountLessThan implements FlightFilter {

    /**
     *  Max count of segments that can be in one flight
     */
    private int segmentsCount;

    /**
     * @return   field segmentsCount
     */
    public int getSegmentsCount() {
        return segmentsCount;
    }

    /**
     * set field segmentsCount
     */
    public void setSegmentsCount(int segmentsCount) {
        this.segmentsCount = segmentsCount;
    }

    public FilterFlightsSegmentsAmountLessThan(int segmentsCount) {
        this.segmentsCount = segmentsCount;
    }

    /**
     * @param flights - list of flights that must be filtered
     * @return list of filtered flights where amount of segments is less than "segmentsCount"
     */
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {

        List<Flight> filteredFlights = new ArrayList<>();

        for (Flight f : flights) {
            if (f.getSegments().size() < segmentsCount)
                filteredFlights.add(f);
        }

        return filteredFlights;
    }
}