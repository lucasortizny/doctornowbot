package nyc.pikaboy.doctornowbot.slashcommands.processors;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.data.DataObject;
import nyc.pikaboy.doctornowbot.config.DoctorNowDiscordProperties;
import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;
import nyc.pikaboy.doctornowbot.enums.SlashCommandIdentifier;
import nyc.pikaboy.doctornowbot.service.PermissionService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventManagerPromotionCommandProcessor implements SlashCommandProcessor {
    private final JDA jda;
    private final SlashCommandIdentifier commandIdentifier = SlashCommandIdentifier.EM_GRANT;
    private final DoctorNowDiscordProperties properties;
    private final PermissionService permissionService;

    @PostConstruct
    void init() {
        properties.getGuildIds().forEach(guild ->
                jda.getGuildById(guild).upsertCommand(CommandData.fromData(command())).queue()
        );
    }

    @Override
    public void execute(SlashCommandInteractionEvent event) {
        event.deferReply(true).queue();
        OptionMapping option = event.getOption("user");
        if (option == null) {
            event.getInteraction().getHook().editOriginal("You need to specify a user").queue();
        }
        else {
            if (permissionService.hasPermissions(event.getUser(), AdminRoleCode.ADM, AdminRoleCode.MOD)) {
                permissionService.grantPermission(option.getAsUser(), AdminRoleCode.EM);
                event.getInteraction().getHook().editOriginal("Permission Granted successfully.").queue();
            }
            else {
                event.getInteraction().getHook().editOriginal("You must be granted ADM or MOD access.").queue();
            }
        }
    }

    @Override
    public DataObject command() {
        return Commands.slash(commandIdentifier.getIdentifier(), "Grant Event Management Level Access")
                .addOption(OptionType.USER, "user", "User for EM Status", true)
                .toData();
    }
}
