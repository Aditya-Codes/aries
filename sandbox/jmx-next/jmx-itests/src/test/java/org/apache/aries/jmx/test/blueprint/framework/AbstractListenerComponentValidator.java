/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.aries.jmx.test.blueprint.framework;

import static junit.framework.Assert.assertNotNull;

import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeType;

import org.apache.aries.jmx.blueprint.BlueprintMetadataMBean;

abstract class AbstractListenerComponentValidator extends AbstractCompositeDataValidator {
    
    // a TargetValidator can be one of BeanValidator, ReferenceValidator, RefValidator
    TargetValidator listenerComponentValidator = null;
    
    protected AbstractListenerComponentValidator(CompositeType type){
        super(type);
    }
    
    public void setListenerComponentValidator(TargetValidator targetValidator){
        this.listenerComponentValidator = targetValidator;
    }
    
    public void validate(CompositeData target){
        super.validate(target);
        assertNotNull("This Validator must have a TargetValidator to validate listener component", listenerComponentValidator);
        listenerComponentValidator.validate(Util.decode((Byte[])target.get(BlueprintMetadataMBean.LISTENER_COMPONENT)));
    }
}