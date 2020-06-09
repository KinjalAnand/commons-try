package com.argildx.demo.core.services;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import java.util.SortedSet;
import java.util.TreeSet;

@Component(immediate = true, service= TestDepartmentService.class)
@Designate(ocd = TestDepartmentServiceImpl.departmentInfoConfig.class)
public class TestDepartmentServiceImpl implements TestDepartmentService {

//    String departmentName;
//    String[] facultyNames;
    SortedSet<DepartmentData> departmentData= new TreeSet<>((o1, o2) -> o1.compare(o1, o2));


    @Override
    public SortedSet<DepartmentData> getDepartmentData() {
        return departmentData;
    }


    @Activate
    @Modified
    protected void modified(departmentInfoConfig config)
    {
//        this.departmentName= config.departmentName();
//        this.facultyNames= config.facultyNames();
        DepartmentData data= new DepartmentData();
        data.setDepartmentName(config.departmentName());
        data.setFacultyNames(config.facultyNames());
        departmentData.add(data);
    }


    @ObjectClassDefinition(name = "Department-Info-Configuration")
    public @interface departmentInfoConfig
    {
        @AttributeDefinition(name= "Department Name")
        String departmentName();
        @AttributeDefinition(name= "Faculty Names")
        String[] facultyNames();
    }

}