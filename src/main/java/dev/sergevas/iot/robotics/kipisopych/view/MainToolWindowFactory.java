package dev.sergevas.iot.robotics.kipisopych.view;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class MainToolWindowFactory implements ToolWindowFactory, DumbAware {
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        MainToolWindow myToolWindow = new MainToolWindow();
        Content content = ContentFactory.getInstance().createContent(myToolWindow.getContent(), "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
