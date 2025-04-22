package org.example;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> allowedPairs = new HashSet<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(int documentId, String username) {
        allowedPairs.add(username + ":" + documentId);
    }

    public boolean isAllowed(int documentId, String username) {
        return allowedPairs.contains(username + ":" + documentId);
    }
}
