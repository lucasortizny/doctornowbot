package nyc.pikaboy.doctornowbot.repository.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admins")
public class AdministratorEntity {
    @Id
    @Column(name = "user_id")
    private String userIdentifier;
    @Column(name = "usernm_rec")
    private String username;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private AdminRoleCode adminRoleCode;
}
