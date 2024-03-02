package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.domain.Notification;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListUserNotificationsService {
    public List<String> listUserNotifications(){
        SystemUser user =  AuthzRegistry.authorizationService().session().get().authenticatedUser();
        BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
        List<Board> boardList = boardRepository.listAllBoardsIParticipateAndCanRead(user);
        List<String> notificationListString = new ArrayList<>();

        for(Board board: boardList){
            notificationListString.addAll(board.returnNotificationListString());
        }
        return notificationListString;
    }
}
