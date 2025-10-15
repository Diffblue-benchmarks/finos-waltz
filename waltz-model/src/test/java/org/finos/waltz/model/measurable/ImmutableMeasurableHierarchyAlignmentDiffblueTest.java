package org.finos.waltz.model.measurable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchyAlignment.Builder;
import org.finos.waltz.model.measurable.ImmutableMeasurableHierarchyAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableMeasurableHierarchyAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableMeasurableHierarchyAlignment Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualLevelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableEntityReference parentReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableMeasurableHierarchyAlignment actualImmutableMeasurableHierarchyAlignment =
        actualLevelResult.parentReference(parentReference).build();

    // Assert
    assertEquals(1, actualImmutableMeasurableHierarchyAlignment.level().intValue());
    assertSame(parentReference, actualImmutableMeasurableHierarchyAlignment.parentReference());
  }

  /**
   * Test Builder {@link Builder#from(MeasurableHierarchyAlignment)}.
   *
   * <p>Method under test: {@link Builder#from(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(MeasurableHierarchyAlignment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MeasurableHierarchyAlignment)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment instance =
        levelResult
            .parentReference(
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
    ImmutableMeasurableHierarchyAlignment actualImmutableMeasurableHierarchyAlignment =
        builderResult.build();
    assertEquals(instance, actualImmutableMeasurableHierarchyAlignment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#level(Integer)}.
   *
   * <p>Method under test: {@link Builder#level(Integer)}
   */
  @Test
  @DisplayName("Test Builder level(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.level(Integer)"})
  void testBuilderLevel() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act
    Builder actualLevelResult = builderResult.level(1);

    // Assert
    assertSame(builderResult, actualLevelResult);
  }

  /**
   * Test Builder {@link Builder#parentReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#parentReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder parentReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentReference(EntityReference)"})
  void testBuilderParentReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableMeasurableHierarchyAlignment.builder();

    // Act
    Builder actualParentReferenceResult =
        builderResult.parentReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParentReferenceResult);
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#copyOf(MeasurableHierarchyAlignment)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableHierarchyAlignment#copyOf(MeasurableHierarchyAlignment)}
   */
  @Test
  @DisplayName(
      "Test copyOf(MeasurableHierarchyAlignment); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchyAlignment ImmutableMeasurableHierarchyAlignment.copyOf(MeasurableHierarchyAlignment)"
  })
  void testCopyOf_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment instance =
        levelResult
            .parentReference(
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
    ImmutableMeasurableHierarchyAlignment actualCopyOfResult =
        ImmutableMeasurableHierarchyAlignment.copyOf(instance);

    // Assert
    EntityReference parentReferenceResult = actualCopyOfResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1, actualCopyOfResult.level().intValue());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableHierarchyAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder levelResult2 = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment2 =
        levelResult2
            .parentReference(
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
    assertEquals(immutableMeasurableHierarchyAlignment, immutableMeasurableHierarchyAlignment2);
    assertEquals(
        immutableMeasurableHierarchyAlignment.hashCode(),
        immutableMeasurableHierarchyAlignment2.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}, and {@link
   * ImmutableMeasurableHierarchyAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
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
    assertEquals(immutableMeasurableHierarchyAlignment, immutableMeasurableHierarchyAlignment);
    int expectedHashCodeResult = immutableMeasurableHierarchyAlignment.hashCode();
    assertEquals(expectedHashCodeResult, immutableMeasurableHierarchyAlignment.hashCode());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(0);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder levelResult2 = ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act and Assert
    assertNotEquals(
        immutableMeasurableHierarchyAlignment,
        levelResult2
            .parentReference(
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
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder levelResult2 = ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act and Assert
    assertNotEquals(
        immutableMeasurableHierarchyAlignment,
        levelResult2
            .parentReference(
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
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act and Assert
    assertNotEquals(
        levelResult
            .parentReference(
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
   * Test {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableMeasurableHierarchyAlignment.equals(Object)",
    "int ImmutableMeasurableHierarchyAlignment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act and Assert
    assertNotEquals(
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableMeasurableHierarchyAlignment");
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return level intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return level intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchyAlignment ImmutableMeasurableHierarchyAlignment.fromJson(Json)"
  })
  void testFromJson_thenReturnLevelIntValueIsOne() {
    // Arrange
    Json json = new Json();
    json.setParentReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setLevel(1);

    // Act
    ImmutableMeasurableHierarchyAlignment actualFromJsonResult =
        ImmutableMeasurableHierarchyAlignment.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.level().intValue());
    EntityReference expectedParentReferenceResult = json.parentReference;
    assertSame(expectedParentReferenceResult, actualFromJsonResult.parentReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#toString()}
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#level()}
   *   <li>{@link ImmutableMeasurableHierarchyAlignment#parentReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Integer ImmutableMeasurableHierarchyAlignment.level()",
    "EntityReference ImmutableMeasurableHierarchyAlignment.parentReference()",
    "String ImmutableMeasurableHierarchyAlignment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
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
    String actualToStringResult = immutableMeasurableHierarchyAlignment.toString();
    Integer actualLevelResult = immutableMeasurableHierarchyAlignment.level();

    // Assert
    assertTrue(
        immutableMeasurableHierarchyAlignment.parentReference()
            instanceof ImmutableEntityReference);
    assertEquals(
        "MeasurableHierarchyAlignment{parentReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " level=1}",
        actualToStringResult);
    assertEquals(1, actualLevelResult.intValue());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setLevel(Integer)}
   *   <li>{@link Json#setParentReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setLevel(Integer)",
    "void Json.setParentReference(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setLevel(1);
    actualJson.setParentReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    assertEquals(1, actualJson.level.intValue());
  }

  /**
   * Test Json {@link Json#level()}.
   *
   * <p>Method under test: {@link Json#level()}
   */
  @Test
  @DisplayName("Test Json level()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer Json.level()"})
  void testJsonLevel() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().level());
  }

  /**
   * Test Json {@link Json#parentReference()}.
   *
   * <p>Method under test: {@link Json#parentReference()}
   */
  @Test
  @DisplayName("Test Json parentReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.parentReference()"})
  void testJsonParentReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentReference());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#withLevel(Integer)}.
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#withLevel(Integer)}
   */
  @Test
  @DisplayName("Test withLevel(Integer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchyAlignment ImmutableMeasurableHierarchyAlignment.withLevel(Integer)"
  })
  void testWithLevel() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
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
    ImmutableMeasurableHierarchyAlignment actualWithLevelResult =
        immutableMeasurableHierarchyAlignment.withLevel(1);

    // Assert
    assertSame(immutableMeasurableHierarchyAlignment, actualWithLevelResult);
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#withLevel(Integer)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableMeasurableHierarchyAlignment#withLevel(Integer)}
   */
  @Test
  @DisplayName(
      "Test withLevel(Integer); when forty-two; then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchyAlignment ImmutableMeasurableHierarchyAlignment.withLevel(Integer)"
  })
  void testWithLevel_whenFortyTwo_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);

    // Act
    ImmutableMeasurableHierarchyAlignment actualWithLevelResult =
        levelResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withLevel(42);

    // Assert
    EntityReference parentReferenceResult = actualWithLevelResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(42, actualWithLevelResult.level().intValue());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableMeasurableHierarchyAlignment#withParentReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableMeasurableHierarchyAlignment#withParentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableMeasurableHierarchyAlignment ImmutableMeasurableHierarchyAlignment.withParentReference(EntityReference)"
  })
  void testWithParentReference() {
    // Arrange
    Builder levelResult = ImmutableMeasurableHierarchyAlignment.builder().level(1);
    ImmutableMeasurableHierarchyAlignment immutableMeasurableHierarchyAlignment =
        levelResult
            .parentReference(
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
    ImmutableMeasurableHierarchyAlignment actualWithParentReferenceResult =
        immutableMeasurableHierarchyAlignment.withParentReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableMeasurableHierarchyAlignment, actualWithParentReferenceResult);
  }
}
