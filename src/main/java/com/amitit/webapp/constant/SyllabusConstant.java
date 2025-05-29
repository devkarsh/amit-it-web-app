package com.amitit.webapp.constant;


public class SyllabusConstant {

    // Logging Messages
    public static final String LOG_ATTEMPT_ADD = "Attempting to add syllabus: {}";
    public static final String LOG_ADD_SUCCESS = "Syllabus added successfully with ID: {}";
    public static final String LOG_ERROR_SAVE = "Error saving syllabus";
    public static final String LOG_ATTEMPT_RETRIEVE = "Attempting to retrieve syllabus with ID: {}";
    public static final String LOG_RETRIEVE_SUCCESS = "Syllabus found with ID {}: {}";
    public static final String LOG_NOT_FOUND = "Syllabus with ID {} not found";
    public static final String LOG_ATTEMPT_DELETE = "Attempting to delete syllabus with ID: {}";
    public static final String LOG_DELETE_SUCCESS = "Syllabus with ID {} deleted successfully";
    public static final String LOG_ERROR_DELETE = "Error deleting syllabus with ID {}";
    public static final String LOG_DELETE_NON_EXISTENT = "Attempted to delete non-existent syllabus with ID {}";
    public static final String LOG_ERROR_RETRIEVE = "Error occurred while retrieving syllabus with ID: {}: {}"; 

    // Exception Messages
    public static final String ERROR_SAVE_SYLLABUS = "Failed to save syllabus";
    public static final String ERROR_SYLLABUS_NOT_FOUND = "Syllabus with ID {} not found";
    public static final String ERROR_DELETE_SYLLABUS = "An error occurred while deleting the syllabus";
    public static final String ERROR_RETRIEVE_SYLLABUS = "Failed to retrieve syllabus.";

}