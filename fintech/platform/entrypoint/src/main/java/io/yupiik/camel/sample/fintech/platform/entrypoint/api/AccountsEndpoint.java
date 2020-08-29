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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/accounts")
public class AccountsEndpoint {

    @GET
    public String getAllAccounts() {
        // stub
        return null;
    }

    @GET
    @Path("/{account-id}")
    public String getAccount(@PathParam("account-id") String accountId) {
        // stub
        return null;
    }

    @GET
    @Path("/{account-id}/balances")
    public String getAllAccountBalances(@PathParam("account-id") String accountId) {
        // stub
        return null;
    }

    @GET
    @Path("/{account-id}/transactions")
    public String getAllAccountTransactions(@PathParam("account-id") String accountId) {
        // stub
        return null;
    }

    @GET
    @Path("/{account-id}/transactions/{transaction-id}")
    public String getAccountTransaction(@PathParam("account-id") String accountId, @PathParam("transaction-id") String transactionId) {
        // stub
        return null;
    }
}
