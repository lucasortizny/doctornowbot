package nyc.pikaboy.doctornowbot.repository;

import nyc.pikaboy.doctornowbot.enums.AdminRoleCode;
import nyc.pikaboy.doctornowbot.repository.models.AdministratorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AdminRepository extends JpaRepository<AdministratorEntity, String> {
    AdministratorEntity findByUserIdentifierAndAdminRoleCodeEquals(String userIdentifier, AdminRoleCode adminRoleCode);
    boolean existsAdministratorEntitiesByAdminRoleCodeInAndUserIdentifierEquals(Collection<AdminRoleCode> adminRoleCode, String userIdentifier);
}
