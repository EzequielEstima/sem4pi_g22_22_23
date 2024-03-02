package eapli.base.invitationmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.domain.InvitationIdentifier;
import eapli.base.invitationmanagement.repositories.InvitationRepository;

public class AcceptRejectInvitationService {

    public boolean updateResponseStatus(Long invitationId, String newStatus){
        InvitationRepository repo = PersistenceContext.repositories().invitationRepository();
        Invitation invitation =  repo.ofIdentity(new InvitationIdentifier(invitationId)).get();
        invitation.updateResponseStatus(newStatus);
        repo.save(invitation);
        return true;
    }
}
