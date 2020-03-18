package by.todes.service.interfaces.query;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ISQLQueryBuilder extends IQueryBuilder {

    List<String> query = new ArrayList<>();
    List<String> entityFields = new ArrayList<>();

    @Override
    ISQLQueryBuilder select(String statement);

    @Override
    ISQLQueryBuilder selectQueryWithCondition(String... fields);

    ISQLQueryBuilder from(String ... tableNames);

    @Override
    ISQLQueryBuilder fieldsSelect(String... fieldNames);

    @Override
    ISQLQueryBuilder where();

    @Override
    ISQLQueryBuilder equal(String field, String value);

    @Override
    ISQLQueryBuilder patternSearch(boolean fromStartString, String pattern);

    @Override
    ISQLQueryBuilder and();

    Object getResult() throws IllegalAccessException, SQLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException;

    @Override
    String getQuery();
}
