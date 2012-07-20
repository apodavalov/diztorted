package models;

/**
 * This class provides methods to display site's novelties.
 * "Noveltiable" object should implement this interface
 * @author Anton Podavalov (a.podavalov@gmail.com)
 */
public interface Noveltiable {
	/**
	 * Gets string contains the object name  
	 * @return object name
	 */
	String getName();
}
