package com.example.lifewaycodeassessment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Count {
    @Id
    @Column
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public Count() {

    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
