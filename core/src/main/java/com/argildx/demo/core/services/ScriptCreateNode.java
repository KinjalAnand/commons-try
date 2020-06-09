package com.argildx.demo.core.services;


import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;
import javax.jcr.Node;


/**
 * This Script tries to get node in the absolute path of specific type, if not present creates a new node and adds property
 */
public class ScriptCreateNode extends OnDeployScriptBase  implements OnDeployScript {

    @Override
    protected void execute() throws Exception {
        Node nodeUpdate = getOrCreateNode("/content/KinjalDemoProject/onDeployTest/jcr:content", "cq:Page", "cq:PageContent");
        nodeUpdate.setProperty("sling:resourceType", "/apps/demoProject/components/structure/PageComponent");
        nodeUpdate.setProperty("cq:template", "/conf/demoProject/settings/wcm/templates/test-template");
    }
}
