package presentation;/*
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

import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import presentation.archiveBoard.ArchiveBoardAction;
import presentation.historyOfUpdates.HistoryOfUpdatesAction;
import presentation.listNotifications.ListNotificationsAction;
import presentation.postIt.ChangePostItContentAction;
import presentation.postIt.ChangePostItPositionAction;
import presentation.postIt.CreatePostItAction;
import presentation.postIt.UndoLastChangeInPostItAction;
import presentation.shareBoard.ShareBoardAppAction;
import presentation.viewInRealTime.ViewInRealTimeAction;

import java.net.Socket;

/**
 * TODO split this class in more specialized classes for each menu
 *
 * @author Paulo Gandra Sousa
 */
public class MainMenu extends AbstractUI {
    private final Socket socket;
    public MainMenu (Socket socket){
        this.socket = socket;
    }

    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;
    private static final int SHARE_BOARD_OPTION = 1;

    private static final int ARCHIVE_BOARD_OPTION = 2;

    private static final int CREATE_A_POST_IT = 3;

    private static final int UNDO_LAST_CHANGE_IN_A_POST_IT = 6;

    private static final int CHANGE_POST_IT_CONTENT = 4;

    private static final int CHANGE_POST_IT_POSITION = 5;

    private static final int HISTORY_OF_UPDATES_OPTION = 7;

    private static final int VIEW_IN_REAL_TIME = 8;
    private static final int NOTIFICATIONS = 9;


    // private static final int COMMTEST_OPTION = 1;


    private static final String SEPARATOR_LABEL = "--------------";


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
        renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    @Override
    public String headline() {

        return  "Base [@ClientApplication]";
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();
        mainMenu.addItem(SHARE_BOARD_OPTION, "Share Board", new ShareBoardAppAction(socket));
        mainMenu.addItem(ARCHIVE_BOARD_OPTION, "Archive Board", new ArchiveBoardAction(socket));
        mainMenu.addItem(CREATE_A_POST_IT, "Create a Post-it", new CreatePostItAction(socket));
        mainMenu.addItem(CHANGE_POST_IT_CONTENT, "Change post-it content", new ChangePostItContentAction(socket));
        mainMenu.addItem(CHANGE_POST_IT_POSITION, "Change post-it position", new ChangePostItPositionAction(socket));
        mainMenu.addItem(UNDO_LAST_CHANGE_IN_A_POST_IT, "Undo last change in a Post-it", new UndoLastChangeInPostItAction(socket));
        mainMenu.addItem(HISTORY_OF_UPDATES_OPTION, "History of Updates", new HistoryOfUpdatesAction(socket));
        mainMenu.addItem(VIEW_IN_REAL_TIME, "View Board In Real Time", new ViewInRealTimeAction(socket));
        mainMenu.addItem(NOTIFICATIONS, "Notifications", new ListNotificationsAction(socket));
        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));
        return mainMenu;
    }
}
