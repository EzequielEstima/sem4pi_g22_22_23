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
package eapli.base.app.backoffice.console.presentation.authz;

import java.util.ArrayList;
import java.util.List;

import eapli.framework.representations.dto.GeneralDTO;

import eapli.base.usermanagement.application.DeactivateUserController;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

/**
 *
 * @author Fernando
 */
@SuppressWarnings("squid:S106")
public class DeactivateUserUI extends AbstractUI {

    private final DeactivateUserController theController = new DeactivateUserController();

    @Override
    protected boolean doShow() {
        try {
            final Iterable<GeneralDTO> listUsersDto = this.theController.listActiveUsers();
            final List<GeneralDTO> listUsers = new ArrayList<>();
            int i =1;
            SystemUserPrinter printer = new SystemUserPrinter();
            if (!listUsersDto.iterator().hasNext()) return true;
            System.out.println(String.format("#  %-10s%-30s%-30s", "USERNAME", "NAME", "EMAIL"));
            for (GeneralDTO iterable : listUsersDto) {
                System.out.printf("%d. ",i);
                printer.visit(iterable);
                System.out.println();
                listUsers.add(iterable);
                i++;
            }
            System.out.println("0. Cancel");
            int option = Console.readOption(1, listUsers.size(), 0);
            if (theController.deactivateUser(listUsers.get(option - 1))) {
                System.out.println("User was deactivated with success");
            } else {
                System.out.println("Error while deactivating the user");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Deactivate User";
    }
}
