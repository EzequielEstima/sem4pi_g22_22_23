package eapli.base.invitationmanagement.dto;


public class InvitationDTOWithStatusAndPersonName{

    public String personName;
    public String status;

    public InvitationDTOWithStatusAndPersonName(String personName, String status){
        this.personName = personName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Name: "+personName+" Status: "+status;
    }
}
