/**
 * eGov suite of products aim to improve the internal efficiency,transparency,
   accountability and the service delivery of the government  organizations.

    Copyright (C) <2015>  eGovernments Foundation

    The updated version of eGov suite of products as by eGovernments Foundation
    is available at http://www.egovernments.org

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program. If not, see http://www.gnu.org/licenses/ or
    http://www.gnu.org/licenses/gpl.html .

    In addition to the terms of the GPL license to be adhered to in using this
    program, the following additional terms are to be complied with:

        1) All versions of this program, verbatim or modified must carry this
           Legal Notice.

        2) Any misrepresentation of the origin of the material is prohibited. It
           is required that all modified versions of this material be marked in
           reasonable ways as different from the original version.

        3) This license does not grant any rights to any user of the program
           with regards to rights under trademark law for use of the trade names
           or trademarks of eGovernments Foundation.

  In case of any queries, you can reach eGovernments Foundation at contact@egovernments.org.
 */
package org.egov.eis.entity;

import java.lang.reflect.Field;

import org.egov.infra.admin.master.entity.Department;
import org.egov.pims.commons.DeptDesig;
import org.egov.pims.commons.Designation;
import org.junit.Ignore;
@Ignore
public class DeptDesigBuilder {

    private final DeptDesig deptDesig;

    private static long count = 0;

    public DeptDesigBuilder() {
        deptDesig = new DeptDesig();
        count++;
    }

    public DeptDesig build() {
        return deptDesig;
    }

    public DeptDesigBuilder withDepartment(final Department dept) {
        deptDesig.setDepartment(dept);
        return this;
    }

    public DeptDesigBuilder withSanctionedPosts(final Integer posts) {
        deptDesig.setSanctionedPosts(posts);
        return this;
    }

    public DeptDesigBuilder withOutsourcedPosts(final Integer posts) {
        deptDesig.setOutsourcedPosts(posts);
        return this;
    }

    public DeptDesigBuilder withDesignation(final Designation designation) {
        deptDesig.setDesignation(designation);
        return this;
    }

    public DeptDesigBuilder withId(final long id) {
        try {
            final Field idField = deptDesig.getClass().getSuperclass().getSuperclass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(deptDesig, id);
        } catch (final Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public DeptDesigBuilder withDefaults() {
        if (null == deptDesig.getId())
            withId(count);

        return this;
    }

}
