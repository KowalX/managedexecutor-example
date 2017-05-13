package pl.raszkowski.examples;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("executor")
public class ManagedExecutorResource {

    private static final Logger LOG = LoggerFactory.getLogger(ManagedExecutorResource.class);

    @Resource
    private ManagedExecutorService managedExecutorService;

    @Inject
    private Instance<ExampleTask> exampleTaskInstance;

    @GET
    @Path("run")
    @Produces(MediaType.TEXT_PLAIN)
    public String run() {
        for (int i = 0; i < 10; i++) {
            ExampleTask exampleTask = exampleTaskInstance.get();

            LOG.info("Creating task = {}.", i);

            managedExecutorService.submit(exampleTask);
        }

        return "Started tasks.";
    }
}
