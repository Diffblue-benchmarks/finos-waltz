package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableDiagramCalloutCreateCommand.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableDiagramCalloutCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiagramCalloutCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiagramCalloutCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualImmutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Assert
    assertEquals("42", actualImmutableDiagramCalloutCreateCommand.cellExternalId());
    assertEquals("Dr", actualImmutableDiagramCalloutCreateCommand.title());
    assertEquals("End Color", actualImmutableDiagramCalloutCreateCommand.endColor());
    assertEquals(
        "Not all who wander are lost", actualImmutableDiagramCalloutCreateCommand.content());
    assertEquals("Start Color", actualImmutableDiagramCalloutCreateCommand.startColor());
    assertEquals(1L, actualImmutableDiagramCalloutCreateCommand.instanceId().longValue());
  }

  /**
   * Test Builder {@link Builder#cellExternalId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellExternalId(String)}
   */
  @Test
  @DisplayName("Test Builder cellExternalId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellExternalId(String)"})
  void testBuilderCellExternalId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualCellExternalIdResult = builderResult.cellExternalId("42");

    // Assert
    assertSame(builderResult, actualCellExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#content(String)}.
   *
   * <ul>
   *   <li>When {@code Not all who wander are lost}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#content(String)}
   */
  @Test
  @DisplayName(
      "Test Builder content(String); when 'Not all who wander are lost'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.content(String)"})
  void testBuilderContent_whenNotAllWhoWanderAreLost_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualContentResult = builderResult.content("Not all who wander are lost");

    // Assert
    assertSame(builderResult, actualContentResult);
  }

  /**
   * Test Builder {@link Builder#endColor(String)}.
   *
   * <ul>
   *   <li>When {@code End Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#endColor(String)}
   */
  @Test
  @DisplayName("Test Builder endColor(String); when 'End Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.endColor(String)"})
  void testBuilderEndColor_whenEndColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualEndColorResult = builderResult.endColor("End Color");

    // Assert
    assertSame(builderResult, actualEndColorResult);
  }

  /**
   * Test Builder {@link Builder#from(DiagramCalloutCreateCommand)}.
   *
   * <p>Method under test: {@link Builder#from(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(DiagramCalloutCreateCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DiagramCalloutCreateCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();
    ImmutableDiagramCalloutCreateCommand instance =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableDiagramCalloutCreateCommand actualImmutableDiagramCalloutCreateCommand =
        builderResult.build();
    assertEquals(instance, actualImmutableDiagramCalloutCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#instanceId(Long)}.
   *
   * <p>Method under test: {@link Builder#instanceId(Long)}
   */
  @Test
  @DisplayName("Test Builder instanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.instanceId(Long)"})
  void testBuilderInstanceId() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualInstanceIdResult = builderResult.instanceId(1L);

    // Assert
    assertSame(builderResult, actualInstanceIdResult);
  }

  /**
   * Test Builder {@link Builder#startColor(String)}.
   *
   * <ul>
   *   <li>When {@code Start Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#startColor(String)}
   */
  @Test
  @DisplayName("Test Builder startColor(String); when 'Start Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.startColor(String)"})
  void testBuilderStartColor_whenStartColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualStartColorResult = builderResult.startColor("Start Color");

    // Assert
    assertSame(builderResult, actualStartColorResult);
  }

  /**
   * Test Builder {@link Builder#title(String)}.
   *
   * <ul>
   *   <li>When {@code Dr}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#title(String)}
   */
  @Test
  @DisplayName("Test Builder title(String); when 'Dr'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.title(String)"})
  void testBuilderTitle_whenDr_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiagramCalloutCreateCommand.builder();

    // Act
    Builder actualTitleResult = builderResult.title("Dr");

    // Assert
    assertSame(builderResult, actualTitleResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#copyOf(DiagramCalloutCreateCommand)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDiagramCalloutCreateCommand#copyOf(DiagramCalloutCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(DiagramCalloutCreateCommand); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.copyOf(DiagramCalloutCreateCommand)"
  })
  void testCopyOf_thenReturnCellExternalIdIs42() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand instance =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualCopyOfResult =
        ImmutableDiagramCalloutCreateCommand.copyOf(instance);

    // Assert
    assertEquals("42", actualCopyOfResult.cellExternalId());
    assertEquals("Dr", actualCopyOfResult.title());
    assertEquals("End Color", actualCopyOfResult.endColor());
    assertEquals("Not all who wander are lost", actualCopyOfResult.content());
    assertEquals("Start Color", actualCopyOfResult.startColor());
    assertEquals(1L, actualCopyOfResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}, and {@link
   * ImmutableDiagramCalloutCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand2 =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableDiagramCalloutCreateCommand, immutableDiagramCalloutCreateCommand2);
    assertEquals(
        immutableDiagramCalloutCreateCommand.hashCode(),
        immutableDiagramCalloutCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}, and {@link
   * ImmutableDiagramCalloutCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(immutableDiagramCalloutCreateCommand, immutableDiagramCalloutCreateCommand);
    int expectedHashCodeResult = immutableDiagramCalloutCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableDiagramCalloutCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("Dr")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("42")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("42")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(2L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("42")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Mr")
            .build();

    // Act and Assert
    assertNotEquals(
        immutableDiagramCalloutCreateCommand,
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiagramCalloutCreateCommand.equals(Object)",
    "int ImmutableDiagramCalloutCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build(),
        "Different type to ImmutableDiagramCalloutCreateCommand");
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Json} (default constructor) StartColor is {@code Json}.
   *   <li>Then return cellExternalId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given one; when Json (default constructor) StartColor is 'Json'; then return cellExternalId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.fromJson(Json)"
  })
  void testFromJson_givenOne_whenJsonStartColorIsJson_thenReturnCellExternalIdIsJson() {
    // Arrange
    Json json = new Json();
    json.setInstanceId(1L);
    json.setCellExternalId("Json");
    json.setTitle("Json");
    json.setContent("Json");
    json.setStartColor("Json");
    json.setEndColor("Json");

    // Act
    ImmutableDiagramCalloutCreateCommand actualFromJsonResult =
        ImmutableDiagramCalloutCreateCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellExternalId());
    assertEquals("Json", actualFromJsonResult.content());
    assertEquals("Json", actualFromJsonResult.endColor());
    assertEquals("Json", actualFromJsonResult.startColor());
    assertEquals("Json", actualFromJsonResult.title());
    assertEquals(1L, actualFromJsonResult.instanceId().longValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#toString()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#cellExternalId()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#content()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#endColor()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#instanceId()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#startColor()}
   *   <li>{@link ImmutableDiagramCalloutCreateCommand#title()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableDiagramCalloutCreateCommand.cellExternalId()",
    "String ImmutableDiagramCalloutCreateCommand.content()",
    "String ImmutableDiagramCalloutCreateCommand.endColor()",
    "Long ImmutableDiagramCalloutCreateCommand.instanceId()",
    "String ImmutableDiagramCalloutCreateCommand.startColor()",
    "String ImmutableDiagramCalloutCreateCommand.title()",
    "String ImmutableDiagramCalloutCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    String actualToStringResult = immutableDiagramCalloutCreateCommand.toString();
    String actualCellExternalIdResult = immutableDiagramCalloutCreateCommand.cellExternalId();
    String actualContentResult = immutableDiagramCalloutCreateCommand.content();
    String actualEndColorResult = immutableDiagramCalloutCreateCommand.endColor();
    Long actualInstanceIdResult = immutableDiagramCalloutCreateCommand.instanceId();
    String actualStartColorResult = immutableDiagramCalloutCreateCommand.startColor();

    // Assert
    assertEquals("42", actualCellExternalIdResult);
    assertEquals(
        "DiagramCalloutCreateCommand{instanceId=1, cellExternalId=42, title=Dr, content=Not all who wander are"
            + " lost, startColor=Start Color, endColor=End Color}",
        actualToStringResult);
    assertEquals("Dr", immutableDiagramCalloutCreateCommand.title());
    assertEquals("End Color", actualEndColorResult);
    assertEquals("Not all who wander are lost", actualContentResult);
    assertEquals("Start Color", actualStartColorResult);
    assertEquals(1L, actualInstanceIdResult.longValue());
  }

  /**
   * Test Json {@link Json#cellExternalId()}.
   *
   * <p>Method under test: {@link Json#cellExternalId()}
   */
  @Test
  @DisplayName("Test Json cellExternalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellExternalId()"})
  void testJsonCellExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellExternalId());
  }

  /**
   * Test Json {@link Json#content()}.
   *
   * <p>Method under test: {@link Json#content()}
   */
  @Test
  @DisplayName("Test Json content()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.content()"})
  void testJsonContent() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().content());
  }

  /**
   * Test Json {@link Json#endColor()}.
   *
   * <p>Method under test: {@link Json#endColor()}
   */
  @Test
  @DisplayName("Test Json endColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.endColor()"})
  void testJsonEndColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().endColor());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellExternalId(String)}
   *   <li>{@link Json#setContent(String)}
   *   <li>{@link Json#setEndColor(String)}
   *   <li>{@link Json#setInstanceId(Long)}
   *   <li>{@link Json#setStartColor(String)}
   *   <li>{@link Json#setTitle(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCellExternalId(String)",
    "void Json.setContent(String)",
    "void Json.setEndColor(String)",
    "void Json.setInstanceId(Long)",
    "void Json.setStartColor(String)",
    "void Json.setTitle(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellExternalId("42");
    actualJson.setContent("Not all who wander are lost");
    actualJson.setEndColor("End Color");
    actualJson.setInstanceId(1L);
    actualJson.setStartColor("Start Color");
    actualJson.setTitle("Dr");

    // Assert
    assertEquals(1L, actualJson.instanceId.longValue());
  }

  /**
   * Test Json {@link Json#instanceId()}.
   *
   * <p>Method under test: {@link Json#instanceId()}
   */
  @Test
  @DisplayName("Test Json instanceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.instanceId()"})
  void testJsonInstanceId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().instanceId());
  }

  /**
   * Test Json {@link Json#startColor()}.
   *
   * <p>Method under test: {@link Json#startColor()}
   */
  @Test
  @DisplayName("Test Json startColor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.startColor()"})
  void testJsonStartColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().startColor());
  }

  /**
   * Test Json {@link Json#title()}.
   *
   * <p>Method under test: {@link Json#title()}
   */
  @Test
  @DisplayName("Test Json title()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.title()"})
  void testJsonTitle() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().title());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withCellExternalId(String)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withCellExternalId(String)"
  })
  void testWithCellExternalId() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithCellExternalIdResult =
        immutableDiagramCalloutCreateCommand.withCellExternalId("42");

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithCellExternalIdResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withCellExternalId(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withCellExternalId(String)}
   */
  @Test
  @DisplayName("Test withCellExternalId(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withCellExternalId(String)"
  })
  void testWithCellExternalId_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithCellExternalIdResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("cellExternalId")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withCellExternalId("42");

    // Assert
    assertEquals("42", actualWithCellExternalIdResult.cellExternalId());
    assertEquals("Dr", actualWithCellExternalIdResult.title());
    assertEquals("End Color", actualWithCellExternalIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithCellExternalIdResult.content());
    assertEquals("Start Color", actualWithCellExternalIdResult.startColor());
    assertEquals(1L, actualWithCellExternalIdResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withContent(String)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withContent(String)"
  })
  void testWithContent() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("42")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithContentResult =
        immutableDiagramCalloutCreateCommand.withContent("42");

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithContentResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withContent(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withContent(String)}
   */
  @Test
  @DisplayName("Test withContent(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withContent(String)"
  })
  void testWithContent_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithContentResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withContent("42");

    // Assert
    assertEquals("42", actualWithContentResult.cellExternalId());
    assertEquals("42", actualWithContentResult.content());
    assertEquals("Dr", actualWithContentResult.title());
    assertEquals("End Color", actualWithContentResult.endColor());
    assertEquals("Start Color", actualWithContentResult.startColor());
    assertEquals(1L, actualWithContentResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withEndColor(String)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withEndColor(String)}
   */
  @Test
  @DisplayName("Test withEndColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withEndColor(String)"
  })
  void testWithEndColor() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("42")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithEndColorResult =
        immutableDiagramCalloutCreateCommand.withEndColor("42");

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithEndColorResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withEndColor(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withEndColor(String)}
   */
  @Test
  @DisplayName("Test withEndColor(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withEndColor(String)"
  })
  void testWithEndColor_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithEndColorResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withEndColor("42");

    // Assert
    assertEquals("42", actualWithEndColorResult.cellExternalId());
    assertEquals("42", actualWithEndColorResult.endColor());
    assertEquals("Dr", actualWithEndColorResult.title());
    assertEquals("Not all who wander are lost", actualWithEndColorResult.content());
    assertEquals("Start Color", actualWithEndColorResult.startColor());
    assertEquals(1L, actualWithEndColorResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withInstanceId(Long)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withInstanceId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withInstanceId(Long)"
  })
  void testWithInstanceId() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithInstanceIdResult =
        immutableDiagramCalloutCreateCommand.withInstanceId(1L);

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithInstanceIdResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withInstanceId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withInstanceId(Long)}
   */
  @Test
  @DisplayName("Test withInstanceId(Long); when forty-two; then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withInstanceId(Long)"
  })
  void testWithInstanceId_whenFortyTwo_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithInstanceIdResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withInstanceId(42L);

    // Assert
    assertEquals("42", actualWithInstanceIdResult.cellExternalId());
    assertEquals("Dr", actualWithInstanceIdResult.title());
    assertEquals("End Color", actualWithInstanceIdResult.endColor());
    assertEquals("Not all who wander are lost", actualWithInstanceIdResult.content());
    assertEquals("Start Color", actualWithInstanceIdResult.startColor());
    assertEquals(42L, actualWithInstanceIdResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withStartColor(String)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withStartColor(String)}
   */
  @Test
  @DisplayName("Test withStartColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withStartColor(String)"
  })
  void testWithStartColor() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("42")
            .title("Dr")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithStartColorResult =
        immutableDiagramCalloutCreateCommand.withStartColor("42");

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithStartColorResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withStartColor(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withStartColor(String)}
   */
  @Test
  @DisplayName("Test withStartColor(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withStartColor(String)"
  })
  void testWithStartColor_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithStartColorResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withStartColor("42");

    // Assert
    assertEquals("42", actualWithStartColorResult.cellExternalId());
    assertEquals("42", actualWithStartColorResult.startColor());
    assertEquals("Dr", actualWithStartColorResult.title());
    assertEquals("End Color", actualWithStartColorResult.endColor());
    assertEquals("Not all who wander are lost", actualWithStartColorResult.content());
    assertEquals(1L, actualWithStartColorResult.instanceId().longValue());
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withTitle(String)}.
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withTitle(String)"
  })
  void testWithTitle() {
    // Arrange
    ImmutableDiagramCalloutCreateCommand immutableDiagramCalloutCreateCommand =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("42")
            .build();

    // Act
    ImmutableDiagramCalloutCreateCommand actualWithTitleResult =
        immutableDiagramCalloutCreateCommand.withTitle("42");

    // Assert
    assertSame(immutableDiagramCalloutCreateCommand, actualWithTitleResult);
  }

  /**
   * Test {@link ImmutableDiagramCalloutCreateCommand#withTitle(String)}.
   *
   * <ul>
   *   <li>Then return cellExternalId is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiagramCalloutCreateCommand#withTitle(String)}
   */
  @Test
  @DisplayName("Test withTitle(String); then return cellExternalId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiagramCalloutCreateCommand ImmutableDiagramCalloutCreateCommand.withTitle(String)"
  })
  void testWithTitle_thenReturnCellExternalIdIs42() {
    // Arrange and Act
    ImmutableDiagramCalloutCreateCommand actualWithTitleResult =
        ImmutableDiagramCalloutCreateCommand.builder()
            .cellExternalId("42")
            .content("Not all who wander are lost")
            .endColor("End Color")
            .instanceId(1L)
            .startColor("Start Color")
            .title("Dr")
            .build()
            .withTitle("42");

    // Assert
    assertEquals("42", actualWithTitleResult.cellExternalId());
    assertEquals("42", actualWithTitleResult.title());
    assertEquals("End Color", actualWithTitleResult.endColor());
    assertEquals("Not all who wander are lost", actualWithTitleResult.content());
    assertEquals("Start Color", actualWithTitleResult.startColor());
    assertEquals(1L, actualWithTitleResult.instanceId().longValue());
  }
}
