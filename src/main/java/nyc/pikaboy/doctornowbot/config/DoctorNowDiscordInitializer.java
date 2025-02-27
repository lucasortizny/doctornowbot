package nyc.pikaboy.doctornowbot.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import nyc.pikaboy.doctornowbot.eventlisteners.DoctorNowMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class DoctorNowDiscordInitializer {
    private final DoctorNowDiscordProperties properties;
    private final DoctorNowMessageListener doctorNowMessageListener;
    @Bean
    @SneakyThrows
    public JDA discordBot(){
        log.debug("Creating the JDA Builder for the Bot.");
        JDA jda;
        jda = JDABuilder
                .createLight(properties.getDiscordToken())
                .addEventListeners(doctorNowMessageListener)
//                .setActivity(Activity.of(
//                        cheezlbotConfiguration.getDiscordConfiguration().getActivityType(),
//                        cheezlbotConfiguration.getDiscordConfiguration().getActivityMessage()
//                ).withState(cheezlbotConfiguration.getDiscordConfiguration().getActivityDescription()))
//                .enableIntents(
//                        GatewayIntent.MESSAGE_CONTENT,
//                        GatewayIntent.GUILD_MESSAGES,
//                        GatewayIntent.GUILD_MEMBERS,
//                        GatewayIntent.GUILD_PRESENCES
//                )
//                .enableCache(CacheFlag.ACTIVITY)
                .build().awaitReady();
//        log.debug("Registering different commands.");
//        jda.getGuildById(cheezlbotConfiguration.getGuildId())
//                .updateCommands()
//                .addCommands(slashCommandConfiguration.slashCommands())
//                .queue();
        return jda;
    }
}
