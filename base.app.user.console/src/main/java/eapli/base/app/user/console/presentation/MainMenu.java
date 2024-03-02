/*
 * Copyright (c) 2013-2023 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package eapli.base.app.user.console.presentation;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.app.common.console.presentation.board.CreateBoardAction;
import eapli.base.app.common.console.presentation.course.ListCourseAction;
import eapli.base.app.common.console.presentation.meeting.AcceptRejectInvitationAction;
import eapli.base.app.common.console.presentation.meeting.CancelMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ListAllInvitationsFromMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ScheduleMeetingAction;
import eapli.base.app.user.console.presentation.enrollment.RequestEnrollmentAction;
import eapli.base.app.user.console.presentation.exams.ListFutureExamsAction;
import eapli.base.app.user.console.presentation.exams.ListStudentGradesAction;
import eapli.base.app.user.console.presentation.exams.TakeExamAction;
import eapli.base.app.user.console.presentation.exams.TakeExamUI;
import eapli.base.app.user.console.presentation.foraamtiveexam.TakeFormativeExamAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;

/**
 * @author Paulo Gandra Sousa
 */
class MainMenu extends ClientUserBaseUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final String RETURN = "Return ";

    private static final String NOT_IMPLEMENTED_YET = "Not implemented yet";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;

    private static final int COURSE_OPTION = 2;

    private static final int EXAM_OPTION = 3;

    private static final int MEETING_OPTION = 4;

    private static final int BOARD_OPTION = 5;

    private static final int FORMATIVE_EXAM_OPTION = 6;


    // COURSE MENU
    private static final int LIST_COURSE_OPTION = 1;

    private static final int REQUEST_ENROLLMENT = 2;

    // EXAM MENU

    private static final int LIST_FUTURE_EXAMS_OPTION = 1;

    private static final int TAKE_EXAM_OPTION = 2;

    private static final int LIST_STUDENT_GRADE = 3;

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    // MEETING MENU
    private static final int SCHEDULE_MEETING_OPTION = 1;
    private static final int CANCEL_MEETING_OPTION = 2;

    private static final int List_ALL_INVITATIONS = 3;
    private static final int ACCEPT_REJECT_INVITATIONS = 4;


    //BOARD MENU
    private static final int CREATE_BOARD_OPTION = 1;

    //FORMATIVE EXAM

    private static final int TAKE_FORMATIVE_EXAM_OPTION = 1;

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer =
                new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.STUDENT)) {
            final Menu courseMenu = buildCourseMenu();
            mainMenu.addSubMenu(COURSE_OPTION, courseMenu);
            final Menu examMenu = buildExamMenu();
            mainMenu.addSubMenu(EXAM_OPTION, examMenu);
            final Menu meetingMenu = buildMeetingMenu();
            mainMenu.addSubMenu(MEETING_OPTION, meetingMenu);
            final Menu boardMenu = builBoardMenu();
            mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
            final Menu formativeExamMenu = buildFormativeExamMenu();
            mainMenu.addSubMenu(FORMATIVE_EXAM_OPTION, formativeExamMenu);
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildMeetingMenu() {
        final Menu meetingMenu = new Menu("Meeting  >");

        meetingMenu.addItem(SCHEDULE_MEETING_OPTION, "Schedule Meeting", new ScheduleMeetingAction());
        meetingMenu.addItem(CANCEL_MEETING_OPTION, "Cancel Meeting", new CancelMeetingAction());
        meetingMenu.addItem(List_ALL_INVITATIONS, "List all Invitations", new ListAllInvitationsFromMeetingAction());
        meetingMenu.addItem(ACCEPT_REJECT_INVITATIONS,"Accept/Reject invitations", new AcceptRejectInvitationAction());
        meetingMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return meetingMenu;
    }

    private Menu buildCourseMenu() {
        final Menu courseMenu = new Menu("Course  >");

        courseMenu.addItem(LIST_COURSE_OPTION,"List Course", new ListCourseAction());
        courseMenu.addItem(REQUEST_ENROLLMENT,"Request Enrollment", new RequestEnrollmentAction());
        courseMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return courseMenu;
    }
    private Menu buildExamMenu(){
        final Menu examMenu = new Menu("Exam  >");

        examMenu.addItem(LIST_FUTURE_EXAMS_OPTION, "List Future Exams", new ListFutureExamsAction());
        examMenu.addItem(TAKE_EXAM_OPTION,"Take an exam", new TakeExamAction());
        examMenu.addItem(LIST_STUDENT_GRADE,"List my grade", new ListStudentGradesAction());
        examMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return examMenu;
    }

    private Menu builBoardMenu(){
        final Menu boardMenu = new Menu("Board  >");

        boardMenu.addItem(CREATE_BOARD_OPTION, "Create Board", new CreateBoardAction());
        boardMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return boardMenu;
    }

    private Menu buildFormativeExamMenu(){
        final Menu formativeExamMenu = new Menu("Formative Exam  >");

        formativeExamMenu.addItem(TAKE_FORMATIVE_EXAM_OPTION, "Take Formative Exam", new TakeFormativeExamAction());
        formativeExamMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return formativeExamMenu;
    }
}
