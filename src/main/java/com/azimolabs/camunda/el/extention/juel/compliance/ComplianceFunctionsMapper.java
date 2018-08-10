package com.azimolabs.camunda.el.extention.juel.compliance;

import com.azimolabs.camunda.exception.FunctionRegistrationFailedException;
import org.camunda.bpm.engine.impl.javax.el.FunctionMapper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ComplianceFunctionsMapper extends FunctionMapper {

    private final static String PREFIX = "compliance";
    private static Map<String, Method> functionCache = null;

    public Method resolveFunction(String prefix, String localName) {
        ensureFunctionMapInitialized();
        return functionCache.get(getFullFunctionName(prefix, localName));
    }

    private String getFullFunctionName(String prefix, String localName) {
        return prefix + ":" + localName;
    }

    private void ensureFunctionMapInitialized() {
        if (functionCache == null) {
            synchronized (ComplianceFunctionsMapper.class) {
                if (functionCache == null) {
                    functionCache = new HashMap<>();
                    createMethodBindings();
                }
            }
        }
    }

    private void createMethodBindings() {
        try {
            functionCache.put(
                    getFullFunctionName(PREFIX, "userHasVerifiedAndAcceptedDocument"),
                    ComplianceFunctions.class.getMethod("userHasVerifiedAndAcceptedDocument", Integer.class, String.class)
            );
        } catch (Exception ex) {
            throw new FunctionRegistrationFailedException(ex);
        }
    }

}