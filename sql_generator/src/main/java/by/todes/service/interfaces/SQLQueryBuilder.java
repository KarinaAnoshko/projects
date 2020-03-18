package by.todes.service.interfaces;

public interface SQLQueryBuilder extends IQueryBuilder {
    @Override
    SQLQueryBuilder createQuery(String statement);
    SQLQueryBuilder fieldsSelect(String... fieldNames) throws NoSuchFieldException;
    SQLQueryBuilder from(String ... tableNames);
    SQLQueryBuilder where();
    SQLQueryBuilder equal(String field, String value);
    SQLQueryBuilder patternSearch(boolean fromStartString, String pattern);
    SQLQueryBuilder and();
    SQLQueryBuilder whereWithCondition(String condition, String... fieldsAndValue);
    String getResult();
}
