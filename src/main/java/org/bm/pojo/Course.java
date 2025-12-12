package org.bm.pojo;

public class Course {
    private Integer courseId;
    private String courseName;
    private String courseCode;

    public Course() {}

    public Course(Integer courseId, String courseName, String courseCode) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCode = courseCode;
    }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCourseCode() { return courseCode; }
    public void setCourseCode(String courseCode) { this.courseCode = courseCode; }
}
