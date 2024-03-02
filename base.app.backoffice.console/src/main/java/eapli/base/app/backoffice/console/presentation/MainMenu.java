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
package eapli.base.app.backoffice.console.presentation;

import eapli.base.app.backoffice.console.presentation.course.CreateCourseAction;
import eapli.base.app.backoffice.console.presentation.course.OpenCloseCourseAction;
import eapli.base.app.backoffice.console.presentation.course.OpenCloseCourseEnrollmentsAction;
import eapli.base.app.backoffice.console.presentation.course.SetTeacherAction;
import eapli.base.app.backoffice.console.presentation.enrollment.ApproveRejectEnrollmentAction;
import eapli.base.app.backoffice.console.presentation.enrollment.EnrollInBulkAction;
import eapli.base.app.common.console.presentation.authz.MyUserMenu;
import eapli.base.Application;
import eapli.base.app.backoffice.console.presentation.authz.AddUserUI;
import eapli.base.app.backoffice.console.presentation.authz.DeactivateUserAction;
import eapli.base.app.backoffice.console.presentation.authz.ListUsersAction;
import eapli.base.app.backoffice.console.presentation.clientuser.AcceptRefuseSignupRequestAction;
import eapli.base.app.common.console.presentation.board.CreateBoardAction;
import eapli.base.app.common.console.presentation.course.ListCourseAction;
import eapli.base.app.common.console.presentation.meeting.AcceptRejectInvitationAction;
import eapli.base.app.common.console.presentation.meeting.CancelMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ListAllInvitationsFromMeetingAction;
import eapli.base.app.common.console.presentation.meeting.ScheduleMeetingAction;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.ShowMessageAction;
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

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // USERS
    private static final int ADD_USER_OPTION = 1;
    private static final int LIST_USERS_OPTION = 2;
    private static final int DEACTIVATE_USER_OPTION = 3;
    private static final int ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION = 4;

    // SETTINGS
    private static final int SET_KITCHEN_ALERT_LIMIT_OPTION = 1;

    // COURSE
    private static final int CREATE_COURSE_OPTION = 1;
    private static final int OPEN_CLOSE_COURSE_OPTION = 2;
    private static final int OPEN_CLOSE_COURSE_ENROLLMENTS_OPTION = 3;
    private static final int APPROVE_REJECT_ENROLLMENT = 4;
    private static final int LIST_COURSE_OPTION = 5;
    private static final int SET_TEACHER_IN_COURSE = 6;

    //ENROLLMENT
    private static final int ENROLL_IN_BULK = 1;

    // MEETING
    private static final int SCHEDULE_MEETING_OPTION = 1;
    private static final int CANCEL_MEETING_OPTION = 2;

    private static final int List_ALL_INVITATIONS = 3;
    private static final int ACCEPT_REJECT_INVITATIONS = 4;

    //BOARD
    private static final int CREATE_BOARD = 1;

    // MAIN MENU
    private static final int MY_USER_OPTION = 1;
    private static final int USERS_OPTION = 2;
    private static final int COURSE_OPTION = 3;
    private static final int SETTINGS_OPTION = 4;
    private static final int ENROLLMENT_OPTION = 5;
    private static final int MEETING_OPTION  = 6;
    private static final int BOARD_OPTION = 7;

    private static final String SEPARATOR_LABEL = "--------------";

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

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
        final MenuRenderer renderer;
        if (Application.settings().isMenuLayoutHorizontal()) {
            renderer = new HorizontalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        } else {
            renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        }
        return renderer.render();
    }

    @Override
    public String headline() {

        return authz.session().map(s -> "Base [ @" + s.authenticatedUser().identity() + " ]")
                .orElse("Base [ ==Anonymous== ]");
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        final Menu myUserMenu = new MyUserMenu();
        mainMenu.addSubMenu(MY_USER_OPTION, myUserMenu);

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        if (authz.isAuthenticatedUserAuthorizedTo(BaseRoles.POWER_USER, BaseRoles.MANAGER)) {
            final Menu usersMenu = buildUsersMenu();
            mainMenu.addSubMenu(USERS_OPTION, usersMenu);
            final Menu coursesMenu = buildCourseMenu();
            mainMenu.addSubMenu(COURSE_OPTION,coursesMenu);
            final Menu settingsMenu = buildAdminSettingsMenu();
            mainMenu.addSubMenu(SETTINGS_OPTION, settingsMenu);
            final Menu enrollmentMenu = buildEnrollmentMenu();
            mainMenu.addSubMenu(ENROLLMENT_OPTION, enrollmentMenu);
            final Menu meetingMenu = buildMeetingMenu();
            mainMenu.addSubMenu(MEETING_OPTION, meetingMenu);
            final Menu boardMenu = buildBoardMenu();
            mainMenu.addSubMenu(BOARD_OPTION, boardMenu);
        }

        if (!Application.settings().isMenuLayoutHorizontal()) {
            mainMenu.addItem(MenuItem.separator(SEPARATOR_LABEL));
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildCourseMenu() {
        final Menu menu = new Menu("Courses >");

        menu.addItem(CREATE_COURSE_OPTION,"Create course",new CreateCourseAction());
        menu.addItem(OPEN_CLOSE_COURSE_OPTION, "Open/Close course",new OpenCloseCourseAction());
        menu.addItem(OPEN_CLOSE_COURSE_ENROLLMENTS_OPTION, "Open/Close Course Enrollments", new OpenCloseCourseEnrollmentsAction());
        menu.addItem(APPROVE_REJECT_ENROLLMENT, "Accept/Reject Enrollment", new ApproveRejectEnrollmentAction());
        menu.addItem(LIST_COURSE_OPTION,"List Course", new ListCourseAction());
        menu.addItem(SET_TEACHER_IN_COURSE,"Set Teachers of a Course", new SetTeacherAction());
        menu.addItem(EXIT_OPTION,RETURN_LABEL,Actions.SUCCESS);


        return menu;
    }

    private  Menu buildMeetingMenu() {
        final Menu menu = new Menu("Meetings >");

        menu.addItem(SCHEDULE_MEETING_OPTION, "Schedule Meeting", new ScheduleMeetingAction());
        menu.addItem(CANCEL_MEETING_OPTION, "Cancel Meeting", new CancelMeetingAction());
        menu.addItem(List_ALL_INVITATIONS, "List all Invitations", new ListAllInvitationsFromMeetingAction());
        menu.addItem(ACCEPT_REJECT_INVITATIONS,"Accept/Reject invitations", new AcceptRejectInvitationAction());
        menu.addItem(EXIT_OPTION, "Return", Actions.SUCCESS);

        return menu;
    }

    private Menu buildEnrollmentMenu() {
        final Menu menu = new Menu("Enrollments >");

        menu.addItem(ENROLL_IN_BULK,"Enroll in Bulk",new EnrollInBulkAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildBoardMenu(){
        final Menu menu = new Menu("Boards >");

        menu.addItem(CREATE_BOARD, "Create Board", new CreateBoardAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildAdminSettingsMenu() {
        final Menu menu = new Menu("Settings >");

        menu.addItem(SET_KITCHEN_ALERT_LIMIT_OPTION, "Set kitchen alert limit",
                new ShowMessageAction("Not implemented yet"));
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildUsersMenu() {
        final Menu menu = new Menu("Users >");

        menu.addItem(ADD_USER_OPTION, "Add User", new AddUserUI()::show);
        menu.addItem(LIST_USERS_OPTION, "List all Users", new ListUsersAction());
        menu.addItem(DEACTIVATE_USER_OPTION, "Deactivate User", new DeactivateUserAction());
        menu.addItem(ACCEPT_REFUSE_SIGNUP_REQUEST_OPTION, "Accept/Refuse Signup Request",
                new AcceptRefuseSignupRequestAction());
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }
}
