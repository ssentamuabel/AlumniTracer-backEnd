package org.pahappa.systems.alumniTracer.frontend.api.models;

import org.json.JSONException;
import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;

public class ApiUtils {

    public static final String SUCCESSFUL_TOKEN = "200";
    public static final String FAILURE_TOKEN = "400";
    public static final String STATUS_PARAM = "status";
    public static final String RESPONSE_PARAM = "message";
    public static final String SUCCESSFUL_RESPONSE_VALUE = "";
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("E, dd MMM yyyy");
    public static final SimpleDateFormat ENGLISH_DATE_FORMAT = new SimpleDateFormat("E, dd MMM yyyy");

    public static Response composeSuccessMessage(String successMessage) throws JSONException {
        JSONObject result = new JSONObject();
        result.put(ApiUtils.STATUS_PARAM, ApiUtils.SUCCESSFUL_TOKEN);
        result.put(ApiUtils.RESPONSE_PARAM, successMessage);

        return Response.status(200).entity("" + result).build();
    }

    public static Response composeFailureMessage(String errorMessage) throws JSONException {
        JSONObject result = new JSONObject();
        result.put(ApiUtils.STATUS_PARAM, ApiUtils.FAILURE_TOKEN);
        result.put(ApiUtils.RESPONSE_PARAM, errorMessage);

        return Response.status(400).entity("" + result).build();
    }

    public static Response composeFailureMessage(String errorMessage, int statusCode) throws JSONException {
        JSONObject result = new JSONObject();
        result.put(ApiUtils.STATUS_PARAM, statusCode);
        result.put(ApiUtils.RESPONSE_PARAM, errorMessage);

        return Response.status(statusCode).entity("" + result).build();
    }

}
