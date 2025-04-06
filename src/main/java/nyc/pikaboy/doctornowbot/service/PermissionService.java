package nyc.pikaboy.doctornowbot.service;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.entities.User;
import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;
import nyc.pikaboy.doctornowbot.repository.AdminRepository;
import nyc.pikaboy.doctornowbot.repository.models.AdministratorEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {
    private final AdminRepository adminRepository;

    public boolean hasPermission(User user, AdminRoleCode adminRoleCode) {
        return adminRepository.existsById(user.getId()) && adminRepository.findById(user.getId()).get().getAdminRoleCode().equals(adminRoleCode);
    }
    public boolean hasPermissions(User user, AdminRoleCode... adminRoleCodes) {
        return adminRepository.existsAdministratorEntitiesByAdminRoleCodeInAndUserIdentifierEquals(Arrays.stream(adminRoleCodes).toList(), user.getId());
    }
    public void grantPermission(User user, AdminRoleCode adminRoleCode) {
        AdministratorEntity entity = AdministratorEntity.builder()
                .userIdentifier(user.getId())
                .username(user.getName())
                .adminRoleCode(adminRoleCode)
                .build();
        adminRepository.save(entity);
    }
    public boolean hasAnyPermission(User user) {
        return adminRepository.existsById(user.getId());
    }
}
