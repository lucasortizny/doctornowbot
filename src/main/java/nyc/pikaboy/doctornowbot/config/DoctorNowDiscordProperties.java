package nyc.pikaboy.doctornowbot.config;

import lombok.Data;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "doctornow")
public class DoctorNowDiscordProperties {
    private String discordToken;
    private List<String> guildIds;
}
