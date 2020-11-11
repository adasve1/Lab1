import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({carTest.class,volvoTest.class,saabTest.class}) //includes all tests from the class testDemo
public class testSuite {
}