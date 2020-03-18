package by.todes.service.implementation;

import by.todes.service.interfaces.query.ISQLQueryBuilder;
import by.todes.service.interfaces.utilitiesAndConstants.SQLKeywords;
import by.todes.service.interfaces.utilitiesAndConstants.Statements;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import static by.todes.service.interfaces.utilitiesAndConstants.IUtils.*;
import static by.todes.service.interfaces.utilitiesAndConstants.IValidation.existFields;
import static by.todes.service.interfaces.utilitiesAndConstants.IValidation.validationStatement;

public class EntitySqlBuilder<EntityType> implements ISQLQueryBuilder {

    EntityType entityType;

    public EntitySqlBuilder(EntityType entityType){
        this.entityType = entityType;
    }


    @Override
    public EntitySqlBuilder<EntityType> fieldsSelect(String... fieldNames) {
        if (fieldNames.length == 0){
            query.add(SQLKeywords.ALL_FIELDS);
        } else {
            existFields(fieldNames);
            query.add(joinByCommas(fieldNames));
        }
        return this;
    }

    @Override
    public EntitySqlBuilder<EntityType> where() {
        query.add(SQLKeywords.WHERE);
        return this;
    }

    @Override
    public EntitySqlBuilder<EntityType> equal(String field, String value) {
        query.add(field + " = " + value);
        return this;
    }

    @Override
    public EntitySqlBuilder<EntityType> patternSearch(boolean fromStartString, String pattern) {
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
    public EntitySqlBuilder<EntityType> and() {
        query.add(SQLKeywords.AND);
        return this;
    }

    @Override
    public String getQuery() {
        return String.join(" ", query) + ";";
    }

    @Override
    public EntitySqlBuilder<EntityType> selectQueryWithCondition(String... fields) {
        select(Statements.SELECT).fieldsSelect(fields).from().where();
        return this;
    }

    @Override
    public ISQLQueryBuilder select(String statement) {
        entityFields.addAll(getEntityFields(entityType.getClass()));
        validationStatement(statement);
        query.add(statement);
        return this;
    }

    @Override
    public EntitySqlBuilder<EntityType> from(String... tableNames) {
        query.add(SQLKeywords.FROM);
        if (tableNames.length == 0) {
            query.add(getEntityTableName(entityType.getClass()));
        } else {
            query.add(joinByCommas(tableNames));
        }
        return this;
    }

    public EntityType getResult() throws IllegalAccessException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        return new PostgreConnectionImpl()
                .executeQuery(entityType.getClass(),
                        getQuery(),
                        new ResultSetProcessingViaReflection());
    }
}
