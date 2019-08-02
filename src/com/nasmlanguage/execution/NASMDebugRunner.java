package com.nasmlanguage.execution;

import com.intellij.debugger.impl.GenericDebuggerRunner;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NASMDebugRunner extends GenericDebuggerRunner {
    @Override
    public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
        return (
            DefaultDebugExecutor.EXECUTOR_ID.equals(executorId)
            && profile instanceof NASMRunConfiguration
        );
    }

    @Override
    protected void execute(@NotNull ExecutionEnvironment environment, @Nullable Callback callback, @NotNull RunProfileState state) throws ExecutionException {
        super.execute(environment, callback, state);
    }
}
