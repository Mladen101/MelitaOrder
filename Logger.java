package org.apache.log4j;

import service.restService1.RestService;

public @interface Logger {
	Logger getLogger(Class<RestService> class1);
	

}
