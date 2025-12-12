package org.bm.pojo;

public class Student {
    private Integer id;
    private Integer rollNo;
    private String name;
    private String emailId;
    private Integer deptId;  // Reference by ID

    public Student() {}

    public Student(Integer id, Integer rollNo, String name, String emailId, Integer deptId) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.emailId = emailId;
        this.deptId = deptId;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getRollNo() { return rollNo; }
    public void setRollNo(Integer rollNo) { this.rollNo = rollNo; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmailId() { return emailId; }
    public void setEmailId(String emailId) { this.emailId = emailId; }

    public Integer getDeptId() { return deptId; }
    public void setDeptId(Integer deptId) { this.deptId = deptId; }
}
