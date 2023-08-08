package io.github.drednote.telegram.updatehandler.scenario;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.drednote.telegram.updatehandler.UpdateHandlerProperties;
import io.github.drednote.telegram.updatehandler.scenario.configurer.ScenarioMachineConfigurerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
class ScenarioMachineContainerTest {

  ScenarioMachineContainer container;

  @BeforeEach
  void setUp() {
    ScenarioMachineConfigurerImpl configurer = new ScenarioMachineConfigurerImpl();
    container = new ScenarioMachineContainer(configurer, new UpdateHandlerProperties());
  }

  @Test
  void shouldReturnInMemoryDefaultPersister() {
    assertThat(container.getScenarioPersister()).isInstanceOf(InMemoryScenarioPersister.class);
  }
}