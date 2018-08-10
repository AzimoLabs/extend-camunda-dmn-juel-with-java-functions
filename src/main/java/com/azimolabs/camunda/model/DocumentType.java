package com.azimolabs.camunda.model;

import com.azimolabs.camunda.exception.NotSupportedDocumentTypeException;

public enum DocumentType {

    PROOF_OF_IDENTITY, PROOF_OF_ADDRESS;

    public static DocumentType of(String shortName) {
        switch (shortName) {
            case "PROOF_OF_IDENTITY":
                return DocumentType.PROOF_OF_IDENTITY;
            case "PROOF_OF_ADDRESS":
                return DocumentType.PROOF_OF_ADDRESS;
            default:
                throw new NotSupportedDocumentTypeException(String.format("Not supported document type: '%s'", shortName));
        }
    }
}
