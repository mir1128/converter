package com.looobo.converter.impl;

import com.looobo.converter.ConfigureLoaderInterface;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TableConfigureParserTest {

    @Test
    public void testGetTableDefinition() throws Exception {
        ConfigureLoaderInterface loaderInterface = new ConfigureLoader("test_table_definition.properties");

        Map<String, Object> definition = loaderInterface.getConfigure(this.getClass().getClassLoader());

        TableConfigureParser tableConfigureParser = new TableConfigureParser(definition);

        List<String> def = tableConfigureParser.getTableDefinition("temp_support_applying");

        assertArrayEquals(new String[]{"a", "b", "c", "d"}, def.toArray());
    }
}
