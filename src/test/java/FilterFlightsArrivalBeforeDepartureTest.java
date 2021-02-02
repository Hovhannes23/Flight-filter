
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FilterFlightsArrivalBeforeDepartureTest {

    List<Flight> flights;
    @Before
    public void createFlights() {

        flights = FlightBuilder.createFlights();
        Flight flight1 = flights.get(0);
        Flight flight2 = flights.get(1);
        Flight flight3 = flights.get(2);
        Flight flight4 = flights.get(3);
        Flight flight5 = flights.get(4);
        Flight flight6 = flights.get(5);

    }

    @Test
    public void filterFlights() {

        FlightFilter flightFilter = new FilterFlightsArrivalBeforeDeparture();

        List<Flight> actual =  flightFilter.filterFlights(flights);
        List <Flight> expected = new ArrayList<>();
        expected.add(flights.get(1));
        expected.add(flights.get(4));
        expected.add(flights.get(5));
        Assert.assertEquals(expected,actual);
    }
}