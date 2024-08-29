package models;

import java.util.Objects;

public class Project {
    private String name;
    private String announcement;
    private boolean isShowAnnouncementFlag;
    private int projectType;
    private boolean isTCApprovalsEnabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncementFlag() {
        return isShowAnnouncementFlag;
    }

    public void setShowAnnouncementFlag(boolean showAnnouncementFlag) {
        isShowAnnouncementFlag = showAnnouncementFlag;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public boolean isTCApprovalsEnabled() {
        return isTCApprovalsEnabled;
    }

    public void setEnableTCApprovals(boolean enableTCApprovals) {
        isTCApprovalsEnabled = enableTCApprovals;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", isShowAnnouncement=" + isShowAnnouncementFlag +
                ", projectType=" + projectType +
                ", isEnableTCApprovals=" + isTCApprovalsEnabled +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isShowAnnouncementFlag == project.isShowAnnouncementFlag && projectType == project.projectType && isTCApprovalsEnabled == project.isTCApprovalsEnabled && Objects.equals(name, project.name) && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, isShowAnnouncementFlag, projectType, isTCApprovalsEnabled);
    }
}