package com.realmeapi.document.account;

import com.realmeapi.document.contact.Contact;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
public class Account {

    private long id;
    private String password;
    private AccountStatus accountStatus;
}
