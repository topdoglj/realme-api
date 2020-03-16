package com.realmeapi.document;

import com.realmeapi.document.account.Account;
import com.realmeapi.document.contact.Contact;
import com.realmeapi.document.identity.Identity;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    private long id;
    private String name;
    private Account account;
    private Contact contact;
    private Identity identity;
}

