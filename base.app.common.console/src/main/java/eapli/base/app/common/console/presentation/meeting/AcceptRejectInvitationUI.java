package eapli.base.app.common.console.presentation.meeting;

import eapli.base.invitationmanagement.application.AcceptRejectInvitationController;
import eapli.base.invitationmanagement.application.ListPersonPendingInvitationsController;
import eapli.base.invitationmanagement.dto.InvitationDTOWithIdAndMeeting;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.SelectWidget;

import java.util.ArrayList;
import java.util.List;

public class AcceptRejectInvitationUI extends AbstractUI {

    private final ListPersonPendingInvitationsController listInvController = new ListPersonPendingInvitationsController();
    private final AcceptRejectInvitationController accRejInvController = new AcceptRejectInvitationController();

    @Override
    protected boolean doShow() {
        List<InvitationDTOWithIdAndMeeting> invitationDTOList = listInvController.listPersonPendingInvitations();
        if (invitationDTOList.size() == 0){
            System.out.println("\n[ERROR]");
            System.out.println("You do not have any pending meeting invitations at the moment");
            return false;
        }

        SelectWidget<InvitationDTOWithIdAndMeeting> invitationSelector = new SelectWidget<>("Select an invitation:\n(Invitation Identifier | Meeting Identifier | Meeting date)",
                invitationDTOList,new InvitationDTOWithIdAndMeetingPrinter());

        invitationSelector.show();

        InvitationDTOWithIdAndMeeting selectedInvitation = invitationSelector.selectedElement();
        if(selectedInvitation != null){
            try {
                List<String> optionsList = new ArrayList<>();
                optionsList.add("Accepted");
                optionsList.add("Rejected");
                SelectWidget<String> optionSelector = new SelectWidget<>("Do you want this invitation to be accepted or rejected? (Select desired option)",
                        optionsList,new AcceptRejectOptionPrinter());

                optionSelector.show();
                String selectedOption = optionSelector.selectedElement();
                if (selectedOption != null){
                    if (!Console.readBoolean("Are you sure you want to change the status of this invitation?(y/n)")) {
                        return false;
                    }
                    accRejInvController.updateResponseStatus(selectedInvitation.invitationId,selectedOption.toUpperCase());
                }
            }catch (Exception e){
                System.out.println("\n[ERROR]");
                System.out.println(e.getMessage());
            }
        }
        return true;
    }

    @Override
    public String headline() {
        return "Accept/Reject invitation";
    }
}
