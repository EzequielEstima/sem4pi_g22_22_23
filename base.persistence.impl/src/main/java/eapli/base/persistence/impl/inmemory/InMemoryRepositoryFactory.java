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
package eapli.base.persistence.impl.inmemory;

import eapli.base.board.repositories.BoardRepository;
import eapli.base.boardhistory.repositories.BoardHistoryRepository;
import eapli.base.boardparticipantmanagement.repositories.BoardParticipantRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.courseclasses.repositories.ClassRepository;
import eapli.base.courseclasses.repositories.ExtraClassRepository;
import eapli.base.coursemanagement.repositories.CourseRepository;
import eapli.base.enrollments.repositories.EnrollmentRepository;
import eapli.base.exams.repositories.ExamRepository;
import eapli.base.exams.repositories.ExamResolutionRepository;
import eapli.base.formativeexams.repositories.FormativeExamRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.invitationmanagement.repositories.InvitationRepository;
import eapli.base.meetingmanagement.repositories.MeetingRepository;
import eapli.base.postitmanager.repositories.PostItRepository;
import eapli.base.questionmanagement.repositories.QuestionRepository;
import eapli.base.usermanagement.repositories.BoardOwnerRepository;
import eapli.base.usermanagement.repositories.PersonRepository;
import eapli.base.usermanagement.repositories.StudentRepository;
import eapli.base.usermanagement.repositories.TeacherRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.inmemory.InMemoryUserRepository;

/**
 *
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public PersonRepository personRepository(TransactionalContext autoTx) {
        return new InMemoryPersonRepository();
    }

    @Override
    public PersonRepository personRepository() {
        return personRepository(null);
    }

    @Override
    public StudentRepository studentRepository(TransactionalContext autoTx) {
        return new InMemoryStudentRepository();
    }

    @Override
    public StudentRepository studentRepository() {
        return studentRepository(null);
    }

    @Override
    public CourseRepository courseRepository(TransactionalContext autoTx) {
        return new InMemoryCourseRepository();
    }



    @Override
    public CourseRepository courseRepository() {
        return courseRepository(null);
    }

    @Override
    public BoardRepository boardRepository(TransactionalContext autoTx) {
        return new InMemoryBoardRepository();
    }

    @Override
    public BoardRepository boardRepository() {
        return boardRepository(null);
    }

    @Override
    public BoardOwnerRepository boardOwnerRepository(TransactionalContext autoTx) {
        return boardOwnerRepository(null);
    }

    @Override
    public BoardOwnerRepository boardOwnerRepository() {
        return new InMemoryBoardOwnerRepository();
    }

    @Override
    public BoardHistoryRepository boardHistoryRepository(TransactionalContext autoTx) {
        return boardHistoryRepository(null);
    }

    @Override
    public BoardHistoryRepository boardHistoryRepository() {
        return new InMemoryBoardHistoryRepository();
    }

    @Override
    public EnrollmentRepository enrollmentRepository(TransactionalContext autoTx) {
        return new inMemoryEnrollmentRepository();
    }

    @Override
    public EnrollmentRepository enrollmentRepository() {
        return enrollmentRepository(null);
    }

    @Override
    public QuestionRepository questionRepository(){
        return questionRepository(null);
    }

    @Override
    public ExamRepository examRepository() {
        return examRepository(null);
    }

    @Override
    public ExamRepository examRepository(TransactionalContext autoTx) {
        return new InMemoryExamRepository();
    }

    @Override
    public QuestionRepository questionRepository(TransactionalContext autoTx){
        return new InMemoryQuestionRepository();
    }
    @Override
    public MeetingRepository meetingRepository() {
        return meetingRepository(null);
    }

    @Override
    public MeetingRepository meetingRepository(TransactionalContext autoTx) {
        return new InMemoryMeetingRepository();
    }

    @Override
    public ClassRepository classRepository() {
        return classRepository(null);
    }

    @Override
    public ClassRepository classRepository(TransactionalContext autoTx) {
        return new InMemoryClassRepository();
    }

    @Override
    public ExtraClassRepository extraClassRepository() {
        return extraClassRepository(null);
    }

    @Override
    public ExtraClassRepository extraClassRepository(TransactionalContext autoTx) {
        return new InMemoryExtraClassRepository();
    }

    @Override
    public TeacherRepository teacherRepository() {
        return teacherRepository(null);
    }

    @Override
    public TeacherRepository teacherRepository(TransactionalContext autoTx) {
        return new InMemoryTeacherRepository();
    }

    @Override
    public InvitationRepository invitationRepository(TransactionalContext autoTx) {
        return new InMemoryInvitationRepository();
    }

    @Override
    public InvitationRepository invitationRepository() {
        return invitationRepository(null);
    }

    @Override
    public FormativeExamRepository formativeExamRepository() {
        return formativeExamRepository(null);
    }
    @Override
    public FormativeExamRepository formativeExamRepository(TransactionalContext autoTx) {
        return new InMemoryFormativeExamRepository();
    }
    @Override
    public BoardParticipantRepository boardParticipantRepository(){
        return boardParticipantRepository(null);
    }
    @Override
    public BoardParticipantRepository boardParticipantRepository(TransactionalContext autoTx){
        return new InMemoryBoardParticipantRepository();
    }

    @Override
    public PostItRepository postItRepository() {
        return null;
    }

    @Override
    public PostItRepository postItRepository(TransactionalContext autoTx) {
        return null;
    }

    @Override
    public ExamResolutionRepository examResolutionRepository() {
        return examResolutionRepository(null);
    }

    @Override
    public ExamResolutionRepository examResolutionRepository(TransactionalContext autoTx) {
        return new InMemoryExamResolutionRepository();
    }
    
    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
