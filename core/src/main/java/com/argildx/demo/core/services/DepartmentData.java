package com.argildx.demo.core.services;

import java.util.Comparator;

public class DepartmentData implements Comparator<DepartmentData> {
    String departmentName;
    String[] facultyNames;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String[] getFacultyNames() {
        return facultyNames;
    }

    public void setFacultyNames(String[] facultyNames) {
        this.facultyNames = facultyNames;
    }

    @Override
    public int compare(DepartmentData o1, DepartmentData o2) {
        if(o1.departmentName.equals(o2.departmentName))
            return 0;
        else
            return 1;
    }
}
