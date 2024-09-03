package dev.sergevas.iot.robotics.kipisopych.service;

import com.intellij.openapi.project.Project;
import dev.sergevas.iot.robotics.kipisopych.dto.KipIsopychConnection;
import dev.sergevas.iot.robotics.kipisopych.dto.Astronauts;

public class AstronautsService {

    private Project project;
    private KipIsopychConnection connection;

    public AstronautsService(Project project, KipIsopychConnection connection) {
        this.project = project;
        this.connection = connection;
    }

    public AstronautsService() {
        super();
    }

    public Astronauts fetchAstronauts() {
        return null;
    }

}
