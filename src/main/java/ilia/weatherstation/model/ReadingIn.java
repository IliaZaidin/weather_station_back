package ilia.weatherstation.model;

import static ilia.weatherstation.model.Reading.ReadingBuilder.aReading;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class ReadingIn implements Serializable {

    @NotEmpty
    private String temperature;

    @NotEmpty
    private String pressure;

    @NotEmpty
    private String timestamp;
    
    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Reading toReading() {
        return aReading().temperature(temperature).pressure(pressure).timestamp(timestamp).build();
    }

    public void updateReading(Reading reading) {
        reading.setTemperature(temperature);
        reading.setPressure(pressure);
        reading.setTimestamp(timestamp);

    } 
}
