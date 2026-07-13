package com.arun.cucumber;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterByTypeTransformer;
import io.cucumber.datatable.TableCellByTypeTransformer;
import io.cucumber.datatable.TableEntryByTypeTransformer;


import java.lang.reflect.Type;
import java.util.Locale;
import java.util.Map;

public class CucumberTypeRegistryConfigurer implements TypeRegistryConfigurer {

    private ObjectMapper mapper;

    public CucumberTypeRegistryConfigurer() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
    }

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        Transformer transformer = new Transformer();
        typeRegistry.setDefaultDataTableCellTransformer(transformer);
        typeRegistry.setDefaultDataTableEntryTransformer(transformer);
        typeRegistry.setDefaultParameterTransformer(transformer);
    }

    private class Transformer implements ParameterByTypeTransformer, TableEntryByTypeTransformer, TableCellByTypeTransformer {
        @Override
        public Object transform(String fromValue, Type toValueType) throws Throwable {
            return mapper.convertValue(fromValue, mapper.constructType(toValueType));
        }

        /**
         * Transforms single cell to type {@code T}
         *
         * @param value    cell
         * @param cellType expected cell type
         * @return an instance of {@code T}
         */
        @Override
        public <T> T transform(String value, Class<T> cellType) throws Throwable {
            return mapper.convertValue(value, cellType);
        }

        /**
         * This method should transform row represented by key-value map to object of type {@code type}
         *
         * @param entry           table entry, key - column name, value - cell
         * @param type            type of an expected object to return
         * @param cellTransformer cell transformer
         * @return new instance of {@code type}
         */
        @Override
        public <T> T transform(Map<String, String> entry, Class<T> type, TableCellByTypeTransformer cellTransformer) throws Throwable {
            return mapper.convertValue(entry, type);
        }
    }
}
