package pl.raszkowski.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleTask implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(ExampleTask.class);

    @Override
    public void run() {
        LOG.info("Running task...");
    }
}
