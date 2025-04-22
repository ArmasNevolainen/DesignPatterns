package org.example;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<Integer, Document> documents = new HashMap<>();

    public void addUnprotectedDocument(int id, Date creationDate, String content) {
        documents.put(id, new RealDocument(id, creationDate, content));
    }

    public void addProtectedDocument(int id, Date creationDate, String content, String... allowedUsers) {
        RealDocument realDoc = new RealDocument(id, creationDate, content);
        ProxyDocument proxy = new ProxyDocument(realDoc);
        documents.put(id, proxy);

        AccessControlService acs = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            acs.allowAccess(id, user);
        }
    }

    public Document getDocument(int id) {
        return documents.get(id);
    }
}
