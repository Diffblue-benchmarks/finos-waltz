package org.finos.waltz.model.measurable_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.UserTimestamp;
import org.finos.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand.Builder;
import org.finos.waltz.model.measurable_rating.ImmutableRemoveMeasurableRatingCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRemoveMeasurableRatingCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.entityReference(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code MeasurableRatingCommand}.
   * <ul>
   *   <li>Then builder build measurableId is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; then builder build measurableId is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_thenBuilderBuildMeasurableIdIsOne() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertEquals(1L, builderResult.build().measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MeasurableRatingCommand)} with {@code MeasurableRatingCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableRatingCommand) with 'MeasurableRatingCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MeasurableRatingCommand)"})
  void testBuilderFromWithMeasurableRatingCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    MeasurableRatingCommand instance = mock(MeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#from(RemoveMeasurableRatingCommand)} with {@code RemoveMeasurableRatingCommand}.
   * <p>
   * Method under test: {@link Builder#from(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RemoveMeasurableRatingCommand) with 'RemoveMeasurableRatingCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RemoveMeasurableRatingCommand)"})
  void testBuilderFromWithRemoveMeasurableRatingCommand() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    RemoveMeasurableRatingCommand instance = mock(RemoveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenReturn(mock(UserTimestamp.class));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
    assertEquals(1L, builderResult.build().measurableId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RemoveMeasurableRatingCommand)} with {@code RemoveMeasurableRatingCommand}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RemoveMeasurableRatingCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RemoveMeasurableRatingCommand) with 'RemoveMeasurableRatingCommand'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RemoveMeasurableRatingCommand)"})
  void testBuilderFromWithRemoveMeasurableRatingCommand_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();
    RemoveMeasurableRatingCommand instance = mock(RemoveMeasurableRatingCommand.class);
    when(instance.lastUpdate()).thenThrow(new IllegalStateException("instance"));
    when(instance.measurableId()).thenReturn(1L);
    when(instance.entityReference()).thenReturn(mock(EntityReference.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).entityReference();
    verify(instance).lastUpdate();
    verify(instance).measurableId();
  }

  /**
   * Test Builder {@link Builder#lastUpdate(UserTimestamp)}.
   * <ul>
   *   <li>When {@link UserTimestamp}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#lastUpdate(UserTimestamp)}
   */
  @Test
  @DisplayName("Test Builder lastUpdate(UserTimestamp); when UserTimestamp; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.lastUpdate(UserTimestamp)"})
  void testBuilderLastUpdate_whenUserTimestamp_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.lastUpdate(mock(UserTimestamp.class)));
  }

  /**
   * Test Builder {@link Builder#measurableId(long)}.
   * <p>
   * Method under test: {@link Builder#measurableId(long)}
   */
  @Test
  @DisplayName("Test Builder measurableId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.measurableId(long)"})
  void testBuilderMeasurableId() {
    // Arrange
    Builder builderResult = ImmutableRemoveMeasurableRatingCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.measurableId(1L));
  }

  /**
   * Test Json {@link Json#entityReference()}.
   * <p>
   * Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityReference());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setLastUpdate(UserTimestamp)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setEntityReference(EntityReference)",
      "void Json.setLastUpdate(UserTimestamp)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEntityReference(null);
    actualJson.setLastUpdate(null);

    // Assert
    assertNull(actualJson.entityReference);
    assertNull(actualJson.lastUpdate);
    assertEquals(0L, actualJson.measurableId);
    assertFalse(actualJson.measurableIdIsSet);
  }

  /**
   * Test Json {@link Json#lastUpdate()}.
   * <p>
   * Method under test: {@link Json#lastUpdate()}
   */
  @Test
  @DisplayName("Test Json lastUpdate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserTimestamp Json.lastUpdate()"})
  void testJsonLastUpdate() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).lastUpdate());
  }

  /**
   * Test Json {@link Json#measurableId()}.
   * <p>
   * Method under test: {@link Json#measurableId()}
   */
  @Test
  @DisplayName("Test Json measurableId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.measurableId()"})
  void testJsonMeasurableId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).measurableId());
  }

  /**
   * Test Json {@link Json#setMeasurableId(long)}.
   * <p>
   * Method under test: {@link Json#setMeasurableId(long)}
   */
  @Test
  @DisplayName("Test Json setMeasurableId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setMeasurableId(long)"})
  void testJsonSetMeasurableId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setMeasurableId(1L);

    // Assert
    assertEquals(1L, json.measurableId);
    assertTrue(json.measurableIdIsSet);
  }
}
