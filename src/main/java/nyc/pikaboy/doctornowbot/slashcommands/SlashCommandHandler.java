package nyc.pikaboy.doctornowbot.slashcommands;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;
import nyc.pikaboy.doctornowbot.enums.SlashCommandIdentifier;
import nyc.pikaboy.doctornowbot.service.PermissionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlashCommandHandler {
    private final JDA jda;
    private final PermissionService permissionService;
    private final ScheduleAnEventCommandProcessor eventScheduleProcessor;
    private final EventManagerPromotionCommandProcessor eventManagerPromotionCommandProcessor;

    public void slashCommandEntryPoint(SlashCommandInteractionEvent event) {
        if (event.getFullCommandName().equals(SlashCommandIdentifier.SCHEDULE_EVENT.getIdentifier())){
            if (permissionService.hasPermission(event.getUser(), AdminRoleCode.EM))
                eventScheduleProcessor.execute(event);
        }
        if (event.getFullCommandName().equals(SlashCommandIdentifier.EM_GRANT.getIdentifier())){
            if (permissionService.hasPermission(event.getUser(), AdminRoleCode.ADM))
                eventManagerPromotionCommandProcessor.execute(event);
        }
    }
}
