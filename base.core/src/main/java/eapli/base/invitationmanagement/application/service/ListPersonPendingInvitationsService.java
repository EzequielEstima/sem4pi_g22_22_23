package eapli.base.invitationmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.invitationmanagement.dto.InvitationDTOWithIdAndMeeting;
import eapli.base.invitationmanagement.dto.InvitationDTOWithIdAndMeetingMapper;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonNameBuilder;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonNameMapper;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.usermanagement.domain.Person;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;


import java.util.ArrayList;
import java.util.List;

public class ListPersonPendingInvitationsService {
    public List<InvitationDTOWithIdAndMeeting> listPersonPendingInvitations(){
        PersonRepository perRepo = PersistenceContext.repositories().personRepository();
        InvitationRepository invRepo = PersistenceContext.repositories().invitationRepository();
        MeetingRepository metRepo = PersistenceContext.repositories().meetingRepository();

        SystemUser systemUser = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        Person person = perRepo.findPersonBySystemUser(systemUser);

        List<InvitationDTOWithIdAndMeeting> dtoList = new ArrayList<>();

        for (Invitation inv : invRepo.getPersonPendingInvitations(person)){
            dtoList.add(InvitationDTOWithIdAndMeetingMapper.toDTO(inv,metRepo.findMeetingContainingInvitation(inv).get()));
        }

        return dtoList;
    }
}
