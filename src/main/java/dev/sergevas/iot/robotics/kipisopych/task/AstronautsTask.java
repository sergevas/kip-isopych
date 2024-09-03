package dev.sergevas.iot.robotics.kipisopych.task;

import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import java.util.function.Consumer;

import dev.sergevas.iot.robotics.kipisopych.dto.KipIsopychConnection;
import dev.sergevas.iot.robotics.kipisopych.dto.Astronauts;
import dev.sergevas.iot.robotics.kipisopych.service.AstronautsService;
import org.jetbrains.annotations.NotNull;

public class AstronautsTask extends Task.Backgroundable {

    private final Runnable onSuccess;
    private final Consumer<Throwable> onFail;
    private final AstronautsService astronautsService;
    private Astronauts astronauts;

    public AstronautsTask(Project project, KipIsopychConnection connection, Runnable onSuccess, Consumer<Throwable> onFail) {
        super(project, "Test connection");
        this.onSuccess = onSuccess;
        this.onFail = onFail;
        this.astronautsService = new AstronautsService(getProject(), connection);
    }

    @Override
    public void run(@NotNull ProgressIndicator indicator) {
        try {
            astronauts = astronautsService.fetchAstronauts();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public void onSuccess() {
//        TODO: implement this
//        astronauts;

    }

    @Override
    public void onThrowable(@NotNull Throwable error) {
        onFail.accept(error);
    }
}
