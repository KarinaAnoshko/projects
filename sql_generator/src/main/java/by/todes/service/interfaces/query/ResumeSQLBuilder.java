package by.todes.service.interfaces.query;

import by.todes.entity.Resume;
import by.todes.service.implementation.PostgreConnectionImpl;
import by.todes.service.implementation.ResultSetProcessingViaReflection;
import by.todes.service.interfaces.utilitiesAndConstants.SQLKeywords;
import by.todes.service.interfaces.utilitiesAndConstants.Statements;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static by.todes.service.interfaces.utilitiesAndConstants.IUtils.*;
import static by.todes.service.interfaces.utilitiesAndConstants.IValidation.existFields;
import static by.todes.service.interfaces.utilitiesAndConstants.IValidation.validationStatement;

public interface ResumeSQLBuilder extends ISQLQueryBuilder {

    @Override
    default ResumeSQLBuilder selectQueryWithCondition(String... fields){
        select(Statements.SELECT).fieldsSelect(fields).from().where();
        return this;
    }

    @Override
    default ResumeSQLBuilder select(String statement){
        entityFields.addAll(getEntityFields(Resume.class));
        validationStatement(statement);
        query.add(statement);
        return this;
    }

    @Override
    default ResumeSQLBuilder from(String... tableNames){
        query.add(SQLKeywords.FROM);
        if (tableNames.length == 0) {
            query.add(getEntityTableName(Resume.class));
        } else {
            query.add(joinByCommas(tableNames));
        }
        return this;
    }

    @Override
    default ResumeSQLBuilder fieldsSelect(String... fieldNames) {
        if (fieldNames.length == 0){
            query.add(SQLKeywords.ALL_FIELDS);
        } else {
            existFields(fieldNames);
            query.add(joinByCommas(fieldNames));
        }
        return this;
    }

    @Override
    default ResumeSQLBuilder where() {
        query.add(SQLKeywords.WHERE);
        return this;
    }

    @Override
    default ResumeSQLBuilder equal(String field, String value) {
        query.add(field + " = " + "'" + value + "'");
        return this;
    }

    @Override
    default ResumeSQLBuilder patternSearch(boolean fromStartString, String pattern) {
        StringBuilder partQueryResult = new StringBuilder().append(SQLKeywords.LIKE);
        if (fromStartString){
            partQueryResult.append(" '").append(pattern).append("%' ");
        } else {
            partQueryResult.append(" '%").append(pattern).append("'");
        }
        query.add(partQueryResult.toString());
        return this;
    }

    @Override
    default ResumeSQLBuilder and() {
        query.add(SQLKeywords.AND);
        return this;
    }

    @Override
    default String getQuery() {
        return String.join(" ", query) + ";";
    }

    default Resume getResult() throws IllegalAccessException, InvocationTargetException, InstantiationException, SQLException, NoSuchMethodException, ClassNotFoundException {
        return (Resume) new PostgreConnectionImpl()
                .executeQuery(Resume.class, getQuery(),
                        new ResultSetProcessingViaReflection());
    }
}
