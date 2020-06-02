package com.redhat.services.test.util;

import org.kie.api.io.ResourceType;
import org.kie.api.task.model.Status;
import org.kie.internal.KieInternalServices;
import org.kie.internal.process.CorrelationKey;
import org.kie.internal.process.CorrelationKeyFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestWorkflowConstant {

    public static Map<String, ResourceType> resources = buildResourceList();
    public static List<String> definitions = getDefinitions();
    public static final String RUNTIME_MANAGER = "manager";

    /**
     *
     */
    public interface SAMPLE_PROCESS_DATA {
        String TASK_OWNER = "kris";
    }

    /**
     * Process URLs
     */
    public interface PROCESS_URL {
        String SAMPLE_PROCESS = "SampleProcess.bpmn";
    }

    /**
     * Process Definition IDs
     */
    public interface PROCESS_ID {
        String SAMPLE_PROCESS_ID = "SampleProcess";
    }

    /**
     * Signals to Test
     */
    public interface SIGNAL {
        String TEST_INTERRUPT = "test";
    }

    public static Map<String, ResourceType> buildResourceList() {
        resources = new HashMap<>();
        resources.put(PROCESS_URL.SAMPLE_PROCESS, ResourceType.BPMN2);
        return resources;
    }

    public static List<String> getDefinitions() {
        definitions = new ArrayList<>();
        definitions.add(PROCESS_ID.SAMPLE_PROCESS_ID);
        return definitions;
    }

    public static List<String> getActiveTaskStatuses() {
        List<String> status = new ArrayList<>();
        status.add(Status.Created.name());
        status.add(Status.InProgress.name());
        status.add(Status.Reserved.name());
        status.add(Status.Ready.name());
        return status;
    }

    public static CorrelationKey getCorrelationKey(String businessKey) {
        return getCorrelationKeyFactory().newCorrelationKey(businessKey);
    }

    public static CorrelationKeyFactory getCorrelationKeyFactory() {
        return KieInternalServices.Factory.get().newCorrelationKeyFactory();
    }

}
