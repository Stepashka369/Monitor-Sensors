package com.task.monitorsensors.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "_range")
public class RangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "_from")
    private Integer from;

    @Column(name = "_to")
    private Integer to;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
