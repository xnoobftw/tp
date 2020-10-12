package seedu.address.logic.commands.help;

import static seedu.address.commons.core.Messages.HELP_START;

import seedu.address.logic.commands.results.CommandResult;
import seedu.address.logic.commands.results.HelpCommandResult;
import seedu.address.model.inventorymodel.InventoryModel;


/**
 * Format instructions for getting started.
 */
public class HelpStartCommand extends HelpCommand {

    /**
     * Opens a pop-up window with instructions for user on how to get started.
     *
     * @param inventoryModel {@code Model} which the command should operate on.
     * @return {@code CommandResult} that describes changes made when command execute runs successfully.
     */
    @Override
    public CommandResult execute(InventoryModel inventoryModel) {
        return new HelpCommandResult(SHOWING_HELP_MESSAGE, true, false, false, "", HELP_START);
    }
}