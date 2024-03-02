package eapli.base.usermanagement.application;

import eapli.base.usermanagement.application.services.ListUsersService;
import eapli.framework.representations.dto.GeneralDTO;

public class ListActiveUsersController {

    public Iterable<GeneralDTO> listActiveUsers(){
        return new ListUsersService().listActiveUsers();
    }
}
