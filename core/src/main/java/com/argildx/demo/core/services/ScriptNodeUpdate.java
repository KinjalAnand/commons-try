package com.argildx.demo.core.services;

import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScriptBase;


/**
 * This Script updates a particular node with new resource Type
 */
public class ScriptNodeUpdate extends OnDeployScriptBase  implements OnDeployScript {

    @Override
    protected void execute() throws Exception {
        updateResourceType(getOrCreateNode("/content/we-retail/ca/en/about-us/jcr:content/root/hero_image"),"weretail/components/content/image");
    }
}
