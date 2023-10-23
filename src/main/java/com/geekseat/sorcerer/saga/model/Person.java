package com.geekseat.sorcerer.saga.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

    private int yearOfDeath;

    private int ageOfDeath;

    private int yearOfBirth;

    public int numberOfPeopleKilled;

    public Person(int yearOfDeath, int ageOfDeath) {
        this.yearOfDeath = yearOfDeath;
        this.ageOfDeath = ageOfDeath;
        this.yearOfBirth = -1;
        this.numberOfPeopleKilled = -1;

        if (yearOfDeath >= ageOfDeath) {
            this.yearOfBirth = yearOfDeath - ageOfDeath;
            this.numberOfPeopleKilled = deathOfYear(this.yearOfBirth);
        }
    }

    private Integer deathOfYear(int year) {
        int count = 0;
        int num = 1, step = 1;
        for (int i = 1; i <= year; i++) {
            count += num;
            int next = num + step;
            num = step;
            step = next;
        }
        if (count < 0) {
            count = -1;
        }
        return count;
    }
}
