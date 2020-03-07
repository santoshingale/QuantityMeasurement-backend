package com.bridgelabz.quantitymeasurement.exception;

public class MesurementException extends RuntimeException {
    public enum Type {TYPE_MISMATCH}

    public Type type;

    public MesurementException(Type type) {
        this.type = type;
    }
}
