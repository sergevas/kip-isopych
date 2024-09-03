package dev.sergevas.iot.robotics.kipisopych.view;

import com.intellij.util.ui.JBUI;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class MainToolWindow {
    private final JPanel mainPanel;
    private final JCheckBox sendActivityCheckBox;
    private final JCheckBox checkBuildCheckBox;
    private JButton howManyAstronautsButton;
    private JButton setPomodoroButton;
    private JButton pausePomodoroButton;
    private JTextField hostnameField;
    private JTextField portField;
    private JTextField pomodoroField;
    private JTextField shortBreakField;
    private JTextField longBreakField;
    private JTextField pomodoroNumberField;

    public MainToolWindow() {
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = JBUI.insets(5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        sendActivityCheckBox = new JCheckBox("Send Activity");
        checkBuildCheckBox = new JCheckBox("Check Build");

        // Добавляем connectionPanel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(createCompactConnectionPanel(), gbc);

        // Добавляем pomodoroPanel
        gbc.gridy = 1;
        mainPanel.add(createCompactPomodoroPanel(), gbc);

        // Добавляем панель с чекбоксами
        gbc.gridy = 2;
        mainPanel.add(createWorkActivitiesPanel(), gbc);
    }

    public JPanel getContent() {
        return mainPanel;
    }

    @NotNull
    private JPanel createCompactConnectionPanel() {
        JPanel connectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        connectionPanel.setBorder(BorderFactory.createTitledBorder("Connection Params"));

        hostnameField = new JTextField(15);
        portField = new JTextField(5);
        howManyAstronautsButton = new JButton("Check Astronauts");

        connectionPanel.add(new JLabel("Host:"));
        connectionPanel.add(hostnameField);
        connectionPanel.add(new JLabel("Port:"));
        connectionPanel.add(portField);
        connectionPanel.add(howManyAstronautsButton);

        return connectionPanel;
    }

    @NotNull
    private JPanel createCompactPomodoroPanel() {
        JPanel pomodoroPanel = new JPanel(new GridBagLayout());
        pomodoroPanel.setBorder(BorderFactory.createTitledBorder("Pomodoro Timer"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = JBUI.insets(5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pomodoroPanel.add(new JLabel("Pomodoro:"), gbc);

        gbc.gridx = 1;
        pomodoroField = new JTextField(5);
        pomodoroPanel.add(pomodoroField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pomodoroPanel.add(new JLabel("Short Break:"), gbc);

        gbc.gridx = 1;
        shortBreakField = new JTextField(5);
        pomodoroPanel.add(shortBreakField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pomodoroPanel.add(new JLabel("Long Break:"), gbc);

        gbc.gridx = 1;
        longBreakField = new JTextField(5);
        pomodoroPanel.add(longBreakField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pomodoroPanel.add(new JLabel("Pomodoro No:"), gbc);

        gbc.gridx = 1;
        pomodoroNumberField = new JTextField(5);
        pomodoroPanel.add(pomodoroNumberField, gbc);

        // Добавляем кнопки Set и Pause
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        setPomodoroButton = new JButton("Set");
        pausePomodoroButton = new JButton("Pause");
        buttonPanel.add(setPomodoroButton);
        buttonPanel.add(pausePomodoroButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        pomodoroPanel.add(buttonPanel, gbc);

        return pomodoroPanel;
    }

    @NotNull
    private JPanel createWorkActivitiesPanel() {
        JPanel workActivitiesPanel = new JPanel(new GridLayout(2, 1));
        workActivitiesPanel.setBorder(BorderFactory.createTitledBorder("Work Activities"));

        workActivitiesPanel.add(checkBuildCheckBox);
        workActivitiesPanel.add(sendActivityCheckBox);

        return workActivitiesPanel;
    }

    public String getHostname() {
        return hostnameField.getText();
    }

    public String getPort() {
        return portField.getText();
    }

    public String getPomodoro() {
        return pomodoroField.getText();
    }

    public String getShortBreak() {
        return shortBreakField.getText();
    }

    public String getLongBreak() {
        return longBreakField.getText();
    }

    public String getPomodoroNumber() {
        return pomodoroNumberField.getText();
    }

    public boolean isSendActivityChecked() {
        return sendActivityCheckBox.isSelected();
    }

    public boolean isCheckBuildChecked() {
        return checkBuildCheckBox.isSelected();
    }

    public JButton getHowManySpacemenButton() {
        return howManyAstronautsButton;
    }

    public JButton getSetPomodoroButton() {
        return setPomodoroButton;
    }

    public JButton getPausePomodoroButton() {
        return pausePomodoroButton;
    }
}
