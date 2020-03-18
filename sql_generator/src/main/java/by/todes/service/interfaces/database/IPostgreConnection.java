package by.todes.service.interfaces.database;

import by.todes.service.implementation.ResultSetProcessingViaReflection;

import javax.persistence.Column;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.todes.service.interfaces.utilitiesAndConstants.IUtils.getCredential;

public interface IPostgreConnection<EntityType> extends IConnectionDB {

    String driver = "org.postgresql.Driver";
    String dbProperties = "database";
    String url = getCredential(dbProperties, "url");
    String userName = getCredential(dbProperties, "user");
    String pass = getCredential(dbProperties, "password");

    EntityType entity;


    @Override
    default Connection connect() throws ClassNotFoundException, SQLException{
        Class.forName(driver);
        return DriverManager.getConnection(url, userName, pass);
    }

    default EntityType executeQuery(EntityType entity, String query, ResultSetProcessingViaReflection handlerRS) throws SQLException, ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException{
        Connection connection = connect();
        ResultSet resultSet = connection.prepareStatement(query).executeQuery();
        List<EntityType> resultList = new ArrayList<>();
        while (resultSet.next()){

            resultList.add(handlerRS.processingResultSet(resultSet, entity, Column.class));
        }
        return resultList.get(0);
    }
}
