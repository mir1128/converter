package com.looobo.converter;

import java.util.Map;

public interface DefinitionLoaderInterface {
    public Map<String, Object> getDefinition(ClassLoader loader);
}
