package eapli.base.usermanagement.application.services;

import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.representations.dto.GeneralDTO;

import java.util.ArrayList;
import java.util.List;

public class ListUsersService {

    public Iterable<GeneralDTO> listAllUsers() {

        UserManagementService userSvc = AuthzRegistry.userService();
        Iterable<SystemUser> users = userSvc.allUsers();
        List<GeneralDTO> listUsersDTO = new ArrayList<>();
        for (SystemUser user : users) {
            listUsersDTO.add(user.toDTO());
        }
        return listUsersDTO;
    }

    public Iterable<GeneralDTO> listActiveUsers() {

        UserManagementService userSvc = AuthzRegistry.userService();
        Iterable<SystemUser> users = userSvc.activeUsers();
        List<GeneralDTO> listUsersDTO = new ArrayList<>();
        for (SystemUser user : users) {
            listUsersDTO.add(user.toDTO());
        }
        return listUsersDTO;
    }
}
