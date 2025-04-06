package nyc.pikaboy.doctornowbot.slashcommands;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import nyc.pikaboy.doctornowbot.enums.SlashCommandIdentifier;
import nyc.pikaboy.doctornowbot.service.PermissionService;
import nyc.pikaboy.doctornowbot.slashcommands.processors.EventManagerPromotionCommandProcessor;
import nyc.pikaboy.doctornowbot.slashcommands.processors.ScheduleAnEventCommandProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlashCommandHandler {
    private final JDA jda;
    private final PermissionService permissionService;
    private final ScheduleAnEventCommandProcessor eventScheduleProcessor;
    private final EventManagerPromotionCommandProcessor eventManagerPromotionCommandProcessor;
    //TODO: Route the commands using Routing Pattern later
    public void slashCommandEntryPoint(SlashCommandInteractionEvent event) {
        if (event.getFullCommandName().equals(SlashCommandIdentifier.SCHEDULE_EVENT.getIdentifier())){
            eventScheduleProcessor.execute(event);
        }
        if (event.getFullCommandName().equals(SlashCommandIdentifier.EM_GRANT.getIdentifier())){
            eventManagerPromotionCommandProcessor.execute(event);
        }
    }
}
