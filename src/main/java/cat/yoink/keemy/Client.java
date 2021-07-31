package cat.yoink.keemy;

import cat.yoink.keemy.forge.Reference;
import cat.yoink.keemy.traits.Nameable;
import cat.yoink.keemy.traits.Startable;
import cat.yoink.keemy.traits.Stoppable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Client implements Startable, Stoppable, Nameable, Reference {
    INSTANCE;

    private final Logger logger = LogManager.getLogger("Keemy");

    @Override
    public void start() {
        logger.info("Initializing...");

        logger.info("Initialization finished");
    }

    @Override
    public void stop() {

    }

    @Override
    public String getName() {
        return "keemy.cc";
    }
}
