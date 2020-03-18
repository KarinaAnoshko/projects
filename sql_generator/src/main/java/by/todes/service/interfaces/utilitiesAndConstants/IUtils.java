package by.todes.service.interfaces.utilitiesAndConstants;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public interface IUtils {

    static List<String> getEntityFields(Class<?> entityClass){
        return Arrays.stream(entityClass.getDeclaredFields()).map(Field::getName)
                .collect(Collectors.toList());
    }

    static String joinByCommas(String[] array){
        return String.join(", ", array);
    }

    static String getEntityTableName(Class<?> entityClass){
        return entityClass.getSimpleName().toLowerCase();
    }

    static String getCredential(String dbProperties, String field){
        return ResourceBundle.getBundle(dbProperties).getString(field);
    }

    static Object instantiateObject(Class<?> entityClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return entityClass.getDeclaredConstructor().newInstance();
    }
}
