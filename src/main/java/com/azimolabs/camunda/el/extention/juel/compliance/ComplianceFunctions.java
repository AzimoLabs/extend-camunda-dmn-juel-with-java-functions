package com.azimolabs.camunda.el.extention.juel.compliance;

import com.azimolabs.camunda.service.document.DocumentService;

public class ComplianceFunctions {

    private static final DocumentService documentService;

    static {
        documentService = DocumentService.get();
    }

    public static boolean userHasVerifiedAndAcceptedDocument(Integer userId, String documentType) {
        return documentService.userHasVerifiedAndAcceptedDocument(userId, documentType);
    }

}
