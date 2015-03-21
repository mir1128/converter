package com.looobo.converter.impl;

import com.looobo.converter.DefinitionLoaderInterface;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TableDefinitionLoaderTest {

    @Test
    public void testGetDefinition() throws Exception {
        DefinitionLoaderInterface loaderInterface = new TableDefinitionLoader("test_table_definition.properties");

        Map<String, Object> definition = loaderInterface.getDefinition(this.getClass().getClassLoader());

        assertEquals(definition.get("temp_support_applying"), "a,b,c,d");
    }
}