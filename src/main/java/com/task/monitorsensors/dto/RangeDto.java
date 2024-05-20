package com.task.monitorsensors.dto;

import com.task.monitorsensors.validation.annotation.Range;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Range
@Schema(description = "DTO for transmitting the maximum and minimum values of the measuring device")
public class RangeDto {

    @Min(0)
    @Max(Integer.MAX_VALUE)
    @Schema(description = "Minimal value of measuring device")
    private Integer from;

    @Min(0)
    @Max(Integer.MAX_VALUE)
    @Schema(description = "Maximal value of measuring device")
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
