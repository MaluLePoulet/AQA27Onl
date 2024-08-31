package models;

import lombok.Data;

@Data
public class Project {
    private int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncementFlag;
    private int projectType;
    private boolean isTCApprovalsEnabled;
}