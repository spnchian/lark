package domain;

import java.util.List;
@Document(collection=typedSettingKeys)
public class TypedSettingKey {

    private DataType dataType;

    private List<Property> properties;

    private String keyName;

    public TypedSettingKey(DataType dataType, List<Property> properties, String keyName) {
        this.dataType = dataType;
        this.properties = properties;
        this.keyName = keyName;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public boolean validValueForDataType(Object val){
        return val != null && dataType.isValid(val);
    }

    public boolean hasProperty(Property property){
        return CollectionUtils.isNotEmpty(properties) && property != null && properties.contains(property);
    }
}
