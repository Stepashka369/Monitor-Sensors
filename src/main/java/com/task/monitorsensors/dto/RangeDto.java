package com.task.monitorsensors.dto;

import jakarta.validation.constraints.Size;

public class RangeDto {

    //@Size(min = 0, max = Integer.MAX_VALUE, message = "The name size must be within the limits [0, MAX_INT]")
    private Integer from;

    //@Size(min = 0, max = Integer.MAX_VALUE, message = "The name size must be within the limits [0, MAX_INT]")
    private Integer to;

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }
}
