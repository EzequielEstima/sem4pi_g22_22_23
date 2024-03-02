/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.infrastructure.persistence;

import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;
import eapli.base.exams.domain.ExamResolution;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    PersonRepository personRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    PersonRepository personRepository();


    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    StudentRepository studentRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    StudentRepository studentRepository();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    CourseRepository courseRepository(TransactionalContext autoTx);


    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    CourseRepository courseRepository();

    BoardRepository boardRepository(TransactionalContext autoTx);

    BoardRepository boardRepository();

    BoardOwnerRepository boardOwnerRepository(TransactionalContext autoTx);

    BoardOwnerRepository boardOwnerRepository();

    BoardHistoryRepository boardHistoryRepository(TransactionalContext autoTx);

    BoardHistoryRepository boardHistoryRepository();
    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    EnrollmentRepository enrollmentRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    EnrollmentRepository enrollmentRepository();


    /**
     * repository will be created in auto transaction mode
     *
     * @return MeetingRepository
     */
    MeetingRepository meetingRepository();

    MeetingRepository meetingRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return ClassRepository
     */
    ClassRepository classRepository();

    ClassRepository classRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return ExtraClassRepository
     */
    ExtraClassRepository extraClassRepository();

    ExtraClassRepository extraClassRepository(TransactionalContext autoTx);

    TeacherRepository teacherRepository();

    TeacherRepository teacherRepository(TransactionalContext autoTx);

    InvitationRepository invitationRepository(TransactionalContext autoTx);

    QuestionRepository questionRepository(TransactionalContext autoTx);
    QuestionRepository questionRepository();

    ExamRepository examRepository();

    ExamRepository examRepository(TransactionalContext autoTx);

    InvitationRepository invitationRepository();

    FormativeExamRepository formativeExamRepository();
    FormativeExamRepository formativeExamRepository(TransactionalContext autoTx);

    BoardParticipantRepository boardParticipantRepository();
    BoardParticipantRepository boardParticipantRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return PostItRepository
     */
    PostItRepository postItRepository();
    /**
     * repository will be created with the given transactional context
     *
     * @param autoTx the transactional context to enroll
     * @return PostItRepository
     */
    PostItRepository postItRepository(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return examResolutionRepository
     */
    ExamResolutionRepository examResolutionRepository();
    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return examResolutionRepository
     */
    ExamResolutionRepository examResolutionRepository(TransactionalContext autoTx);
}
