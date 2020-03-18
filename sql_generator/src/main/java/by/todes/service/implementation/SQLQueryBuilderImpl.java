package by.todes.service.implementation;

import by.todes.service.interfaces.SQLQueryBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.todes.service.interfaces.utilitiesAndConstants.IValidation.*;
import static by.todes.service.interfaces.utilitiesAndConstants.IUtils.*;

public class SQLQueryBuilderImpl implements SQLQueryBuilder {

    private String tableName;
    private Object entity;
    private List<String> query;
    public static List<String> entityFields;
    private Map<String, String> parametersQuery;

    public SQLQueryBuilderImpl(Object entity){
        entityFields = getEntityFields(entity.getClass());
        this.entity = entity;
        this.tableName = entity.getClass().getSimpleName().toLowerCase();
        this.query = new ArrayList<>();
        this.parametersQuery = new HashMap<>();
    }

    @Override
    public SQLQueryBuilder createQuery(String statement) {
        validationStatement(statement);
        query.add(statement);
        return this;
    }

    @Override
    public SQLQueryBuilder fieldsSelect(String... fieldNames) {
        existFields(fieldNames);
        if (fieldNames.length == 0){
            query.add("*");
        } else {
           String fields = String.join(", ", fieldNames);
           query.add(fields);
        }
        return this;
    }

    @Override
    public SQLQueryBuilder from(String... tableNames) {
        query.add("FROM");
        if (tableNames.length == 0) {
            query.add(tableName);
        } else {
            String tables = String.join(", ", tableNames);
            query.add(tables);
        }
        return this;
    }

    @Override
    public SQLQueryBuilder whereWithCondition(String condition, String... fieldsAndValue) {
        query.add("WHERE");
        String queryConditionPart = new SQLHandlingConditionImpl().processCondition(condition, fieldsAndValue);
        query.add(queryConditionPart);
        return this;
    }

    @Override
    public SQLQueryBuilder where() {
        query.add("WHERE");
        return this;
    }

    @Override
    public SQLQueryBuilder equal(String field, String value) {
        query.add(field + " = " + value);
        return this;
    }

    @Override
    public SQLQueryBuilder patternSearch(boolean fromStartString, String pattern) {
        if (fromStartString){
            query.add("LIKE '" + pattern + "%'");
        } else {
            query.add("LIKE '%" + pattern + "'");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder and() {
        query.add("AND");
        return this;
    }

    @Override
    public String getResult() {
        return String.join(" ", query) + ";";
    }

}
