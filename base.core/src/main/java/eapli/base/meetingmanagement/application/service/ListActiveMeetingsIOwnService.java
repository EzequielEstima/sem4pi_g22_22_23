package eapli.base.meetingmanagement.application.service;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.meetingmanagement.domain.Meeting;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDate;
import eapli.base.meetingmanagement.dto.MeetingDTOWithIdDateMapper;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListActiveMeetingsIOwnService {
    public List<MeetingDTOWithIdDate> listActiveMeetingsIOwn(){
        MeetingRepository meetingRepository = PersistenceContext.repositories().meetingRepository();
        SystemUser user = AuthzRegistry.authorizationService().session().get().authenticatedUser();
        List<Meeting> meetingList = meetingRepository.findAllOwnerMeetings(user);
        List<MeetingDTOWithIdDate> meetingDTOList = new ArrayList<>();
        for(Meeting meeting : meetingList){
            meetingDTOList.add(MeetingDTOWithIdDateMapper.toDTO(meeting));
        }
        return meetingDTOList;
    }
}