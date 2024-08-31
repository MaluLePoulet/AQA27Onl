package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor()
@EqualsAndHashCode(exclude = "id")
public class Milestone {

    private int id;
    private String name;
    private String references;
    private String description;
    private boolean isMilestoneCompleted;

    public Milestone(String name, String references, String description, boolean isMilestoneCompleted) {
        this.name = name;
        this.references = references;
        this.description = description;
        this.isMilestoneCompleted = isMilestoneCompleted;
    }
}