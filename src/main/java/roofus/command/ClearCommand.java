package roofus.command;

import roofus.Storage;
import roofus.TaskList;
import roofus.Ui;

/**
 * Represents a command action that clears the TaskList instance
 * associated with the current instance of Roofus.
 */
public class ClearCommand extends Command {

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(
            TaskList taskList, Storage storage, Ui ui) {
        taskList.clearStorage();
        ui.clearStorage();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isRunning() {
        return true;
    }
}
