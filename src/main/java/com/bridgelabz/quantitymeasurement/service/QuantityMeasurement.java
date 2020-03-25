package com.bridgelabz.quantitymeasurement.service;

import com.bridgelabz.quantitymeasurement.exception.MeasurementException;

public class QuantityMeasurement {

    public Unit unit;
    public double measurement;

    public QuantityMeasurement(Unit unit, double measurement) {
        this.unit = unit;
        this.measurement = measurement;
    }

    public void convertor(QuantityMeasurement... measurement) throws MeasurementException {
        if (measurement[0].unit.unitType != (measurement[1].unit.unitType)) {
            throw new MeasurementException(MeasurementException.Type.TYPE_MISMATCH);
        }
        measurement[0].measurement = (measurement[0].measurement * measurement[0].unit.unitValue);
        measurement[1].measurement = (measurement[1].measurement * measurement[1].unit.unitValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement that = (QuantityMeasurement) o;
        try {
            convertor(this, that);
        } catch (MeasurementException e) {
        }
        return Double.compare(that.measurement, measurement) == 0;
    }

    public double getAddition(QuantityMeasurement that) throws MeasurementException {
        convertor(this, that);
        return this.measurement + that.measurement;
    }
}
