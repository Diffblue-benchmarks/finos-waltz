package org.finos.waltz.model.flow_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Builder;
import org.finos.waltz.model.flow_diagram.ImmutableFlowDiagramEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowDiagramEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramEntity Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDiagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    Optional<Long> diagramId = Optional.of(1L);
    Builder actualDiagramIdResult2 = actualDiagramIdResult.diagramId(diagramId);
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowDiagramEntity actualImmutableFlowDiagramEntity =
        actualDiagramIdResult2.entityReference(entityReference).build();

    // Assert
    assertFalse(actualImmutableFlowDiagramEntity.isNotable());
    assertSame(entityReference, actualImmutableFlowDiagramEntity.entityReference());
  }

  /**
   * Test Builder {@link Builder#diagramId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#diagramId(long)}
   */
  @Test
  @DisplayName("Test Builder diagramId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(long)"})
  void testBuilderDiagramIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(1L);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#diagramId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#diagramId(Optional)}
   */
  @Test
  @DisplayName("Test Builder diagramId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramId(Optional)"})
  void testBuilderDiagramIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();
    Optional<Long> diagramId = Optional.of(1L);

    // Act
    Builder actualDiagramIdResult = builderResult.diagramId(diagramId);

    // Assert
    assertSame(builderResult, actualDiagramIdResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then not builder build Notable.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder entityReference(EntityReference); when EntityReference; then not builder build Notable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_whenEntityReference_thenNotBuilderBuildNotable() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();
    EntityReference entityReference = mock(EntityReference.class);

    // Act
    Builder actualEntityReferenceResult = builderResult.entityReference(entityReference);

    // Assert
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity = builderResult.build();
    assertFalse(immutableFlowDiagramEntity.isNotable());
    assertSame(builderResult, actualEntityReferenceResult);
    assertSame(entityReference, immutableFlowDiagramEntity.entityReference());
  }

  /**
   * Test Builder {@link Builder#from(FlowDiagramEntity)}.
   *
   * <p>Method under test: {@link Builder#from(FlowDiagramEntity)}
   */
  @Test
  @DisplayName("Test Builder from(FlowDiagramEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowDiagramEntity)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();

    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity instance =
        diagramIdResult
            .entityReference(
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
    ImmutableFlowDiagramEntity actualImmutableFlowDiagramEntity = builderResult.build();
    assertEquals(instance, actualImmutableFlowDiagramEntity);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isNotable(boolean)}.
   *
   * <p>Method under test: {@link Builder#isNotable(boolean)}
   */
  @Test
  @DisplayName("Test Builder isNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isNotable(boolean)"})
  void testBuilderIsNotable() {
    // Arrange
    Builder builderResult = ImmutableFlowDiagramEntity.builder();

    // Act
    Builder actualIsNotableResult = builderResult.isNotable(true);

    // Assert
    assertSame(builderResult, actualIsNotableResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#copyOf(FlowDiagramEntity)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#copyOf(FlowDiagramEntity)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowDiagramEntity); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.copyOf(FlowDiagramEntity)"
  })
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity instance =
        diagramIdResult
            .entityReference(
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
    ImmutableFlowDiagramEntity actualCopyOfResult = ImmutableFlowDiagramEntity.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualCopyOfResult.isNotable());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#diagramId()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#diagramId()}
   */
  @Test
  @DisplayName("Test diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableFlowDiagramEntity.diagramId()"})
  void testDiagramId() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act
    Optional<Long> actualDiagramIdResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .diagramId();

    // Assert
    assertEquals(1L, actualDiagramIdResult.get().longValue());
    assertTrue(actualDiagramIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}, and {@link
   * ImmutableFlowDiagramEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramEntity#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity2 =
        diagramIdResult2
            .entityReference(
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
    assertEquals(immutableFlowDiagramEntity, immutableFlowDiagramEntity2);
    assertEquals(immutableFlowDiagramEntity.hashCode(), immutableFlowDiagramEntity2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}, and {@link
   * ImmutableFlowDiagramEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramEntity#equals(Object)}
   *   <li>{@link ImmutableFlowDiagramEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
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
    assertEquals(immutableFlowDiagramEntity, immutableFlowDiagramEntity);
    int expectedHashCodeResult = immutableFlowDiagramEntity.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowDiagramEntity.hashCode());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(2L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramEntity,
        diagramIdResult2
            .entityReference(
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
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder diagramIdResult2 = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        immutableFlowDiagramEntity,
        diagramIdResult2
            .entityReference(
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
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
            .entityReference(
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
   * Test {@link ImmutableFlowDiagramEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowDiagramEntity.equals(Object)",
    "int ImmutableFlowDiagramEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertNotEquals(
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableFlowDiagramEntity");
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return not Notable.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return not Notable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.fromJson(Json)"})
  void testFromJson_thenReturnNotNotable() {
    // Arrange
    Json json = new Json();
    json.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableFlowDiagramEntity actualFromJsonResult = ImmutableFlowDiagramEntity.fromJson(json);

    // Assert
    assertFalse(actualFromJsonResult.isNotable());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowDiagramEntity#entityReference()}
   *   <li>{@link ImmutableFlowDiagramEntity#isNotable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableFlowDiagramEntity.entityReference()",
    "boolean ImmutableFlowDiagramEntity.isNotable()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
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
    EntityReference actualEntityReferenceResult = immutableFlowDiagramEntity.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertFalse(immutableFlowDiagramEntity.isNotable());
  }

  /**
   * Test Json {@link Json#diagramId()}.
   *
   * <p>Method under test: {@link Json#diagramId()}
   */
  @Test
  @DisplayName("Test Json diagramId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.diagramId()"})
  void testJsonDiagramId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramId());
  }

  /**
   * Test Json {@link Json#entityReference()}.
   *
   * <p>Method under test: {@link Json#entityReference()}
   */
  @Test
  @DisplayName("Test Json entityReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.entityReference()"})
  void testJsonEntityReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReference());
  }

  /**
   * Test Json {@link Json#isNotable()}.
   *
   * <p>Method under test: {@link Json#isNotable()}
   */
  @Test
  @DisplayName("Test Json isNotable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isNotable()"})
  void testJsonIsNotable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isNotable());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.entityReference);
    assertFalse(actualJson.diagramId.isPresent());
    assertFalse(actualJson.isNotable);
    assertFalse(actualJson.isNotableIsSet);
  }

  /**
   * Test Json {@link Json#setIsNotable(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsNotable(boolean)"})
  void testJsonSetIsNotable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsNotable(true);

    // Assert
    assertTrue(json.isNotable);
    assertTrue(json.isNotableIsSet);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#toString()}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ImmutableFlowDiagramEntity.toString()"})
  void testToString() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act and Assert
    assertEquals(
        "FlowDiagramEntity{diagramId=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " isNotable=false}",
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withDiagramId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withDiagramId(Optional)}
   */
  @Test
  @DisplayName("Test withDiagramId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withDiagramId(Optional)"
  })
  void testWithDiagramIdWithOptional() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagramEntity actualWithDiagramIdResult =
        immutableFlowDiagramEntity.withDiagramId(optional);

    // Assert
    assertSame(immutableFlowDiagramEntity, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withDiagramId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withDiagramId(Optional)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(Optional) with 'optional'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withDiagramId(Optional)"
  })
  void testWithDiagramIdWithOptional_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(2L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableFlowDiagramEntity actualWithDiagramIdResult =
        immutableFlowDiagramEntity.withDiagramId(optional);

    // Assert
    EntityReference entityReferenceResult = actualWithDiagramIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithDiagramIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withDiagramId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withDiagramId(long)}
   */
  @Test
  @DisplayName("Test withDiagramId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withDiagramId(long)"})
  void testWithDiagramIdWithValue() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
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
    ImmutableFlowDiagramEntity actualWithDiagramIdResult =
        immutableFlowDiagramEntity.withDiagramId(1L);

    // Assert
    assertSame(immutableFlowDiagramEntity, actualWithDiagramIdResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withDiagramId(long)} with {@code value}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withDiagramId(long)}
   */
  @Test
  @DisplayName(
      "Test withDiagramId(long) with 'value'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withDiagramId(long)"})
  void testWithDiagramIdWithValue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableFlowDiagramEntity actualWithDiagramIdResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withDiagramId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithDiagramIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithDiagramIdResult.isNotable());
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
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
    ImmutableFlowDiagramEntity actualWithEntityReferenceResult =
        immutableFlowDiagramEntity.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowDiagramEntity, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withIsNotable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withIsNotable(boolean)}
   */
  @Test
  @DisplayName("Test withIsNotable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withIsNotable(boolean)"
  })
  void testWithIsNotable() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);
    ImmutableFlowDiagramEntity immutableFlowDiagramEntity =
        diagramIdResult
            .entityReference(
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
    ImmutableFlowDiagramEntity actualWithIsNotableResult =
        immutableFlowDiagramEntity.withIsNotable(false);

    // Assert
    assertSame(immutableFlowDiagramEntity, actualWithIsNotableResult);
  }

  /**
   * Test {@link ImmutableFlowDiagramEntity#withIsNotable(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowDiagramEntity#withIsNotable(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsNotable(boolean); when 'true'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowDiagramEntity ImmutableFlowDiagramEntity.withIsNotable(boolean)"
  })
  void testWithIsNotable_whenTrue_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder diagramIdResult = ImmutableFlowDiagramEntity.builder().diagramId(1L);

    // Act
    ImmutableFlowDiagramEntity actualWithIsNotableResult =
        diagramIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withIsNotable(true);

    // Assert
    EntityReference entityReferenceResult = actualWithIsNotableResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithIsNotableResult.isNotable());
  }
}
