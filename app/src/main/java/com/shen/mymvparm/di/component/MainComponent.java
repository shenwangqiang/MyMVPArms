package com.shen.mymvparm.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;
import com.shen.mymvparm.di.module.MainModule;
import com.shen.mymvparm.mvp.ui.activity.MainActivity;


@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity activity);
}