package by.todes.service.interfaces.query;

public interface IQueryBuilder {

    IQueryBuilder selectQueryWithCondition(String... fields);
    IQueryBuilder select(String statement);
    IQueryBuilder fieldsSelect(String... fieldNames);
    IQueryBuilder from(String ... tableNames);
    IQueryBuilder where();
    IQueryBuilder equal(String field, String value);
    IQueryBuilder patternSearch(boolean fromStartString, String pattern);
    IQueryBuilder and();
    String getQuery();

}
