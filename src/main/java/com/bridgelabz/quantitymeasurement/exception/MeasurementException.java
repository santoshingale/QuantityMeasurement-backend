package com.bridgelabz.quantitymeasurement.exception;

public class MeasurementException extends RuntimeException {
    public MeasurementException(Type type) {
        this.type = type;
    }

    public enum Type {TYPE_NOT_AVAILABLE, TYPE_MISMATCH}

    public Type type;
    public String message;

    public MeasurementException(Type type, String message) {
        this.type = type;
        this.message = message;
    }
}
