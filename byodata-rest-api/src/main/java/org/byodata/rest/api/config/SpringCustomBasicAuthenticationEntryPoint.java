package org.byodata.rest.api.config;

import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

/**
 * SpringCustomBasicAuthenticationEntryPoint
 * @author Giuseppe Vincenzi
 *
 */
public class SpringCustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	public static String REALM="BYODATA_REST_API";
     
    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName(REALM);
        super.afterPropertiesSet();
    }
}
