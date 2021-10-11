package de.uni_passau.fim.scientistsPortal.annotation;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.AfterDeploymentValidation;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import jakarta.enterprise.inject.spi.Extension;
import jakarta.enterprise.inject.spi.ProcessBean;

import java.util.ArrayList;
import java.util.List;

public class EagerExtension implements Extension {

    private List<Bean<?>> eagerBeansList = new ArrayList<Bean<?>>();

    public <T> void collect(@Observes ProcessBean<T> event) {
        if (event.getAnnotated().isAnnotationPresent(Eager.class)
                && event.getAnnotated().isAnnotationPresent(
                ApplicationScoped.class)) {
            eagerBeansList.add(event.getBean());
        }
    }

    public void load(@Observes AfterDeploymentValidation event,
                     BeanManager beanManager) {
        for (Bean<?> bean : eagerBeansList) {
            // note that toString() is important to instantiate the bean
            beanManager.getReference(bean, bean.getBeanClass(),
                    beanManager.createCreationalContext(bean)).toString();
        }
    }

}

