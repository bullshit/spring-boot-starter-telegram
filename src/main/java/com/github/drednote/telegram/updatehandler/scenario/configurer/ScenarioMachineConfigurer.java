package com.github.drednote.telegram.updatehandler.scenario.configurer;

import com.github.drednote.telegram.updatehandler.scenario.ScenarioMonitor;
import com.github.drednote.telegram.updatehandler.scenario.ScenarioPersister;

public sealed interface ScenarioMachineConfigurer permits ScenarioMachineConfigurerImpl {

  ScenarioConfigurer scenario();

  ScenarioMachineConfigurer withPersister(ScenarioPersister persister);
  ScenarioMachineConfigurer withMonitor(ScenarioMonitor monitor);
}
