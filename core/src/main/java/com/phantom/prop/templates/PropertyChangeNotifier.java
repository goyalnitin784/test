package com.phantom.prop.templates;

import com.phantom.prop.change.ReloadableProperty;
import com.phantom.prop.templates.PropertyChangeListener;

/**
 * Classes interested in property changes should regsiter themselves with instace of this
 * class
 *
 * @author nitin.goyal
 */
public interface PropertyChangeNotifier {

    void registerForChanges(PropertyChangeListener listener);

    void addPropertyManager(ReloadableProperty properties);

    void notifyListeners();
}
