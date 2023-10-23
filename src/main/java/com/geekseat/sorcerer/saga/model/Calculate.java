package com.geekseat.sorcerer.saga.model;

import lombok.Getter;
import lombok.Setter;

import java.text.DecimalFormat;
import java.util.List;

@Getter
@Setter
public class Calculate {

    List<Person> persons;

    double averageNumberOfVictims;

    public Calculate(List<Person> persons) {
        this.persons = persons;
        countAverageNumberOfVictims();
    }

    private void countAverageNumberOfVictims() {
        double sum = this.persons.stream().filter(o -> o.getNumberOfPeopleKilled() > 0).mapToDouble(o -> o.numberOfPeopleKilled).sum() / this.persons.size();
        if (sum < 0) {
            this.averageNumberOfVictims = -1;
        } else {
            DecimalFormat numberFormat = new DecimalFormat("#.0");
            this.averageNumberOfVictims = Double.parseDouble(numberFormat.format(sum));
        }
    }
}
