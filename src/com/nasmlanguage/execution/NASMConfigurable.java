package com.nasmlanguage.execution;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.ui.EditorTextFieldWithBrowseButton;
import com.intellij.ui.PanelWithAnchor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NASMConfigurable <T extends NASMRunConfiguration> extends SettingsEditor<T> implements PanelWithAnchor {
    private Project project;
    private JComponent anchor;
    private LabeledComponent<EditorTextFieldWithBrowseButton> sourceFile;

    public NASMConfigurable(Project project) {
        this.project = project;
    }

    @Override
    protected void resetEditorFrom(@NotNull T s) {

    }

    @Override
    protected void applyEditorTo(@NotNull T s) throws ConfigurationException {

    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        JPanel panel = new JPanel();
        initComponents(panel);
        return panel;
    }

    private void initComponents(JPanel panel) {
        sourceFile = new LabeledComponent<>();
        sourceFile.setText("Source file:");
        sourceFile.setComponent(new EditorTextFieldWithBrowseButton(project, false));

        panel.add(sourceFile);
    }

    @Override
    public JComponent getAnchor() {
        return anchor;
    }

    @Override
    public void setAnchor(@Nullable JComponent anchor) {
        this.anchor = anchor;
    }
}
