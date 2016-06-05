package org.rubms.envvars4j.optionhandlers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ruben on 5/06/16.
 */
public class OptionHandlersRegistry {
    private Map<Class, AbstractOptionHandler> registry;

    public OptionHandlersRegistry() {
        registry = new HashMap();
        initRegistry();
    }

    private void initRegistry() {
        registry.put(int.class, new IntOptionHandler());
        registry.put(Integer.class, new IntObjectOptionHandler());

        registry.put(short.class, new ShortOptionHandler());
        registry.put(Short.class, new ShortObjectOptionHandler());

        registry.put(float.class, new FloatOptionHandler());
        registry.put(Float.class, new FloatObjectOptionHandler());

        registry.put(double.class, new DoubleOptionHandler());
        registry.put(Double.class, new DoubleObjectOptionHandler());

        registry.put(boolean.class, new BooleanOptionHandler());
        registry.put(Boolean.class, new BooleanObjectOptionHandler());

        registry.put(String.class, new StringOptionHandler());
    }

    public AbstractOptionHandler getHandler(Class c) throws UnsupportedTypeException {
        AbstractOptionHandler optionHandler = registry.get(c);
        if (optionHandler == null) {
            throw new UnsupportedTypeException(c);
        }
        return optionHandler;
    }
}
