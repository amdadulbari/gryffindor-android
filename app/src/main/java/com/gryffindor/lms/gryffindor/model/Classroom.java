package com.gryffindor.lms.gryffindor.model;

public class Classroom {
    private String classUserName;
    private String classInvitationCode;
    private String name;
    private String details;
    private String creatorName;

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getClassUserName() {
        return classUserName;
    }

    public void setClassUserName(String classUserName) {
        this.classUserName = classUserName;
    }

    public String getClassInvitationCode() {
        return classInvitationCode;
    }

    public void setClassInvitationCode(String classInvitationCode) {
        this.classInvitationCode = classInvitationCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
