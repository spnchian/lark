package factory;

import dao.SettingDao;
import dao.TypedSettingKeyDao;
import domain.DataType;
import domain.InvalidSettingException;
import domain.Property;
import domain.Setting;
import domain.TypedSettingKey;

import java.util.List;

@Component
public class SettingFactory {

    TypedSettingKeyDao typedSettingKeyDao;

    SettingDao settingDao;


    public SettingFactory(TypedSettingKeyDao typedSettingKeyDao, SettingDao settingDao){
        this.typedSettingKeyDao = typedSettingKeyDao;
        this.settingDao = settingDao;
    }

    public <T> boolean validateSetting(String keyName, T value){
        TypedSettingKey typedSettingKey = typedSettingKeyDao.get(keyName);
        return typedSettingKey != null && typedSettingKey.validValueForDataType(value);
    }

    public boolean typedSettingKeyHasProperty(String keyName, Property property){
        TypedSettingKey typedSettingKey = typedSettingKeyDao.get(keyName);
        return typedSettingKey != null && typedSettingKey.hasProperty(property);
    }

    public <T> Setting createSetting(String keyName, T value) throws InvalidSettingException{
        if(validateSetting(keyName, value)){
            return new Setting(keyName, value);
        }else{
            throw new InvalidSettingException("Specified value invalid for keyName");
        }
    }

    public TypedSettingKey createTypedSettingKey(String keyName, DataType dataType, List<Property> properties){
        return new TypedSettingKey(dataType,properties, keyName);
    }


}
