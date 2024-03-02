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
package eapli.base.app.other.console.presentation;

import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.common.console.presentation.board.CreateBoardAction;
import eapli.base.app.common.console.presentation.course.ListCourseAction;
import eapli.base.app.common.console.presentation.meeting.AcceptRejectInvitationAction;
import eapli.base.app.common.console.presentation.meeting.CancelMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ListAllInvitationsFromMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ScheduleMeetingAction;
import eapli.base.app.other.console.presentation.courseClass.CreateClassAction;
import eapli.base.app.other.console.presentation.courseClass.ScheduleExtraClassAction;
import eapli.base.app.other.console.presentation.courseclasses.RescheduleClassAction;
import eapli.base.app.other.console.presentation.exam.CreateExamAction;
import eapli.base.app.other.console.presentation.exam.ViewCoursesGradesAction;
import eapli.base.app.other.console.presentation.formativeexam.FormativeAction;
import eapli.base.app.other.console.presentation.exam.UpdateExamAction;
import eapli.base.app.other.console.presentation.question.AddQuestionAction;
import eapli.base.app.other.console.presentation.exam.ListAllExamsOfCourseAction;
import eapli.base.app.other.console.presentation.question.UpdateQuestionAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.HorizontalMenuRenderer;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {

    private static final String SEPARATOR_LABEL = "--------------";

    private static final int EXIT_OPTION = 0;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;

    private static final int COURSE_OPTION = 2;

    private static final int MEETING_OPTION = 3;
    private static final int BOARD_OPTION = 4;

    private static final int EXAM = 5;

    // COURSE MENU
    private static final int LIST_COURSE_OPTION = 1;
    private static final int CREATE_CLASS = 2;

    private static final int RESCHEDULE_CLASS_OPTION = 3;
    private static final int SCHEDULE_EXTRA_CLASS = 4;

    private static final int LIST_ALL_EXAMS_OF_COURSE = 5;

    // MEETING MENU
    private static final int SCHEDULE_MEETING = 1;
    private static final int CANCEL_MEETING = 2;
    private static final int List_ALL_INVITATIONS = 3;
    private static final int ACCEPT_REJECT_INVITATIONS = 4;


    //BOARD MENU
    private static final int CREATE_BOARD_OPTION = 1;

    //EXAM
    private static final int CREATE_EXAM = 1;
    private static final int UPDATE_EXAM = 2;

    private static final int ADD_QUESTION = 3;

    private static final int UPDATE_QUESTION = 4;
    private static final int CREATE_FORMATIVE_EXAM_OPTION = 5;

    private static final int VIEW_COURSES_GRADES_OPTION = 6;


    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final Menu menu;
    private final MenuRenderer renderer;

    public MainMenu() {
        menu = buildMainMenu();
        renderer = getRenderer(menu);
    }

    private MenuRenderer getRenderer(final Menu menu) {
        final MenuRenderer theRenderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            theRenderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            theRenderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return theRenderer;
    }

    @Override
    public boolean doShow() {
        return renderer.render();
    }

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu(BaseRoles.TEACHER);
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.TEACHER)) {
            final Menu courseMenu = buildCourseMenu();
            mainMenu.addSubMenu(COURSE_OPTION, courseMenu);
            final Menu meetingMenu = buildMeetingMenu();
            mainMenu.addSubMenu(MEETING_OPTION, meetingMenu);
        }

        final Menu boardMenu = buildBoardMenu();
        mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
        final Menu examMenu = buildExamMenu();
        mainMenu.addSubMenu(EXAM, examMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildCourseMenu() {
        final Menu courseMenu = new Menu("Course  >");

        courseMenu.addItem(LIST_COURSE_OPTION,"List Course", new ListCourseAction());
        courseMenu.addItem(CREATE_CLASS,"Create Class", new CreateClassAction());
        courseMenu.addItem(RESCHEDULE_CLASS_OPTION,"Reschedule Class", new RescheduleClassAction());
        courseMenu.addItem(SCHEDULE_EXTRA_CLASS,"Schedule extra class", new ScheduleExtraClassAction());
        courseMenu.addItem(LIST_ALL_EXAMS_OF_COURSE,"List all exams of Course", new ListAllExamsOfCourseAction());
        courseMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return courseMenu;
    }

    private Menu buildMeetingMenu() {
        final Menu meetingMenu = new Menu("Meeting  >");

        meetingMenu.addItem(SCHEDULE_MEETING, "Schedule Meeting", new ScheduleMeetingAction());
        meetingMenu.addItem(CANCEL_MEETING, "Cancel Meeting", new CancelMeetingAction());
        meetingMenu.addItem(List_ALL_INVITATIONS, "List all Invitations", new ListAllInvitationsFromMeetingAction());
        meetingMenu.addItem(ACCEPT_REJECT_INVITATIONS,"Accept/Reject invitations", new AcceptRejectInvitationAction());
        meetingMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return meetingMenu;
    }
    private Menu buildBoardMenu(){
        final Menu boardMenu = new Menu("Board  >");

        boardMenu.addItem(CREATE_BOARD_OPTION, "Create board", new CreateBoardAction());
        boardMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return boardMenu;
    }

    private Menu buildExamMenu(){
        final Menu examMenu = new Menu("Exam  >");

        examMenu.addItem(CREATE_EXAM, "Create Exam", new CreateExamAction());
        examMenu.addItem(UPDATE_EXAM, "Update Exam", new UpdateExamAction());
        examMenu.addItem(ADD_QUESTION, "Add Question", new AddQuestionAction());
        examMenu.addItem(UPDATE_QUESTION, "Update Question", new UpdateQuestionAction());
        examMenu.addItem(CREATE_FORMATIVE_EXAM_OPTION,"Create Formative Exam", new FormativeAction());
        examMenu.addItem(VIEW_COURSES_GRADES_OPTION, "View Courses Grades", new ViewCoursesGradesAction());
        examMenu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);
        return examMenu;
    }

}
