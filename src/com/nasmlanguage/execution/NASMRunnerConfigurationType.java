package com.nasmlanguage.execution;

import com.intellij.execution.configuration.ConfigurationFactoryEx;
import com.intellij.execution.configurations.*;
import com.intellij.openapi.project.Project;
import com.nasmlanguage.NASMIcons;
import org.jetbrains.annotations.NotNull;

public class NASMRunnerConfigurationType extends ConfigurationTypeBase {

    public NASMRunnerConfigurationType() {
        super("nasm", "NASM", "NASM Program", NASMIcons.ASM_FILE);

        ConfigurationFactory factory = new  ConfigurationFactoryEx(this) {

            public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
                return new NASMRunConfiguration("", new RunConfigurationModule(project), this);
            }

            @Override
            public void onNewConfigurationCreated(@NotNull RunConfiguration configuration) {
                ((ModuleBasedConfiguration)configuration).onNewConfigurationCreated();
            }
        };

        addFactory(factory);
    }
}
