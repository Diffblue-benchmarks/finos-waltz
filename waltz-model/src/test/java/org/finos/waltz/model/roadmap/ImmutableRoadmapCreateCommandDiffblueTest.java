package org.finos.waltz.model.roadmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand.Builder;
import org.finos.waltz.model.roadmap.ImmutableRoadmapCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRoadmapCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRoadmapCreateCommand Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableRoadmapCreateCommand.builder();
    ImmutableEntityReference columnType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualColumnTypeResult = actualBuilderResult.columnType(columnType);
    ImmutableEntityReference linkedEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualRatingSchemeIdResult =
        actualColumnTypeResult.linkedEntity(linkedEntity).name("Name").ratingSchemeId(1L);
    ImmutableEntityReference rowType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableRoadmapCreateCommand actualImmutableRoadmapCreateCommand =
        actualRatingSchemeIdResult.rowType(rowType).build();

    // Assert
    assertEquals("Name", actualImmutableRoadmapCreateCommand.name());
    assertEquals(1L, actualImmutableRoadmapCreateCommand.ratingSchemeId());
    assertSame(columnType, actualImmutableRoadmapCreateCommand.columnType());
    assertSame(linkedEntity, actualImmutableRoadmapCreateCommand.linkedEntity());
    assertSame(rowType, actualImmutableRoadmapCreateCommand.rowType());
  }

  /**
   * Test Builder {@link Builder#columnType(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#columnType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder columnType(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columnType(EntityReference)"})
  void testBuilderColumnType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act
    Builder actualColumnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualColumnTypeResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand instance =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    ImmutableRoadmapCreateCommand actualImmutableRoadmapCreateCommand =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableRoadmapCreateCommand);
    ImmutableRoadmapCreateCommand actualImmutableRoadmapCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableRoadmapCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *
   * <p>Method under test: {@link Builder#from(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test Builder from(RoadmapCreateCommand) with 'RoadmapCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RoadmapCreateCommand)"})
  void testBuilderFromWithRoadmapCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand instance =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRoadmapCreateCommand actualImmutableRoadmapCreateCommand = builderResult.build();
    assertEquals(instance, actualImmutableRoadmapCreateCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#linkedEntity(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#linkedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder linkedEntity(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.linkedEntity(EntityReference)"})
  void testBuilderLinkedEntity_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act
    Builder actualLinkedEntityResult =
        builderResult.linkedEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualLinkedEntityResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act
    Builder actualRatingSchemeIdResult = builderResult.ratingSchemeId(1L);

    // Assert
    assertSame(builderResult, actualRatingSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#rowType(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rowType(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder rowType(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowType(EntityReference)"})
  void testBuilderRowType_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    // Act
    Builder actualRowTypeResult =
        builderResult.rowType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualRowTypeResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#copyOf(RoadmapCreateCommand)}.
   *
   * <ul>
   *   <li>Then columnType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#copyOf(RoadmapCreateCommand)}
   */
  @Test
  @DisplayName("Test copyOf(RoadmapCreateCommand); then columnType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.copyOf(RoadmapCreateCommand)"
  })
  void testCopyOf_thenColumnTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand instance =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualCopyOfResult =
        ImmutableRoadmapCreateCommand.copyOf(instance);

    // Assert
    EntityReference columnTypeResult2 = actualCopyOfResult.columnType();
    assertTrue(columnTypeResult2 instanceof ImmutableEntityReference);
    EntityReference linkedEntityResult = actualCopyOfResult.linkedEntity();
    assertTrue(linkedEntityResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = actualCopyOfResult.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", columnTypeResult2.description());
    assertEquals(1L, columnTypeResult2.id());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult2.entityLifecycleStatus());
    assertEquals(columnTypeResult2, linkedEntityResult);
    assertEquals(columnTypeResult2, rowTypeResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}, and {@link
   * ImmutableRoadmapCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapCreateCommand#equals(Object)}
   *   <li>{@link ImmutableRoadmapCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand2 =
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableRoadmapCreateCommand, immutableRoadmapCreateCommand2);
    assertEquals(
        immutableRoadmapCreateCommand.hashCode(), immutableRoadmapCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}, and {@link
   * ImmutableRoadmapCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapCreateCommand#equals(Object)}
   *   <li>{@link ImmutableRoadmapCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableRoadmapCreateCommand, immutableRoadmapCreateCommand);
    int expectedHashCodeResult = immutableRoadmapCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableRoadmapCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRoadmapCreateCommand,
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRoadmapCreateCommand,
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("columnType")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRoadmapCreateCommand,
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(2L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRoadmapCreateCommand,
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult2 =
        builderResult2.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult2 =
        columnTypeResult2
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableRoadmapCreateCommand,
        ratingSchemeIdResult2
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRoadmapCreateCommand.equals(Object)",
    "int ImmutableRoadmapCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act and Assert
    assertNotEquals(
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableRoadmapCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRoadmapCreateCommand#toString()}
   *   <li>{@link ImmutableRoadmapCreateCommand#columnType()}
   *   <li>{@link ImmutableRoadmapCreateCommand#linkedEntity()}
   *   <li>{@link ImmutableRoadmapCreateCommand#name()}
   *   <li>{@link ImmutableRoadmapCreateCommand#ratingSchemeId()}
   *   <li>{@link ImmutableRoadmapCreateCommand#rowType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableRoadmapCreateCommand.columnType()",
    "EntityReference ImmutableRoadmapCreateCommand.linkedEntity()",
    "String ImmutableRoadmapCreateCommand.name()",
    "long ImmutableRoadmapCreateCommand.ratingSchemeId()",
    "EntityReference ImmutableRoadmapCreateCommand.rowType()",
    "String ImmutableRoadmapCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableRoadmapCreateCommand.toString();
    EntityReference actualColumnTypeResult = immutableRoadmapCreateCommand.columnType();
    EntityReference actualLinkedEntityResult = immutableRoadmapCreateCommand.linkedEntity();
    String actualNameResult = immutableRoadmapCreateCommand.name();
    long actualRatingSchemeIdResult = immutableRoadmapCreateCommand.ratingSchemeId();
    EntityReference actualRowTypeResult = immutableRoadmapCreateCommand.rowType();

    // Assert
    assertTrue(actualColumnTypeResult instanceof ImmutableEntityReference);
    assertTrue(actualLinkedEntityResult instanceof ImmutableEntityReference);
    assertTrue(actualRowTypeResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualNameResult);
    assertEquals(
        "RoadmapCreateCommand{name=Name, ratingSchemeId=1, rowType=EntityReference{kind=ALL, id=1, entityLife"
            + "cycleStatus=ACTIVE}, columnType=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " linkedEntity=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(1L, actualRatingSchemeIdResult);
    assertEquals(actualColumnTypeResult, actualLinkedEntityResult);
    assertEquals(actualColumnTypeResult, actualRowTypeResult);
  }

  /**
   * Test Json {@link Json#columnType()}.
   *
   * <p>Method under test: {@link Json#columnType()}
   */
  @Test
  @DisplayName("Test Json columnType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.columnType()"})
  void testJsonColumnType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columnType());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setColumnType(EntityReference)",
    "void Json.setLinkedEntity(EntityReference)",
    "void Json.setName(String)",
    "void Json.setRowType(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference columnType =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setColumnType(columnType);
    actualJson.setLinkedEntity(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setName("Name");
    actualJson.setRowType(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.columnType;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.linkedEntity;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    EntityReference entityReference3 = actualJson.rowType;
    assertTrue(entityReference3 instanceof ImmutableEntityReference);
    assertEquals("Name", actualJson.name);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0L, actualJson.ratingSchemeId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertFalse(actualJson.ratingSchemeIdIsSet);
    assertEquals(columnType, entityReference2);
    assertEquals(columnType, entityReference3);
  }

  /**
   * Test Json {@link Json#linkedEntity()}.
   *
   * <p>Method under test: {@link Json#linkedEntity()}
   */
  @Test
  @DisplayName("Test Json linkedEntity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.linkedEntity()"})
  void testJsonLinkedEntity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().linkedEntity());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeId());
  }

  /**
   * Test Json {@link Json#rowType()}.
   *
   * <p>Method under test: {@link Json#rowType()}
   */
  @Test
  @DisplayName("Test Json rowType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.rowType()"})
  void testJsonRowType() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rowType());
  }

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withColumnType(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withColumnType(EntityReference)}
   */
  @Test
  @DisplayName("Test withColumnType(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withColumnType(EntityReference)"
  })
  void testWithColumnType() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualWithColumnTypeResult =
        immutableRoadmapCreateCommand.withColumnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRoadmapCreateCommand, actualWithColumnTypeResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withLinkedEntity(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withLinkedEntity(EntityReference)}
   */
  @Test
  @DisplayName("Test withLinkedEntity(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withLinkedEntity(EntityReference)"
  })
  void testWithLinkedEntity() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualWithLinkedEntityResult =
        immutableRoadmapCreateCommand.withLinkedEntity(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRoadmapCreateCommand, actualWithLinkedEntityResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withName(String)"
  })
  void testWithName() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("42")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualWithNameResult =
        immutableRoadmapCreateCommand.withName("42");

    // Assert
    assertSame(immutableRoadmapCreateCommand, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withName(String)}.
   *
   * <ul>
   *   <li>Then columnType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then columnType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withName(String)"
  })
  void testWithName_thenColumnTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    ImmutableRoadmapCreateCommand actualWithNameResult =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withName("42");

    // Assert
    EntityReference columnTypeResult2 = actualWithNameResult.columnType();
    assertTrue(columnTypeResult2 instanceof ImmutableEntityReference);
    EntityReference linkedEntityResult = actualWithNameResult.linkedEntity();
    assertTrue(linkedEntityResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = actualWithNameResult.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", columnTypeResult2.description());
    assertEquals(1L, columnTypeResult2.id());
    assertEquals(1L, actualWithNameResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult2.entityLifecycleStatus());
    assertEquals(columnTypeResult2, linkedEntityResult);
    assertEquals(columnTypeResult2, rowTypeResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(42L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualWithRatingSchemeIdResult =
        immutableRoadmapCreateCommand.withRatingSchemeId(42L);

    // Assert
    assertSame(immutableRoadmapCreateCommand, actualWithRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withRatingSchemeId(long)}.
   *
   * <ul>
   *   <li>Then columnType return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long); then columnType return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId_thenColumnTypeReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);

    // Act
    ImmutableRoadmapCreateCommand actualWithRatingSchemeIdResult =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withRatingSchemeId(42L);

    // Assert
    EntityReference columnTypeResult2 = actualWithRatingSchemeIdResult.columnType();
    assertTrue(columnTypeResult2 instanceof ImmutableEntityReference);
    EntityReference linkedEntityResult = actualWithRatingSchemeIdResult.linkedEntity();
    assertTrue(linkedEntityResult instanceof ImmutableEntityReference);
    EntityReference rowTypeResult = actualWithRatingSchemeIdResult.rowType();
    assertTrue(rowTypeResult instanceof ImmutableEntityReference);
    assertEquals("Name", actualWithRatingSchemeIdResult.name());
    assertEquals("The characteristics of someone or something", columnTypeResult2.description());
    assertEquals(1L, columnTypeResult2.id());
    assertEquals(42L, actualWithRatingSchemeIdResult.ratingSchemeId());
    assertEquals(EntityKind.ALL, columnTypeResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, columnTypeResult2.entityLifecycleStatus());
    assertEquals(columnTypeResult2, linkedEntityResult);
    assertEquals(columnTypeResult2, rowTypeResult);
  }

  /**
   * Test {@link ImmutableRoadmapCreateCommand#withRowType(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableRoadmapCreateCommand#withRowType(EntityReference)}
   */
  @Test
  @DisplayName("Test withRowType(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRoadmapCreateCommand ImmutableRoadmapCreateCommand.withRowType(EntityReference)"
  })
  void testWithRowType() {
    // Arrange
    Builder builderResult = ImmutableRoadmapCreateCommand.builder();

    Builder columnTypeResult =
        builderResult.columnType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder ratingSchemeIdResult =
        columnTypeResult
            .linkedEntity(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .name("Name")
            .ratingSchemeId(1L);
    ImmutableRoadmapCreateCommand immutableRoadmapCreateCommand =
        ratingSchemeIdResult
            .rowType(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableRoadmapCreateCommand actualWithRowTypeResult =
        immutableRoadmapCreateCommand.withRowType(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableRoadmapCreateCommand, actualWithRowTypeResult);
  }
}
