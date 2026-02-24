package nyc.pikaboy.doctornowbot.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SlashCommandIdentifier {
    SCHEDULE_EVENT("schedule-an-event"),
    TSC_GRANT("clearance-grant"),
    EM_GRANT("em-grant");
    private final String identifier;
}
