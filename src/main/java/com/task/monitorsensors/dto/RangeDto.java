package com.task.monitorsensors.dto;

import com.task.monitorsensors.validation.annotation.Range;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Range
public class RangeDto {

    @Min(0)
    @Max(Integer.MAX_VALUE)
    private Integer from;

    @Min(0)
    @Max(Integer.MAX_VALUE)
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
