package vn.dnict.tintuc.utils;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
 
public class PortletPropertyReaderUtil {
     
    public static Configuration getConfiguration() 
    { 
        Configuration configuration = ConfigurationFactoryUtil
                .getConfiguration(PortalClassLoaderUtil.getClassLoader(), "portlet");
        return configuration; 
    } 
     
}
