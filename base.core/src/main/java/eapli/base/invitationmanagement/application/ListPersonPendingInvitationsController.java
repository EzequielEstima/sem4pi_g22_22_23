package eapli.base.invitationmanagement.application;

import eapli.base.invitationmanagement.application.service.ListPersonPendingInvitationsService;
import eapli.base.invitationmanagement.dto.InvitationDTOWithIdAndMeeting;

import java.util.List;

public class ListPersonPendingInvitationsController {

    public List<InvitationDTOWithIdAndMeeting> listPersonPendingInvitations(){
        return new ListPersonPendingInvitationsService().listPersonPendingInvitations();
    }
}
