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
package eapli.base.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {
        registerStudent("student", PASSWORD1, "Johny", "Cash","Johny Cash", "student@gmail.com","01-11-2000",100000000);
        registerTeacher("teacher", PASSWORD1, "Oven", "Stove", "Oven Stove","teacher@gmail.com","OST","01-11-2000",100000001);
        registerTeacher("teacher2", PASSWORD1, "David", "Dias", "David Dias", "teacher2@gmail.com", "DDS", "20-03-2003", 100000002);
        return true;
    }

    private void registerStudent(final String username, final String password,
                                 final String firstName, final String lastName,String fullName, final String email,final String dateOfBirth,final int taxPayerNumber) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.STUDENT);

        registerStudentBaseBootstrap(username, password, firstName, lastName,fullName, email, roles,dateOfBirth,taxPayerNumber);
    }

    private void registerTeacher(final String username, final String password,
                                 final String firstName, final String lastName,final String fullName, final String email, final String acronym,final String dateOfBirth,final int taxPayerNumber) {
        final Set<Role> roles = new HashSet<>();
        roles.add(BaseRoles.TEACHER);

        registerTeacherBaseBootstrap(username, password, firstName, lastName,fullName, email, roles,acronym,dateOfBirth,taxPayerNumber);
    }


}
