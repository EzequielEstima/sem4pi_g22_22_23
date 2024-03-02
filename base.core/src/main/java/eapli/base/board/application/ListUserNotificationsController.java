package eapli.base.board.application;

import eapli.base.board.application.services.ListUserNotificationsService;

import java.util.List;

public class ListUserNotificationsController {
    public List<String> listUserNotifications(){
        ListUserNotificationsService listUserNotificationsService = new ListUserNotificationsService();
        return listUserNotificationsService.listUserNotifications();
    }
}
