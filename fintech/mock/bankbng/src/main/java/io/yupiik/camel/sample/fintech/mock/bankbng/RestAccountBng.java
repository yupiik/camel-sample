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
package io.yupiik.camel.sample.fintech.mock.bankbng;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
@Path("/accounts")
public class RestAccountBng {


    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getAllAccounts() {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int cpt = 0; cpt < 25; cpt++) {
            sb.append(random.ints(0, 9).iterator().nextInt());
        }

        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<accounts>\n" +
                "   <account>\n" +
                "       <acId>"+ UUID.randomUUID().toString() +"</acId>\n" +
                "       <acIban>FR" + sb + "</acIban>\n" +
                "       <acLabel>Main Account</acLabel>\n" +
                "       <acOwnerFirstname>Heike</acOwnerFirstname>\n" +
                "       <acOwnerLastname>Mustermann</acOwnerLastname>\n" +
                "       <acType>CACC</acType>\n" +
                "       <acCurrency>EUR</acCurrency>\n" +
                "       <acPackage>Girokonto</acPackage>\n" +
                "   </account>\n" +
                "</accounts>\n";
    }

}