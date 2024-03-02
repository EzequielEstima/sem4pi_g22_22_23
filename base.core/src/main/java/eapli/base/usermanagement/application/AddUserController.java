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
package eapli.base.usermanagement.application;

import java.util.Date;
import java.util.Set;

import eapli.base.usermanagement.application.services.PersonService;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Role;


/**
 *
 * Created by nuno on 21/03/16.
 */
@UseCaseController
public class AddUserController {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final PersonService personService = new PersonService();

    /**
     * Get existing RoleTypes available to the user.
     *
     * @return a list of RoleTypes
     */
    public Role[] getRoleTypes() {
        return BaseRoles.nonUserValues();
    }


    public String addUser(final String username, final String password, final String firstName,
            final String lastName,final String fullName,
            final String email, final Set<Role> roles) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MANAGER);

        return personService.registerNewPerson(fullName,username, password, firstName, lastName, email, roles);
    }

    public String addUser(final String username, final String password, final String firstName,
                           final String lastName,final String fullName,
                           final String email, final Set<Role> roles, final String acronym ,Date dateOfBirth,int taxPayerNumber) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MANAGER);

        return personService.registerNewTeacher(username, password, firstName, lastName,fullName, email, roles,acronym,dateOfBirth,taxPayerNumber);
    }

    public String addUser(final String username, final String password, final String firstName,
                          final String lastName, final String fullName,
                          final String email, final Set<Role> roles, Date dateOfBirth, int taxPayerNumber) {

        authz.ensureAuthenticatedUserHasAnyOf(BaseRoles.POWER_USER, BaseRoles.MANAGER);

        return personService.registerNewStudent(username,password,firstName, lastName,fullName, email, roles, dateOfBirth, taxPayerNumber);
    }
}
