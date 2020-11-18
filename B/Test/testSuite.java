import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({carTest.class,volvoTest.class,saabTest.class,scaniaTest.class,
carTransportTest.class,carShopTest.class}) //includes all tests from the class testDemo
public class testSuite {
}