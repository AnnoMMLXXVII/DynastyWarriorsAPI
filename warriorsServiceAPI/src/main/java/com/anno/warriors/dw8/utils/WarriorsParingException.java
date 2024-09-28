package com.anno.warriors.dw8.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarriorsParingException extends RuntimeException {

	private static final long serialVersionUID = 187450929866018765L;
	private static Logger logger = LogManager.getLogger();

	public WarriorsParingException(String ex) {
		logger.error("{}", ex);
	}

	public WarriorsParingException(Exception ex) {
		this(ex.getMessage());
	}

}
