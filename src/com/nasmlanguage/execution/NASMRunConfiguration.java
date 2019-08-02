package com.nasmlanguage.execution;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.ExecutionResult;
import com.intellij.execution.Executor;
import com.intellij.execution.JavaRunConfigurationExtensionManager;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.ProgramRunner;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.SettingsEditorGroup;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;

public class NASMRunConfiguration extends ModuleBasedConfiguration {
    private static final Logger logger = LogManager.getLogger(NASMRunConfiguration.class);

    public NASMRunConfiguration(String name, @NotNull RunConfigurationModule configurationModule, @NotNull ConfigurationFactory factory) {
        super(name, configurationModule, factory);
    }

    @Override
    public Collection<Module> getValidModules() {
        // XXX: does this need to be filtered for any reason?
        return Arrays.asList(ModuleManager.getInstance(getProject()).getModules());
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        SettingsEditorGroup<NASMRunConfiguration> group = new SettingsEditorGroup<>();

        group.addEditor("name", new NASMConfigurable<>(getProject()));
        JavaRunConfigurationExtensionManager.getInstance().appendEditors(this, group);
        return group;
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) throws ExecutionException {
        return new NASMRunProfileState(environment);
    }
}
