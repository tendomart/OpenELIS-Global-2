/**
* The contents of this file are subject to the Mozilla Public License
* Version 1.1 (the "License"); you may not use this file except in
* compliance with the License. You may obtain a copy of the License at
* http://www.mozilla.org/MPL/ 
* 
* Software distributed under the License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
* License for the specific language governing rights and limitations under
* the License.
* 
* The Original Code is OpenELIS code.
* 
* Copyright (C) The Minnesota Department of Health.  All Rights Reserved.
*/
package org.openelisglobal.program.valueholder;

import java.util.UUID;

import javax.validation.constraints.Pattern;

import org.openelisglobal.common.validator.ValidationHelper;
import org.openelisglobal.common.valueholder.BaseObject;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = Visibility.NONE, setterVisibility = Visibility.NONE, getterVisibility = Visibility.NONE, isGetterVisibility = Visibility.NONE, creatorVisibility = Visibility.NONE)
public class Program extends BaseObject<String> {

    @JsonProperty("code")
    @Pattern(regexp = "(?i)^[a-z0-9_ ]*$")
    private String code;
    @JsonProperty("id")
    @Pattern(regexp = ValidationHelper.ID_REGEX)
    private String id;
    @JsonProperty("programName")
    @Pattern(regexp = "(?i)^[a-z0-9-_ ]*$")
    private String programName;
    @JsonProperty("questionnaireUUID")
    private UUID questionnaireUUID;

    public Program() {
        super();
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public String getProgramName() {
        return this.programName;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public UUID getQuestionnaireUUID() {
        return questionnaireUUID;
    }

    public void setQuestionnaireUUID(UUID questionnaireUUID) {
        this.questionnaireUUID = questionnaireUUID;
    }

}
