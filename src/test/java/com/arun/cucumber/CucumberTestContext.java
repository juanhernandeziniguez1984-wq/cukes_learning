package com.arun.cucumber;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public enum CucumberTestContext {

    CONTEXT;

    private static final String PAYLOAD = "payload";
    private static final String REQUEST = "request";
    private static final String RESPONSE = "response";

    private final ThreadLocal<Map<String, Object>> threadLocal = ThreadLocal.withInitial(java.util.HashMap::new);

    private Map<String, Object> testContextMap() {
        return threadLocal.get();
    }

    public void set(String key, Object value) {
        testContextMap().put(key, value);
    }

    public Object get(String key) {
        return testContextMap().get(key);
    }

    public <T> T get(String key, Class<T> objectType) {
        return objectType.cast(testContextMap().get(key));
    }

    public void setPayload(Object value) {
        set(PAYLOAD, value);
    }

    public Object getPayload() {
        return get(PAYLOAD);
    }

    public <T> T getPayload(Class<T> objectType) {
        return get(PAYLOAD, objectType);
    }

    public RequestSpecification getRequest() {
        RequestSpecification requestSpecification = get(REQUEST, RequestSpecification.class);
        return (requestSpecification == null) ? io.restassured.RestAssured.given() : requestSpecification;
    }

    public void setResponse(Response response) {
        set(RESPONSE, response);
    }

    public Response getResponse() {
        return get(RESPONSE, Response.class);
    }

    public void reset() {
        testContextMap().clear();
    }
}
