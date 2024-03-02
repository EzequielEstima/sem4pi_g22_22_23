package eapli.base.invitationmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonName;
import eapli.base.invitationmanagement.dto.InvitationDTOWithStatusAndPersonNameMapper;
import eapli.base.invitationmanagement.domain.Invitation;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.base.invitationmanagement.repositories.InvitationRepository;

import java.util.ArrayList;
import java.util.List;

public class ListAllInvitationsFromMeetingService {


    public List<InvitationDTOWithStatusAndPersonName> ListAllInvitationsFromMeeting(MeetingDTOWithIdDate meetingDTO){
        List<Invitation> listInvitation;
        List<InvitationDTOWithStatusAndPersonName> listInvitationDTO = new ArrayList<>();
        InvitationRepository invitationRepository = PersistenceContext.repositories().invitationRepository();
        listInvitation = invitationRepository.getInvitationWithIdMeeting(meetingDTO.meetingId);
        for (Invitation invitation: listInvitation) {
            listInvitationDTO.add(InvitationDTOWithStatusAndPersonNameMapper.toDTO(invitation));
        }

        return  listInvitationDTO;
    }
}
