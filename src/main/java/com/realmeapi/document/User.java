package com.realmeapi.document;

import com.realmeapi.document.account.Account;
import com.realmeapi.document.address.Address;
import com.realmeapi.document.contact.Contact;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user")
public class User {
    private long id;
    private String name;
    private Account account;
    private Contact contact;
}

