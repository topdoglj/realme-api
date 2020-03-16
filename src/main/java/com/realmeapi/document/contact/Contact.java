package com.realmeapi.document.contact;

import com.realmeapi.document.contact.address.Address;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "contact")
public class Contact {
    @Id
    private long id;
    private Email email;
    private Mobile mobile;
    private List<Address> addresses;
}
