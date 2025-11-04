package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.finos.waltz.service.actor.ActorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

class ActorHelperDiffblueTest {
  /**
   * Method under test: {@link ActorHelper#createActor(String)}
   */
  @Test
  void testCreateActor() {
    // Arrange
    ActorService actorService = mock(ActorService.class);
    when(actorService.create(Mockito.<ActorCreateCommand>any(), Mockito.<String>any())).thenReturn(1L);
    ActorHelper actorHelper = new ActorHelper();
    ReflectionTestUtils.setField(actorHelper, "actorService", actorService);

    // Act
    Long actualCreateActorResult = actorHelper.createActor("Name Stem");

    // Assert
    verify(actorService).create(isA(ActorCreateCommand.class), eq("actorHelper"));
    assertEquals(1L, actualCreateActorResult.longValue());
  }
}
