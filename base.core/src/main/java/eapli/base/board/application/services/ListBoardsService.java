package eapli.base.board.application.services;

import eapli.base.board.domain.Board;
import eapli.base.board.dto.BoardDTOWithTitle;
import eapli.base.board.dto.BoardDTOWithTitleMapper;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.ArrayList;
import java.util.List;

public class ListBoardsService {
    BoardRepository boardRepository = PersistenceContext.repositories().boardRepository();
    /**
     * Lists all boards owned by the user
     * @return a list of boardDTOs
     */
    public List<BoardDTOWithTitle> listBoardsIOwn(){
        SystemUser user = getSystemUser();
        List<Board> boardList = boardRepository.findAllBoardsIOwn(user);
        return getBoardDTOList(boardList);
    }
    /**
     * Lists all boards in which the user is a participant
     * @return a list of boardDTOs
     */
    public List<BoardDTOWithTitle> listBoardsIParticipate() {
        SystemUser user = getSystemUser();
        List<Board> boardList = boardRepository.findAllBoardsIParticipateWithWritePermission(user);
        return getBoardDTOList(boardList);
    }
    /**
     * Gets the authenticated user
     * @return the authenticated user
     */

    public List<BoardDTOWithTitle> listAllBoardsIParticipateAndCanRead() {
        SystemUser user = getSystemUser();
        List<Board> boardList = boardRepository.listAllBoardsIParticipateAndCanRead(user);
        return getBoardDTOList(boardList);
    }

    private SystemUser getSystemUser(){
        if (AuthzRegistry.authorizationService().session().isPresent()) {
            return AuthzRegistry.authorizationService().session().get().authenticatedUser();
        }
        throw new IllegalStateException("Session without user");
    }
    /**
     * Converts a list of boards to a list of boardDTOs
     * @param boardList the list of boards to convert
     * @return a list of boardDTOs
     */
    private List<BoardDTOWithTitle> getBoardDTOList(List<Board> boardList){
        List<BoardDTOWithTitle> boardDTOList = new ArrayList<>();
        for(Board board : boardList){
            boardDTOList.add(BoardDTOWithTitleMapper.doDTO(board));
        }
        return boardDTOList;
    }
}
