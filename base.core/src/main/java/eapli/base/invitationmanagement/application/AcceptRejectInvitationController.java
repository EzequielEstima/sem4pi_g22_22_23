package eapli.base.invitationmanagement.application;

import eapli.base.invitationmanagement.application.service.AcceptRejectInvitationService;

public class AcceptRejectInvitationController {
    public boolean updateResponseStatus(Long invitationId, String newStatus){
        return new AcceptRejectInvitationService().updateResponseStatus(invitationId, newStatus);
    }
}
