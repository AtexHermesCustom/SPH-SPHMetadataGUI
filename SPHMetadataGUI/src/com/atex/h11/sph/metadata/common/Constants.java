package com.atex.h11.sph.metadata.common;

import java.util.logging.Logger;

import com.atex.h11.sph.metadata.productivity.CustomMetadataPanel;

public interface Constants {
	//
	// Constants for logger
	//
	public static final String LOGFILE_NAME = "SPHCustomMetadata.log";
	public static final String LOGGER_NAME = CustomMetadataPanel.class.getName();
	public static final Logger LOGGER = Logger.getLogger(LOGGER_NAME);
	public static final boolean STANDALONE_DEBUG = (System.getenv("DEBUG") != null && System.getenv("DEBUG").equals("1"));
	
	//
	// Common constants
	//
	public static final String SYS_HERMES_DIR_VARIABLE = "HermesDir";
	public static final String SYS_HERMES_DIR_DEFAULT = STANDALONE_DEBUG ? System.getenv(SYS_HERMES_DIR_VARIABLE) : "c:/Hermes11/";
	public static final String SYS_HERMES_DIR = System.getProperty(SYS_HERMES_DIR_VARIABLE, Constants.SYS_HERMES_DIR_DEFAULT);

	// 
	// File Path constants
	// The path is relative to the HermesDir folder, i.e. the folder containing nroom.exe
	public static final String METADATA_GUI_PATH = "custommetadata\\";
	public static final String METADATA_CONFIG_PATH = "u:\\custommetadata\\BT\\";
	public static final String KEYWORD_PATH = "c:\\Hermes11\\custommetadata\\BT\\";
	public static final String DATA_PATH = "c:\\Hermes11\\newsdata\\SPHBHT11\\user\\";
	public static final String CONF_FILE = METADATA_CONFIG_PATH + "SPHMetadata.xml";
	public static final String KEYWORD_FILE = KEYWORD_PATH + "keyword_master.txt";
	public static final String MY_KEYWORD_FILE = DATA_PATH + "keyword.txt";
	
	public static final String FALSE = "false";
	public static final String TRUE = "true";
}
