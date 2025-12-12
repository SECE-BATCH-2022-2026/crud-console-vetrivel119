package org.bm.pojo;

public class Grade {
    private Integer gradeId;
    private Integer studentId; // Reference by ID
    private Integer courseId;  // Reference by ID
    private Integer mark1;
    private Integer mark2;
    private Integer mark3;
    private Integer totalMark;
    private Integer averageMark;

    public Grade() {}

    public Grade(Integer gradeId, Integer studentId, Integer courseId,
                 Integer mark1, Integer mark2, Integer mark3) {
        this.gradeId = gradeId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        calculateMarks();
    }

    public Integer getGradeId() { return gradeId; }
    public void setGradeId(Integer gradeId) { this.gradeId = gradeId; }

    public Integer getStudentId() { return studentId; }
    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getCourseId() { return courseId; }
    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public Integer getMark1() { return mark1; }
    public void setMark1(Integer mark1) { this.mark1 = mark1; calculateMarks(); }

    public Integer getMark2() { return mark2; }
    public void setMark2(Integer mark2) { this.mark2 = mark2; calculateMarks(); }

    public Integer getMark3() { return mark3; }
    public void setMark3(Integer mark3) { this.mark3 = mark3; calculateMarks(); }

    public Integer getTotalMark() { return totalMark; }
    public Integer getAverageMark() { return averageMark; }

    // Calculate total and average
    private void calculateMarks() {
        if (mark1 != null && mark2 != null && mark3 != null) {
            this.totalMark = mark1 + mark2 + mark3;
            this.averageMark = totalMark / 3;
        }
    }
}
