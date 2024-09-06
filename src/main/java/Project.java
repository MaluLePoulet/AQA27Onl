import lombok.Data;

@Data
public class Project {
    private int id = 1;
    private String name = "Project Name";
    private String announcement = "Project Announcement";
    private boolean isShowAnnouncement = true;
    private int suiteMode = 2;
    private boolean isTCApprovalsEnabled = true;
}