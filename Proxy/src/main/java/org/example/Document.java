package org.example;

import java.util.Date;

public interface Document {
    int getId();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
