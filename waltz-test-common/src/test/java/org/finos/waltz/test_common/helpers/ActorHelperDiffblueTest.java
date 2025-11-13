package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.actor.ActorCreateCommand;
import org.finos.waltz.service.actor.ActorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ActorHelperDiffblueTest {
  @InjectMocks private ActorHelper actorHelper;

  @Mock private ActorService actorService;

  /**
   * Test {@link ActorHelper#createActor(String)}.
   *
   * <p>Method under test: {@link ActorHelper#createActor(String)}
   */
  @Test
  @DisplayName("Test createActor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long ActorHelper.createActor(String)"})
  void testCreateActor() {
    // Arrange
    when(actorService.create(Mockito.<ActorCreateCommand>any(), Mockito.<String>any()))
        .thenReturn(1L);

    // Act
    Long actualCreateActorResult = actorHelper.createActor("Name Stem");

    // Assert
    verify(actorService).create(isA(ActorCreateCommand.class), eq("actorHelper"));
    assertEquals(1L, actualCreateActorResult.longValue());
  }
}
