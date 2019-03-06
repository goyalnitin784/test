package com.phantom.prop.change;

import com.phantom.logging.PhantomLogger;
import com.phantom.prop.templates.PropertyChangeListener;
import com.phantom.prop.templates.PropertyChangeNotifier;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * Wires listeners to notifiers instead of having this logic in constructors
 * @author nitin.goyal
 *
 */

@Component
public class AppPropertyChangePostProcessor implements BeanPostProcessor {

	
	@Autowired
	PropertyChangeNotifier notifier;
	
    PhantomLogger logger = PhantomLogger.getLoggerObject(this.getClass());

	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		if(bean instanceof ReloadableProperty)
		{
			logger.info("Registering " + beanName + " with propertyChangeNotifier as ReloadableProperty");
			notifier.addPropertyManager((ReloadableProperty)bean);
		}
		if(bean instanceof PropertyChangeListener)
		{
			logger.info("Registering " + beanName + " with propertyChangeNotifier as PropertyChangeListener");
			notifier.registerForChanges((PropertyChangeListener)bean);
		}
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

}
