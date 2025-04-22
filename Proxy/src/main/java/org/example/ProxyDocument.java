package org.example;

import java.util.Date;

public class ProxyDocument implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public ProxyDocument(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public int getId() {
        return realDocument.getId();
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
