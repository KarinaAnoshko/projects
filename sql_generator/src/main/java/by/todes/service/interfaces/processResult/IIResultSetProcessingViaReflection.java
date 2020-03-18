package by.todes.service.interfaces.processResult;

import javax.persistence.Column;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IIResultSetProcessingViaReflection<EntityType> {

    List<Class<? extends Annotation>> annotations = new ArrayList<>();

    default EntityType processingResultSet(ResultSet resultSet, EntityType entity, Class<? extends Annotation> annotation) throws SQLException, IllegalAccessException {
        for(Field field : entity.getClass().getDeclaredFields()) {
            if (!presentAnnotation(field, annotation)) continue;
            Object value = getValue(resultSet, field, annotation);
            field.setAccessible(true);
            field.set(entity, value);
        }
        return entity;
    }

    default boolean presentAnnotation(Field field, Class<? extends Annotation> annotation){
        return field.isAnnotationPresent(annotation);
    }

    default Object getValue(ResultSet resultSet, Field field, Class<? extends Annotation> annotation) throws SQLException {
        if(annotation == Column.class){
            return handlingColumnAnnotation(resultSet, field);
        } else {
            return null;
        }
    }

    default Object handlingColumnAnnotation(ResultSet resultSet, Field field) throws SQLException {
        Column column = field.getAnnotation(Column.class);
        if (field.getType() == String[].class) {
            return (String[]) resultSet.getArray(column.name()).getArray();
        } else {
            return resultSet.getObject(column.name());
        }
    }
}
