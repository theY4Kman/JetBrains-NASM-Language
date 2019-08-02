package com.nasmlanguage.execution;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import com.nasmlanguage.NASMFileType;
import org.jetbrains.annotations.NotNull;

public class NASMRunnerConfigProducer extends RunConfigurationProducer<NASMRunConfiguration> {
    private static NASMRunnerConfigurationType configType = new NASMRunnerConfigurationType();

    protected NASMRunnerConfigProducer() {
        super(configType);
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull NASMRunConfiguration configuration,
                                                    @NotNull ConfigurationContext context,
                                                    @NotNull Ref<PsiElement> sourceElement) {

        return sourceElement.get().getContainingFile().getFileType() instanceof NASMFileType;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull NASMRunConfiguration configuration,
                                              @NotNull ConfigurationContext context) {
        return false;
    }
}
