package ilia.weatherstation.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "reading")
public class Reading implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String temperature;

    @NotEmpty
    private String pressure;

    @NotEmpty
    private String timestamp;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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


    public static final class ReadingBuilder {
        private Long id;
        private @NotEmpty String temperature;
        private @NotEmpty String pressure;
        private @NotEmpty String timestamp;

        private ReadingBuilder() {
        }

        public static ReadingBuilder aReading() {
            return new ReadingBuilder();
        }

        public ReadingBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ReadingBuilder temperature(String temperature) {
            this.temperature = temperature;
            return this;
        }

        public ReadingBuilder pressure(String pressure) {
            this.pressure = pressure;
            return this;
        }

        public ReadingBuilder timestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Reading build() {
            Reading reading = new Reading();
            reading.setId(id);
            reading.setTemperature(temperature);
            reading.setPressure(pressure);
            reading.setTimestamp(timestamp);
            return reading;
        }
    }
}
