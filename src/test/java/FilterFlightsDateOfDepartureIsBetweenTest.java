import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FilterFlightsDateOfDepartureIsBetweenTest {

    List<Flight> flights;
    LocalDateTime dateOfBegin = LocalDateTime.of(2021,1,30,12,00);
    LocalDateTime dateOfEnd = LocalDateTime.of(2021,2,5,12,00);

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

        FlightFilter flightFilter = new FilterFlightsDateOfDepartureIsBetween(dateOfBegin, dateOfEnd);

        List<Flight> actual =  flightFilter.filterFlights(flights);
        List <Flight> expected = new ArrayList<>();
        expected.add(flights.get(2));
        Assert.assertEquals(expected,actual);
    }

}