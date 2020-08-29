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
package io.yupiik.camel.sample.fintech.platform.entrypoint.api;

import java.util.Random;
import java.util.UUID;

public class AccountDetail {

    private String resourceId; // "3dc3d5b3-7023-4848-9853-f5400a64e80f"
    private String iban;//": "FR7612345987650123456789014",
    private String currency;//": "EUR",
    private String ownerName;//": "Heike Mustermann",
    private String product;//": "Girokonto",
    private String cashAccountType;//": "CACC",
    private String Name;//": "Main Account",

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCashAccountType() {
        return cashAccountType;
    }

    public void setCashAccountType(String cashAccountType) {
        this.cashAccountType = cashAccountType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public static AccountDetail mock() {
        AccountDetail accountDetail = new AccountDetail();
        accountDetail.setResourceId(UUID.randomUUID().toString());
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int cpt = 0; cpt < 25; cpt++) {
            sb.append(random.ints(0, 9).iterator().nextInt());
        }
        accountDetail.setIban("FR" + sb);
        accountDetail.setCurrency("EUR");
        accountDetail.setOwnerName("Heike Mustermann");
        accountDetail.setProduct("Girokonto");
        accountDetail.setCashAccountType("CACC");
        accountDetail.setName("Main Account");
        return accountDetail;
    }
}
