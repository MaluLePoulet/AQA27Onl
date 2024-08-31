package steps;

import baseEntities.BaseStep;
import models.Milestone;
import org.openqa.selenium.WebDriver;
import pages.overview.MilestonesPage;

public class MilestoneSteps extends BaseStep {

    public MilestoneSteps(WebDriver driver) {
        super(driver);
    }

    public MilestonesPage createMilestone(Milestone milestone) {
        addMilestonePage.setNameInput(milestone.getName())
                .setReferencesInput(milestone.getReferences())
                .setDescriptionInput(milestone.getDescription())
                .setMilestoneCompletedCheckbox(milestone.isMilestoneCompleted())
                .clickAddMilestoneButton();
        return milestonesPage;
    }
}