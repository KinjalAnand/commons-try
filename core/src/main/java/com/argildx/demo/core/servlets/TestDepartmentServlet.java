package com.argildx.demo.core.servlets;

import com.argildx.demo.core.services.DepartmentData;
import com.argildx.demo.core.services.TestDepartmentService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@Component(service = Servlet.class, immediate = true, property = {"sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=/bin/Department"})
public class TestDepartmentServlet extends SlingSafeMethodsServlet {

    @Reference
    TestDepartmentService testDepartmentService;

    Set<DepartmentData> departmentData;

    PrintWriter output;
    String dname;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        output= response.getWriter();
        //output.print("Testing 1 2 3");
        dname=request.getParameter("departmentName");
        Logger logger= LoggerFactory.getLogger(TestDepartmentServlet.class);
        logger.debug("Inside doGet method of TestDepartmentServlet");
        boolean check=false;
        departmentData= testDepartmentService.getDepartmentData();
        if(dname!=null)
        {
            for(DepartmentData data : departmentData)
            {
                if(data.getDepartmentName().equals(dname))
                {
                    output.print("Faculty Names\n\n");
                    Set<String> names = new LinkedHashSet<>(Arrays.asList(data.getFacultyNames()));
                    for(String name : names)
                    {
                        output.print(name+"\n");
                    }
                    check =true;
                    break;
                }
            }
            if(!check)
                output.print("Department does not exist");
        }
        else
            output.print("Please enter department");
    }
}
