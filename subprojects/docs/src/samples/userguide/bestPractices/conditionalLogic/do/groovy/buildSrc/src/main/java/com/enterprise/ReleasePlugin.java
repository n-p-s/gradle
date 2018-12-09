package com.enterprise;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

public class ReleasePlugin implements Plugin<Project> {
    private static final String RELEASE_ENG_ROLE_PROP = "releaseEngineer";
    private static final String RELEASE_TASK_NAME = "release";

    @Override
    public void apply(Project project) {
        if (project.findProperty(RELEASE_ENG_ROLE_PROP) != null) {
            TaskProvider<Task> task = project.getTasks().register(RELEASE_TASK_NAME);

            task.configure(new Action<Task>() {
                @Override
                public void execute(Task task) {
                    task.doLast(new Action<Task>() {
                        @Override
                        public void execute(Task task) {
                            task.getLogger().quiet("Releasing to production...");

                            // release the artifact to production
                        }
                    });
                }
            });
        }
    }
}
