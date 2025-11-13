package org.finos.waltz.model.aggregate_overlay_diagram;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity.Builder;
import org.finos.waltz.model.aggregate_overlay_diagram.ImmutableBackingEntity.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBackingEntityDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBackingEntity Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualCellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableBackingEntity actualImmutableBackingEntity =
        actualCellIdResult.entityReference(entityReference).build();

    // Assert
    assertEquals("42", actualImmutableBackingEntity.cellId());
    assertSame(entityReference, actualImmutableBackingEntity.entityReference());
  }

  /**
   * Test Builder {@link Builder#cellId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#cellId(String)}
   */
  @Test
  @DisplayName("Test Builder cellId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.cellId(String)"})
  void testBuilderCellId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();

    // Act
    Builder actualCellIdResult = builderResult.cellId("42");

    // Assert
    assertSame(builderResult, actualCellIdResult);
  }

  /**
   * Test Builder {@link Builder#entityReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder entityReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReference(EntityReference)"})
  void testBuilderEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();

    // Act
    Builder actualEntityReferenceResult =
        builderResult.entityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualEntityReferenceResult);
  }

  /**
   * Test Builder {@link Builder#from(BackingEntity)}.
   *
   * <p>Method under test: {@link Builder#from(BackingEntity)}
   */
  @Test
  @DisplayName("Test Builder from(BackingEntity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BackingEntity)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBackingEntity.builder();

    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity instance =
        cellIdResult
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
    ImmutableBackingEntity actualImmutableBackingEntity = builderResult.build();
    assertEquals(instance, actualImmutableBackingEntity);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test {@link ImmutableBackingEntity#copyOf(BackingEntity)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#copyOf(BackingEntity)}
   */
  @Test
  @DisplayName("Test copyOf(BackingEntity); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBackingEntity ImmutableBackingEntity.copyOf(BackingEntity)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity instance =
        cellIdResult
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
    ImmutableBackingEntity actualCopyOfResult = ImmutableBackingEntity.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.cellId());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableBackingEntity#equals(Object)}, and {@link
   * ImmutableBackingEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntity#equals(Object)}
   *   <li>{@link ImmutableBackingEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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

    Builder cellIdResult2 = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity2 =
        cellIdResult2
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
    assertEquals(immutableBackingEntity, immutableBackingEntity2);
    assertEquals(immutableBackingEntity.hashCode(), immutableBackingEntity2.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntity#equals(Object)}, and {@link
   * ImmutableBackingEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntity#equals(Object)}
   *   <li>{@link ImmutableBackingEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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
    assertEquals(immutableBackingEntity, immutableBackingEntity);
    int expectedHashCodeResult = immutableBackingEntity.hashCode();
    assertEquals(expectedHashCodeResult, immutableBackingEntity.hashCode());
  }

  /**
   * Test {@link ImmutableBackingEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("Cell Id");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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

    Builder cellIdResult2 = ImmutableBackingEntity.builder().cellId("42");

    // Act and Assert
    assertNotEquals(
        immutableBackingEntity,
        cellIdResult2
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
   * Test {@link ImmutableBackingEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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

    Builder cellIdResult2 = ImmutableBackingEntity.builder().cellId("42");

    // Act and Assert
    assertNotEquals(
        immutableBackingEntity,
        cellIdResult2
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
   * Test {@link ImmutableBackingEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");

    // Act and Assert
    assertNotEquals(
        cellIdResult
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
   * Test {@link ImmutableBackingEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBackingEntity.equals(Object)",
    "int ImmutableBackingEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");

    // Act and Assert
    assertNotEquals(
        cellIdResult
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
        "Different type to ImmutableBackingEntity");
  }

  /**
   * Test {@link ImmutableBackingEntity#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return cellId is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return cellId is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBackingEntity ImmutableBackingEntity.fromJson(Json)"})
  void testFromJson_thenReturnCellIdIsJson() {
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
    json.setCellId("Json");

    // Act
    ImmutableBackingEntity actualFromJsonResult = ImmutableBackingEntity.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.cellId());
    EntityReference expectedEntityReferenceResult = json.entityReference;
    assertSame(expectedEntityReferenceResult, actualFromJsonResult.entityReference());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBackingEntity#toString()}
   *   <li>{@link ImmutableBackingEntity#cellId()}
   *   <li>{@link ImmutableBackingEntity#entityReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBackingEntity.cellId()",
    "EntityReference ImmutableBackingEntity.entityReference()",
    "String ImmutableBackingEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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
    String actualToStringResult = immutableBackingEntity.toString();
    String actualCellIdResult = immutableBackingEntity.cellId();

    // Assert
    assertTrue(immutableBackingEntity.entityReference() instanceof ImmutableEntityReference);
    assertEquals("42", actualCellIdResult);
    assertEquals(
        "BackingEntity{entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " cellId=42}",
        actualToStringResult);
  }

  /**
   * Test Json {@link Json#cellId()}.
   *
   * <p>Method under test: {@link Json#cellId()}
   */
  @Test
  @DisplayName("Test Json cellId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.cellId()"})
  void testJsonCellId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().cellId());
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
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setCellId(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setCellId(String)",
    "void Json.setEntityReference(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setCellId("42");
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("42", actualJson.cellId);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableBackingEntity#withCellId(String)}.
   *
   * <p>Method under test: {@link ImmutableBackingEntity#withCellId(String)}
   */
  @Test
  @DisplayName("Test withCellId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBackingEntity ImmutableBackingEntity.withCellId(String)"})
  void testWithCellId() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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
    ImmutableBackingEntity actualWithCellIdResult = immutableBackingEntity.withCellId("42");

    // Assert
    assertSame(immutableBackingEntity, actualWithCellIdResult);
  }

  /**
   * Test {@link ImmutableBackingEntity#withCellId(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBackingEntity#withCellId(String)}
   */
  @Test
  @DisplayName("Test withCellId(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBackingEntity ImmutableBackingEntity.withCellId(String)"})
  void testWithCellId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("cellId");

    // Act
    ImmutableBackingEntity actualWithCellIdResult =
        cellIdResult
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
            .withCellId("42");

    // Assert
    EntityReference entityReferenceResult = actualWithCellIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithCellIdResult.cellId());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableBackingEntity#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableBackingEntity#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBackingEntity ImmutableBackingEntity.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder cellIdResult = ImmutableBackingEntity.builder().cellId("42");
    ImmutableBackingEntity immutableBackingEntity =
        cellIdResult
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
    ImmutableBackingEntity actualWithEntityReferenceResult =
        immutableBackingEntity.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBackingEntity, actualWithEntityReferenceResult);
  }
}
