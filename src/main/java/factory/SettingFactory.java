package factory;

import dao.SettingDao;
import dao.TypedSettingKeyDao;
import domain.InvalidSettingException;
import domain.Property;
import domain.Setting;
import domain.TypedSettingKey;

public class SettingFactory {

    TypedSettingKeyDao typedSettingKeyDao;

    SettingDao settingDao;


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
}
