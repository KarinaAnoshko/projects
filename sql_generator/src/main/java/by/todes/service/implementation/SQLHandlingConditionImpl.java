package by.todes.service.implementation;

import by.todes.service.interfaces.utilitiesAndConstants.Condition;

import java.util.Arrays;
import java.util.List;

public class SQLHandlingConditionImpl {

    public String processCondition(String condition, String... fieldsAndValues) {
        String result = "";
        switch (condition){
            case Condition.FIELD_EQUAL_VALUE:
                result = processEqualField(fieldsAndValues);
                break;
        }
        return result;
    }

    private String processEqualField(String... fieldAndValue) {
        List<String> fieldValue = Arrays.asList(fieldAndValue);
        for (int i = 0; i < (fieldAndValue.length / 2); i++) {
            int j = i + 1;
            fieldAndValue[i] = fieldValue.get(i) + " = " + fieldValue.get(j);
            fieldValue.remove(j);
        }
        return String.join(" AND ", fieldAndValue);
    }

}
