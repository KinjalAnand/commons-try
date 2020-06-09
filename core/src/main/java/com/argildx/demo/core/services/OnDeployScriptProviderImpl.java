package com.argildx.demo.core.services;

import com.adobe.acs.commons.ondeploy.OnDeployScriptProvider;
import com.adobe.acs.commons.ondeploy.scripts.OnDeployScript;
import org.osgi.service.component.annotations.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Service identifies code scripts to be executed upon deployment.
 */
@Component(immediate = true, service= OnDeployScriptProvider.class, property = { "name =service.description", "value =Developer service that identifies code scripts to execute upon deployment"})
public class OnDeployScriptProviderImpl implements OnDeployScriptProvider {
    @Override
    public List<OnDeployScript> getScripts() {
        return Arrays.asList(
                new ScriptCreateNode(),
                new ScriptNodeUpdate(),
                new publishWorkflow()
        );
    }
}