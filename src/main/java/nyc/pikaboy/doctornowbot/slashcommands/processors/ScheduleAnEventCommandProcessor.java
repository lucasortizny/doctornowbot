package nyc.pikaboy.doctornowbot.slashcommands.processors;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction;
import net.dv8tion.jda.api.utils.data.DataObject;
import nyc.pikaboy.doctornowbot.config.DoctorNowDiscordProperties;
import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;
import nyc.pikaboy.doctornowbot.enums.SlashCommandIdentifier;
import nyc.pikaboy.doctornowbot.service.PermissionService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class ScheduleAnEventCommandProcessor implements SlashCommandProcessor {
    private final JDA jda;
    private final SlashCommandIdentifier commandIdentifier = SlashCommandIdentifier.SCHEDULE_EVENT;
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
        OptionMapping eventNameSelection = event.getOption("event-name");
        OptionMapping startTimeSelection = event.getOption("start-time");
        OptionMapping endTimeSelection = event.getOption("end-time");
        OptionMapping channelSelection = event.getOption("event-channel");
        ReplyCallbackAction replyCallbackAction = event.deferReply(true);
        replyCallbackAction.queue();
        if (permissionService.hasPermissions(event.getUser(), AdminRoleCode.EM, AdminRoleCode.MOD, AdminRoleCode.ADM)) {
            if (channelSelection == null) { // VC based event
                event.getGuild()
                        .createScheduledEvent(
                                eventNameSelection.getAsString(),
                                "Discord",
                                LocalDateTime.parse(startTimeSelection.getAsString()).atZone(ZoneId.systemDefault()).toOffsetDateTime(),
                                LocalDateTime.parse(endTimeSelection.getAsString()).atZone(ZoneId.systemDefault()).toOffsetDateTime()
                        )
                        .queue();
            } else {
                event.getGuild()
                        .createScheduledEvent(
                                eventNameSelection.getAsString(),
                                channelSelection.getAsChannel().asAudioChannel(),
                                LocalDateTime.parse(startTimeSelection.getAsString()).atZone(ZoneId.systemDefault()).toOffsetDateTime()
                        )
                        .queue();
            }
            event.getInteraction().getHook().editOriginal("Event Submitted successfully.").queue();
        }
        else {
            event.getInteraction().getHook().editOriginal("You must be granted ADM, MOD, or EM access.").queue();
        }
    }

    @Override
    public DataObject command() {
        return Commands.slash(commandIdentifier.getIdentifier(), "Schedule an Event")
                .addOption(OptionType.STRING, "event-name", "Name of Event", true)
                .addOption(OptionType.STRING, "start-time", "Start Time", true)
                .addOption(OptionType.STRING, "end-time", "End Time", false)
                .addOption(OptionType.CHANNEL, "event-channel", "Event Channel", false)
                .toData();
    }
}