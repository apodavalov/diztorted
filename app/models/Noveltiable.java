/*
 *  The Diztorted Dimension. Internet portal about underground music  
 *  Copyright (C) 2006-2012 Anton Podavalov, Valentin Dmitriev
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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
	
	/**
	 * Gets string contains the entity type 
	 * @return entity type
	 */
	String getEntityType();
}
