package com.alcano.glacier.gameobject.component;

import java.util.List;

public interface ComponentHolder {

    <T extends Component> T addComponent(Class<T> componentClass);
    <T extends Component> void removeComponent(Class<T> componentClass);
    <T extends Component> void removeComponents(Class<T> componentClass);
    <T extends Component> T getComponent(Class<T> componentClass);
    <T extends Component> List<T> getComponents(Class<T> componentClass);

}
