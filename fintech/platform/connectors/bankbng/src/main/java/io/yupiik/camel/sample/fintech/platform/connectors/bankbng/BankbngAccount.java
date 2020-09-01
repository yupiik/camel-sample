/*
 * Copyright (C) 2020 - Yupiik SAS - https://www.yupiik.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.yupiik.camel.sample.fintech.platform.connectors.bankbng;

public class BankbngAccount {

    private String acID;
    private String acIban;
    private String acLabel;
    private String acOwnerFirstname;
    private String acOwnerLastname;
    private String acType;
    private String acCurrency;
    private String acPackage;

    public String getAcID() {
        return acID;
    }

    public void setAcID(String acID) {
        this.acID = acID;
    }

    public String getAcIban() {
        return acIban;
    }

    public void setAcIban(String acIban) {
        this.acIban = acIban;
    }

    public String getAcLabel() {
        return acLabel;
    }

    public void setAcLabel(String acLabel) {
        this.acLabel = acLabel;
    }

    public String getAcOwnerFirstname() {
        return acOwnerFirstname;
    }

    public void setAcOwnerFirstname(String acOwnerFirstname) {
        this.acOwnerFirstname = acOwnerFirstname;
    }

    public String getAcOwnerLastname() {
        return acOwnerLastname;
    }

    public void setAcOwnerLastname(String acOwnerLastname) {
        this.acOwnerLastname = acOwnerLastname;
    }

    public String getAcType() {
        return acType;
    }

    public void setAcType(String acType) {
        this.acType = acType;
    }

    public String getAcCurrency() {
        return acCurrency;
    }

    public void setAcCurrency(String acCurrency) {
        this.acCurrency = acCurrency;
    }

    public String getAcPackage() {
        return acPackage;
    }

    public void setAcPackage(String acPackage) {
        this.acPackage = acPackage;
    }
}
