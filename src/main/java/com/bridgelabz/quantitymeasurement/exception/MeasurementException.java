package com.bridgelabz.quantitymeasurement.exception;

public class MeasurementException extends RuntimeException {
    public enum Type {TYPE_MISMATCH}

    public Type type;
    public String message;

    public MeasurementException(Type type, String message) {
        this.type = type;
        this.message = message;
    }
}
