package com.azimolabs.camunda.service.document;

import com.azimolabs.camunda.model.DocumentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(DocumentService.class);

    private static DocumentService documentServiceInstance;

    public boolean userHasVerifiedAndAcceptedDocument(Integer userId, String documentType) {
        return userHasVerifiedAndAcceptedDocument(userId, DocumentType.of(documentType));
    }

    private boolean userHasVerifiedAndAcceptedDocument(Integer userId, DocumentType documentType) {
        LOGGER.info("Verify if user with id '{}' has verified and required document '{}'", userId, documentType.name());

        boolean userHasVerifiedAndAcceptedDocument = false;
        // ...

        // Business logic implementation

        // ...

        return userHasVerifiedAndAcceptedDocument;
    }

    public static DocumentService get() {
        if (documentServiceInstance == null) {
            documentServiceInstance = new DocumentService();
        }
        return documentServiceInstance;
    }

}
