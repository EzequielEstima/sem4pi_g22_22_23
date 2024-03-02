package eapli.base.postitmanager.repositories;

import eapli.base.board.domain.Board;
import eapli.base.postitmanager.domain.PostIt;
import eapli.base.postitmanager.domain.PostItKey;
import eapli.framework.domain.repositories.DomainRepository;

public interface PostItRepository extends DomainRepository<PostItKey, PostIt> {

    PostIt getPostItInACell(Board board, Integer column, Integer row);

    PostIt getLastVersionOfPostIt(int version, long id);
}
