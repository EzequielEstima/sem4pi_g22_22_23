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
package eapli.base.persistence.impl.jpa;

import eapli.base.Application;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;
import eapli.base.board.repositories.BoardRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.jpa.JpaAutoTxUserRepository;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    @Override
    public UserRepository users(final TransactionalContext autoTx) {
        return new JpaAutoTxUserRepository(autoTx);
    }

    @Override
    public UserRepository users() {
        return new JpaAutoTxUserRepository(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

    @Override
    public JpaClientUserRepository clientUsers(final TransactionalContext autoTx) {
        return new JpaClientUserRepository(autoTx);
    }

    @Override
    public JpaClientUserRepository clientUsers() {
        return new JpaClientUserRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext autoTx) {
        return new JpaSignupRequestRepository(autoTx);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return new JpaSignupRequestRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PersonRepository personRepository(TransactionalContext autoTx) {
        return new JpaPersonRepository(autoTx);
    }

    @Override
    public PersonRepository personRepository() {
        return new JpaPersonRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public StudentRepository studentRepository(TransactionalContext autoTx) {
        return new JpaStudentRepository(autoTx);
    }

    @Override
    public StudentRepository studentRepository() {
        return new JpaStudentRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public CourseRepository courseRepository(TransactionalContext autoTx) {
        return new JpaCourseRepository(autoTx);
    }

    @Override
    public CourseRepository courseRepository() {
        return new JpaCourseRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public BoardRepository boardRepository(TransactionalContext autoTx) {
        return new JpaBoardRepository(autoTx);
    }

    @Override
    public BoardRepository boardRepository() {
        return new JpaBoardRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public BoardOwnerRepository boardOwnerRepository(TransactionalContext autoTx) {
        return new JpaBoardOwnerRepository(autoTx);
    }

    @Override
    public BoardOwnerRepository boardOwnerRepository() {
        return new JpaBoardOwnerRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public BoardHistoryRepository boardHistoryRepository(TransactionalContext autoTx) {
        return new JpaBoardHistoryRepository(autoTx);
    }

    @Override
    public BoardHistoryRepository boardHistoryRepository() {
        return new JpaBoardHistoryRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public EnrollmentRepository enrollmentRepository(TransactionalContext autoTx) {
        return new JpaEnrollmentRepository(autoTx);
    }

    @Override
    public EnrollmentRepository enrollmentRepository() {
        return new JpaEnrollmentRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public MeetingRepository meetingRepository() {
        return new JpaMeetingRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public MeetingRepository meetingRepository(TransactionalContext autoTx) {
        return new JpaMeetingRepository(autoTx);
    }

    @Override
    public ClassRepository classRepository() {
        return new JpaClassRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ClassRepository classRepository(TransactionalContext autoTx) {
        return new JpaClassRepository(autoTx);
    }

    @Override
    public ExtraClassRepository extraClassRepository() {
        return new JpaExtraClassRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExtraClassRepository extraClassRepository(TransactionalContext autoTx) {
        return new JpaExtraClassRepository(autoTx);

    }

    @Override
    public TeacherRepository teacherRepository() {
        return new JpaTeacherRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public TeacherRepository teacherRepository(TransactionalContext autoTx) {
        return new JpaTeacherRepository(autoTx);
    }

    @Override
    public InvitationRepository invitationRepository(TransactionalContext autoTx) {
        return new JpaInvitationRepository(autoTx);
    }

    @Override
    public QuestionRepository questionRepository(TransactionalContext autoTx) {
        return new JpaQuestionRepository(autoTx);
    }

    @Override
    public QuestionRepository questionRepository() {
        return new JpaQuestionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamRepository examRepository(){
        return new JpaExamRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public ExamRepository examRepository(TransactionalContext autoTx){
        return new JpaExamRepository(autoTx);
    }

    @Override
    public InvitationRepository invitationRepository() {
        return new JpaInvitationRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public FormativeExamRepository formativeExamRepository() {
        return new JpaFormativeExamRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public FormativeExamRepository formativeExamRepository(TransactionalContext autoTx) {
        return new JpaFormativeExamRepository(autoTx);
    }
    @Override
    public BoardParticipantRepository boardParticipantRepository(){
        return new JpaBoardParticipantRepository(Application.settings().getPersistenceUnitName());
    }
    @Override
    public BoardParticipantRepository boardParticipantRepository(TransactionalContext autoTx) {
        return new JpaBoardParticipantRepository(autoTx);
    }

    @Override
    public PostItRepository postItRepository() {
        return new JpaPostItRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public PostItRepository postItRepository(TransactionalContext autoTx) {
        return new JpaPostItRepository(autoTx);
    }

    @Override
    public ExamResolutionRepository examResolutionRepository() {
        return new JpaExamResolutionRepository(Application.settings().getPersistenceUnitName());
    }

    @Override
    public ExamResolutionRepository examResolutionRepository(TransactionalContext autoTx) {
        return new JpaExamResolutionRepository(autoTx);
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        return JpaAutoTxRepository.buildTransactionalContext(Application.settings().getPersistenceUnitName(),
                Application.settings().getExtendedPersistenceProperties());
    }

}
