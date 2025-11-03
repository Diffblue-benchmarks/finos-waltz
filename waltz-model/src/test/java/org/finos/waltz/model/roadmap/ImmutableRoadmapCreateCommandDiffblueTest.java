package org.finos.waltz.model.roadmap;

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
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand.Builder;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#columnType(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#columnType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder columnType(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnType(EntityReference)"})
  void testBuilderColumnType_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnType(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RoadmapCreateCommand)} with {@code RoadmapCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapCreateCommand) with 'RoadmapCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapCreateCommand)"})
  void testBuilderFromWithRoadmapCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.rowType()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).rowType();
  }

  /**
   * Test Builder {@link Builder#from(RoadmapCreateCommand)} with {@code RoadmapCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapCreateCommand) with 'RoadmapCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapCreateCommand)"})
  void testBuilderFromWithRoadmapCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.columnType()).thenThrow(new IllegalStateException("instance"));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).rowType();
  }

  /**
   * Test Builder {@link Builder#from(RoadmapCreateCommand)} with {@code RoadmapCreateCommand}.
   * <p>
   * Method under test: {@link Builder#from(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapCreateCommand) with 'RoadmapCreateCommand'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapCreateCommand)"})
  void testBuilderFromWithRoadmapCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.ratingSchemeId()).thenThrow(new IllegalStateException("instance"));
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
  }

  /**
   * Test Builder {@link Builder#from(RoadmapCreateCommand)} with {@code RoadmapCreateCommand}.
   * <ul>
   *   <li>Then builder build name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapCreateCommand) with 'RoadmapCreateCommand'; then builder build name is 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RoadmapCreateCommand)"})
  void testBuilderFromWithRoadmapCreateCommand_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();
    RoadmapCreateCommand instance = mock(RoadmapCreateCommand.class);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.linkedEntity()).thenReturn(mock(EntityReference.class));
    when(instance.columnType()).thenReturn(mock(EntityReference.class));
    when(instance.rowType()).thenReturn(mock(EntityReference.class));
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    verify(instance).columnType();
    verify(instance).linkedEntity();
    verify(instance).ratingSchemeId();
    verify(instance).rowType();
    ImmutableRoadmapCreateCommand buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#linkedEntity(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#linkedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder linkedEntity(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.linkedEntity(EntityReference)"})
  void testBuilderLinkedEntity_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.linkedEntity(mock(EntityReference.class)));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Test Builder {@link Builder#rowType(EntityReference)}.
   * <ul>
   *   <li>When {@link EntityReference}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rowType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder rowType(EntityReference); when EntityReference; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rowType(EntityReference)"})
  void testBuilderRowType_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rowType(mock(EntityReference.class)));
  }

  /**
   * Test Json {@link Json#columnType()}.
   * <p>
   * Method under test: {@link Json#columnType()}
   */
  @Test
  @DisplayName("Test Json columnType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.columnType()"})
  void testJsonColumnType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnType());
  }

  /**
   * Test Json getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setColumnType(EntityReference)}
   *   <li>{@link Json#setLinkedEntity(EntityReference)}
   *   <li>{@link Json#setName(String)}
   *   <li>{@link Json#setRowType(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()", "void Json.setColumnType(EntityReference)",
      "void Json.setLinkedEntity(EntityReference)", "void Json.setName(String)",
      "void Json.setRowType(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setColumnType(null);
    actualJson.setLinkedEntity(null);
    actualJson.setName("Name");
    actualJson.setRowType(null);

    // Assert
    assertEquals("Name", actualJson.name);
    assertNull(actualJson.columnType);
    assertNull(actualJson.linkedEntity);
    assertNull(actualJson.rowType);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.ratingSchemeIdIsSet);
  }

  /**
   * Test Json {@link Json#linkedEntity()}.
   * <p>
   * Method under test: {@link Json#linkedEntity()}
   */
  @Test
  @DisplayName("Test Json linkedEntity()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.linkedEntity()"})
  void testJsonLinkedEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).linkedEntity());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeId());
  }

  /**
   * Test Json {@link Json#rowType()}.
   * <p>
   * Method under test: {@link Json#rowType()}
   */
  @Test
  @DisplayName("Test Json rowType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityReference Json.rowType()"})
  void testJsonRowType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rowType());
  }

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   * <p>
   * Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setRatingSchemeId(long)"})
  void testJsonSetRatingSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }
}
