package models;

public class Milestone {

    private String name;
    private String references;
    private String description;
    private boolean isMilestoneCompleted;

    public String getName() {
        return name;
    }

    public String getReferences() {
        return references;
    }

    public String getDescription() {
        return description;
    }

    public boolean isMilestoneCompleted() {
        return isMilestoneCompleted;
    }

    public static class Builder {
        private Milestone newMilestone;

        public Builder() {
            this.newMilestone = new Milestone();
        }

        public Builder setName(String name) {
            newMilestone.name = name;
            return this;
        }

        public Builder setReferences(String references) {
            newMilestone.references = references;
            return this;
        }

        public Builder setDescription(String description) {
            newMilestone.description = description;
            return this;
        }

        public Builder setMilestoneCompleted(boolean isMilestoneCompleted) {
            newMilestone.isMilestoneCompleted = isMilestoneCompleted;
            return this;
        }

        public Milestone build() {
            return newMilestone;
        }
    }
}
