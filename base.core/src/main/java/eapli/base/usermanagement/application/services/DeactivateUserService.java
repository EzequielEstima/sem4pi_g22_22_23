package eapli.base.usermanagement.application.services;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.representations.dto.GeneralDTO;

public class DeactivateUserService {

    public boolean deactivateUser(GeneralDTO systemUserDTO){
        UserManagementService userSvc = AuthzRegistry.userService();
        SystemUser systemUser;
        systemUser = userSvc.userOfIdentity(Username.valueOf((String) systemUserDTO.get("username"))).get();
        userSvc.deactivateUser(systemUser);
        return true;
    }

}
