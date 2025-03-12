package nyc.pikaboy.doctornowbot.eventlisteners;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.guild.scheduledevent.ScheduledEventCreateEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.ScheduledEventDeleteEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.ScheduledEventUserAddEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.ScheduledEventUserRemoveEvent;
import net.dv8tion.jda.api.events.guild.scheduledevent.update.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DoctorNowEventListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        super.onMessageReceived(event);
    }

    @Override
    public void onScheduledEventUpdateStatus(@NotNull ScheduledEventUpdateStatusEvent event) {
        super.onScheduledEventUpdateStatus(event);
    }

    @Override
    public void onScheduledEventCreate(@NotNull ScheduledEventCreateEvent event) {
        super.onScheduledEventCreate(event);
    }

    @Override
    public void onScheduledEventDelete(@NotNull ScheduledEventDeleteEvent event) {
        super.onScheduledEventDelete(event);
    }

    @Override
    public void onScheduledEventUpdateDescription(@NotNull ScheduledEventUpdateDescriptionEvent event) {
        super.onScheduledEventUpdateDescription(event);
    }

    @Override
    public void onScheduledEventUpdateEndTime(@NotNull ScheduledEventUpdateEndTimeEvent event) {
        super.onScheduledEventUpdateEndTime(event);
    }

    @Override
    public void onScheduledEventUpdateImage(@NotNull ScheduledEventUpdateImageEvent event) {
        super.onScheduledEventUpdateImage(event);
    }

    @Override
    public void onScheduledEventUpdateLocation(@NotNull ScheduledEventUpdateLocationEvent event) {
        super.onScheduledEventUpdateLocation(event);
    }

    @Override
    public void onScheduledEventUpdateName(@NotNull ScheduledEventUpdateNameEvent event) {
        super.onScheduledEventUpdateName(event);
    }

    @Override
    public void onScheduledEventUpdateStartTime(@NotNull ScheduledEventUpdateStartTimeEvent event) {
        super.onScheduledEventUpdateStartTime(event);
    }

    @Override
    public void onScheduledEventUserAdd(@NotNull ScheduledEventUserAddEvent event) {
        super.onScheduledEventUserAdd(event);
    }

    @Override
    public void onScheduledEventUserRemove(@NotNull ScheduledEventUserRemoveEvent event) {
        super.onScheduledEventUserRemove(event);
    }


}