package utils;

import com.github.javafaker.Faker;
import models.Milestone;

public class Director {

    public static Milestone getRandomMilestone() {
        Faker faker = new Faker();
        return new Milestone.Builder()
                .setName(faker.funnyName().name())
                .setReferences(faker.internet().safeEmailAddress())
                .setDescription(faker.weather().description())
                .setMilestoneCompleted(faker.bool().bool())
                .build();
    }
}