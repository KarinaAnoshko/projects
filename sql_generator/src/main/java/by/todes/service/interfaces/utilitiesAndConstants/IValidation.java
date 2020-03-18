package by.todes.service.interfaces.utilitiesAndConstants;

import java.util.Arrays;

import static by.todes.service.interfaces.query.ISQLQueryBuilder.entityFields;

public interface IValidation {

    static void existFields(String[] fieldNames) {
        boolean allFieldsCorrect = Arrays.stream(fieldNames).allMatch(entityFields::contains);
        if(!allFieldsCorrect){
            throw new IllegalArgumentException("Incorrect field name in fieldsSelect() method." +
                    "Available fields: " + String.join(", ", entityFields));
        }
    }

    static boolean validationStatement(String statement){
        switch (statement.toUpperCase()){
            case Statements.SELECT:
            case Statements.UPDATE:
            case Statements.INSERT:
            case Statements.DELETE:
                return true;
            default:throw new IllegalArgumentException("Incorrect statement in createQuery() method. " +
                    "Available statements in createQuery(): 'SELECT', 'UPDATE', 'INSERT INTO', 'DELETE FROM'. " +
                    "Use statement constants: Statements.SELECT");

        }
    };


}
