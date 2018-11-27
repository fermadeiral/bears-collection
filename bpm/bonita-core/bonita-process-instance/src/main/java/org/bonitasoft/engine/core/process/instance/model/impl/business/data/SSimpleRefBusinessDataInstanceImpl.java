/**
 * Copyright (C) 2015 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation
 * version 2.1 of the License.
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 51 Franklin Street, Fifth
 * Floor, Boston, MA 02110-1301, USA.
 **/
package org.bonitasoft.engine.core.process.instance.model.impl.business.data;

import org.bonitasoft.engine.core.process.instance.model.business.data.SSimpleRefBusinessDataInstance;

/**
 * @author Matthieu Chaffotte
 */
public abstract class SSimpleRefBusinessDataInstanceImpl extends SRefBusinessDataInstanceImpl implements SSimpleRefBusinessDataInstance {

    private static final long serialVersionUID = -6240483858780514216L;

    private Long dataId;

    public SSimpleRefBusinessDataInstanceImpl() {
        super();
    }

    @Override
    public Long getDataId() {
        return dataId;
    }

    public void setDataId(final Long dataId) {
        this.dataId = dataId;
    }

}
