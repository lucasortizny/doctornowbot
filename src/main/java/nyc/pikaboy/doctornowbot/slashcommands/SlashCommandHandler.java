package nyc.pikaboy.doctornowbot.slashcommands;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlashCommandHandler {
    private final JDA jda;
    private final ScheduleAnEventCommandProcessor eventScheduleProcessor;

    public void slashCommandEntryPoint(SlashCommandInteractionEvent event) {
        eventScheduleProcessor.execute(event);
    }
}
