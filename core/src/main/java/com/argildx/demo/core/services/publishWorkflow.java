package com.argildx.demo.core.services;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.model.WorkflowModel;
import com.argildx.demo.core.servlets.TestDepartmentServlet;
import com.google.common.collect.Maps;
//import org.apache.sling.api.resource.ResourceResolver;
//import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.*;
import java.util.Map;

@Component(immediate = true, service = publishWorkflow.class)
public class publishWorkflow extends OnDeployScriptBase implements OnDeployScript {

    @Reference
    ResourceResolverFactory resolverFactory;

    @Override
    protected void execute() throws Exception {
        try {
            Map<String, Object> param = Maps.newHashMap();
            param.put(ResourceResolverFactory.SUBSERVICE,"publishWorkflow");
            ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(param);

            WorkflowSession wfSession= resourceResolver.adaptTo(WorkflowSession.class);
            assert wfSession != null;
            WorkflowModel model = wfSession.getModel("/var/workflow/models/PublishPage");
            WorkflowData wfData = wfSession.newWorkflowData("JCR_PATH", "/content/KinjalDemoProject/onDeployTest");
            wfSession.startWorkflow(model, wfData);
            resourceResolver.commit();
        }
        catch(Exception e){
            Logger logger= LoggerFactory.getLogger(TestDepartmentServlet.class);
            logger.debug("Publish Workflow service didn't run");
        }
    }
}
