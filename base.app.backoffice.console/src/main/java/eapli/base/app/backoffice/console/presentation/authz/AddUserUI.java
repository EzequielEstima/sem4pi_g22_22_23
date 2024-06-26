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
package eapli.base.app.backoffice.console.presentation.authz;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import eapli.base.usermanagement.application.AddUserController;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.menu.Menu;
import eapli.framework.actions.menu.MenuItem;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;

/**
 * UI for adding a user to the application.
 *
 * Created by nuno on 22/03/16.
 */
public class AddUserUI extends AbstractUI {

    private final AddUserController theController = new AddUserController();

    @Override
    protected boolean doShow() {

        final String username = Console.readLine("Username");
        final String password = Console.readLine("Password");
        final String firstName = Console.readLine("First Name");
        final String lastName = Console.readLine("Last Name");
        final String fullName = Console.readLine("FullName");
        final String email = Console.readLine("E-Mail");

        final Set<Role> roleTypes = new HashSet<>();
        boolean show;
        do {
            show = showRoles(roleTypes);
        } while (!show);

        String msg;
        String confirmation;
        try {
            if  ( roleTypes.contains(BaseRoles.MANAGER)) {
                InformationVerification(username, password, firstName, lastName, fullName, email);
                do {
                    confirmation = Console.readLine("\n Do you confirm this information (Y/N)");
                } while (!confirmation.equals("Y") && !confirmation.equals("N") );

                if (confirmation.equals("Y")) {
                    msg = this.theController.addUser(username, password, firstName, lastName, fullName, email, roleTypes);
                    System.out.println("\n\n" + msg);
                }
            } else if (roleTypes.contains(BaseRoles.STUDENT)){
                final int taxPayerNumber = Console.readInteger("Tax Payer Number");
                final Date dateOfBirth = Console.readDate("Date (YYYY/MM/DD)");

                System.out.println("\n\n Student Information:");
                informationVerification(username, password, firstName, lastName, fullName, email, taxPayerNumber, dateOfBirth);

                do {
                    confirmation = Console.readLine("\n Do you confirm this information (Y/N)");
                } while (!confirmation.equals("Y") && !confirmation.equals("N") );

                if (confirmation.equals("Y")) {
                    msg = this.theController.addUser(username, password, firstName, lastName, fullName, email, roleTypes,dateOfBirth,taxPayerNumber);
                    System.out.println("\n\n" + msg);
                }
            } else if ( roleTypes.contains(BaseRoles.TEACHER)) {
                final int taxPayerNumber = Console.readInteger("Tax Payer Number");
                final Date dateOfBirth = Console.readDate("Date (YYYY/MM/DD)");
                final String acronym = Console.readLine("Acronym");

                System.out.println("\n\n Teacher Information:");
                informationVerification(username, password, firstName, lastName, fullName, email, taxPayerNumber, dateOfBirth);
                System.out.println("Acronym: " + acronym);
                do {
                    confirmation = Console.readLine("\n Do you confirm this information (Y/N)");
                } while (!confirmation.equals("Y") && !confirmation.equals("N") );

                if (confirmation.equals("Y")) {
                    msg = this.theController.addUser(username, password, firstName, lastName, fullName, email, roleTypes, acronym, dateOfBirth, taxPayerNumber);
                    System.out.println("\n\n" + msg);
                }
            }
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("That username is already in use.");
        }
        return false;
    }

    private void InformationVerification(String username, String password, String firstName, String lastName, String fullName, String email) {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Full Name: " + fullName);
        System.out.println("Email: " + email);
    }

    private void informationVerification(String username, String password, String firstName, String lastName, String fullName, String email, int taxPayerNumber, Date dateOfBirth) {
        InformationVerification(username, password, firstName, lastName, fullName, email);
        System.out.println("Tax Payer Number: " + taxPayerNumber);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfBirth);
        System.out.printf("Date Of Birth: %04d/%02d/%02d\n", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));    }

    private boolean showRoles(final Set<Role> roleTypes) {

        final Menu rolesMenu = buildRolesMenu(roleTypes);
        final MenuRenderer renderer = new VerticalMenuRenderer(rolesMenu, MenuItemRenderer.DEFAULT);
        return renderer.render();
    }

    private Menu buildRolesMenu(final Set<Role> roleTypes) {
        final Menu rolesMenu = new Menu();
        int counter = 1;
        for (final Role roleType : theController.getRoleTypes()) {
            rolesMenu.addItem(MenuItem.of(counter++, roleType.toString(), () -> roleTypes.add(roleType)));
        }
        return rolesMenu;
    }

    @Override
    public String headline() {
        return "Add User";
    }
}
