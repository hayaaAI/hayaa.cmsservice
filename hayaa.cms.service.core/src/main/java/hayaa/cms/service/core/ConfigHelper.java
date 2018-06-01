package hayaa.cms.service.core;

import Hayaa.ConfigSeed.ConfigTool;

class ConfigHelper extends ConfigTool<CMSConfig, CMSConfigRoot> {
    public static ConfigHelper getInstance() {
        return _instance;
    }

    private static ConfigHelper _instance = new ConfigHelper();

    private ConfigHelper() {
        super(DefineTable.CMSServiceComponentID, CMSConfig.class, CMSConfigRoot.class);
    }
}
