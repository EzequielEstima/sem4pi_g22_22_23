package eapli.base.invitationmanagement.dto;


public class InvitationDTOWithStatusAndPersonNameBuilder {

    private String personName;

    private String status;

    public InvitationDTOWithStatusAndPersonNameBuilder withStatusAndName(String status, String name){
        withName(name);
        withStatus(status);
        return this;
    }

    public InvitationDTOWithStatusAndPersonNameBuilder withStatus(String status){
        this.status = status;
        return this;
    }

    public InvitationDTOWithStatusAndPersonNameBuilder withName(String name){
        this.personName = name;
        return this;
    }

    public InvitationDTOWithStatusAndPersonName build() {
        return new InvitationDTOWithStatusAndPersonName(personName,status);
    }
}
