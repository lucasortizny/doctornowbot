package nyc.pikaboy.doctornowbot.eventhandlers;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.ScheduledEventUpdateStatusEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledEventUpdateStatusEventHandler implements EventHandler<ScheduledEventUpdateStatusEvent> {
    private final JDA jda;

    @Override
    public void handle(ScheduledEventUpdateStatusEvent event) {
    }
}
