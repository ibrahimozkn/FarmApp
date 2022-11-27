/**
 * Interface for payments
 *
 * @author Ibrahim Ozkan
 * @version 1.0
 * @since 1.0
 *
 */
public interface Payment {
    /**
     * Gross salary of anyone who gets patment
     */
    double grossSalary = 10000;

    /**
     * Method signature which needs to be implemented in a class where uses payment interface
     *
     * @return the salary
     */
    double getSalary();
}
