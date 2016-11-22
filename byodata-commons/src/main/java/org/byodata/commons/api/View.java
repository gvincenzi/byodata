package org.byodata.commons.api;

/**
 * View to filter contextually objects serialized to the HTTP response body. 
 * @author Giuseppe Vincenzi
 *
 */
public class View {
	public interface User {}
	public interface UserWithRoles extends User {}
}
