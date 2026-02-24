package nyc.pikaboy.doctornowbot.slashcommands.processors;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.data.DataObject;

public interface SlashCommandProcessor {
    void execute(SlashCommandInteractionEvent event);
    DataObject command();

}
