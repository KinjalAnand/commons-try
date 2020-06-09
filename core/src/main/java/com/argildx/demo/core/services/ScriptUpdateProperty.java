package com.argildx.demo.core.services;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;

import javax.jcr.Node;

public class ScriptUpdateProperty extends OnDeployScriptBase implements OnDeployScript {
    @Override
    protected void execute() throws Exception {
        Node nodeUpdate = getOrCreateNode("content/we-retail/us/en/onDeployePage/jcr:content","cq:Page','cq:PageContent");
        nodeUpdate.setProperty("sling:resourceType","weretail/components/structure/page");
    }}