package nyc.pikaboy.doctornowbot.eventhandlers;

import net.dv8tion.jda.api.events.GenericEvent;

public interface EventHandler<E extends GenericEvent> {
    void handle(E event);
}
