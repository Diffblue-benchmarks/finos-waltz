package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.finos.waltz.model.flow_classification_rule.ImmutableDiscouragedSource.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableDiscouragedSource.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDiscouragedSourceDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiscouragedSource Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualDataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableEntityReference sourceReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableDiscouragedSource actualImmutableDiscouragedSource =
        actualDataTypeIdResult.sourceReference(sourceReference).build();

    // Assert
    assertEquals(1L, actualImmutableDiscouragedSource.dataTypeId());
    assertEquals(3, actualImmutableDiscouragedSource.count());
    assertSame(sourceReference, actualImmutableDiscouragedSource.sourceReference());
  }

  /**
   * Test Builder {@link Builder#count(int)}.
   *
   * <p>Method under test: {@link Builder#count(int)}
   */
  @Test
  @DisplayName("Test Builder count(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.count(int)"})
  void testBuilderCount() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act
    Builder actualCountResult = builderResult.count(3);

    // Assert
    assertSame(builderResult, actualCountResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeId(long)}.
   *
   * <p>Method under test: {@link Builder#dataTypeId(long)}
   */
  @Test
  @DisplayName("Test Builder dataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeId(long)"})
  void testBuilderDataTypeId() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act
    Builder actualDataTypeIdResult = builderResult.dataTypeId(1L);

    // Assert
    assertSame(builderResult, actualDataTypeIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DiscouragedSource)}.
   *
   * <p>Method under test: {@link Builder#from(DiscouragedSource)}
   */
  @Test
  @DisplayName("Test Builder from(DiscouragedSource)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DiscouragedSource)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource instance =
        dataTypeIdResult
            .sourceReference(
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
    ImmutableDiscouragedSource actualImmutableDiscouragedSource = builderResult.build();
    assertEquals(instance, actualImmutableDiscouragedSource);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#sourceReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#sourceReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder sourceReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceReference(EntityReference)"})
  void testBuilderSourceReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDiscouragedSource.builder();

    // Act
    Builder actualSourceReferenceResult =
        builderResult.sourceReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSourceReferenceResult);
  }

  /**
   * Test {@link ImmutableDiscouragedSource#copyOf(DiscouragedSource)}.
   *
   * <ul>
   *   <li>Then sourceReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#copyOf(DiscouragedSource)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DiscouragedSource); then sourceReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiscouragedSource ImmutableDiscouragedSource.copyOf(DiscouragedSource)"
  })
  void testCopyOf_thenSourceReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource instance =
        dataTypeIdResult
            .sourceReference(
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
    ImmutableDiscouragedSource actualCopyOfResult = ImmutableDiscouragedSource.copyOf(instance);

    // Assert
    EntityReference sourceReferenceResult = actualCopyOfResult.sourceReference();
    assertTrue(sourceReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", sourceReferenceResult.description());
    assertEquals(1L, sourceReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.dataTypeId());
    assertEquals(3, actualCopyOfResult.count());
    assertEquals(EntityKind.ALL, sourceReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#equals(Object)}, and {@link
   * ImmutableDiscouragedSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiscouragedSource#equals(Object)}
   *   <li>{@link ImmutableDiscouragedSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource2 =
        dataTypeIdResult2
            .sourceReference(
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
    assertEquals(immutableDiscouragedSource, immutableDiscouragedSource2);
    assertEquals(immutableDiscouragedSource.hashCode(), immutableDiscouragedSource2.hashCode());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#equals(Object)}, and {@link
   * ImmutableDiscouragedSource#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiscouragedSource#equals(Object)}
   *   <li>{@link ImmutableDiscouragedSource#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
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
    assertEquals(immutableDiscouragedSource, immutableDiscouragedSource);
    int expectedHashCodeResult = immutableDiscouragedSource.hashCode();
    assertEquals(expectedHashCodeResult, immutableDiscouragedSource.hashCode());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(1).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableDiscouragedSource,
        dataTypeIdResult2
            .sourceReference(
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
   * Test {@link ImmutableDiscouragedSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(2L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableDiscouragedSource,
        dataTypeIdResult2
            .sourceReference(
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
   * Test {@link ImmutableDiscouragedSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder dataTypeIdResult2 = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        immutableDiscouragedSource,
        dataTypeIdResult2
            .sourceReference(
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
   * Test {@link ImmutableDiscouragedSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        dataTypeIdResult
            .sourceReference(
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
   * Test {@link ImmutableDiscouragedSource#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDiscouragedSource.equals(Object)",
    "int ImmutableDiscouragedSource.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act and Assert
    assertNotEquals(
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableDiscouragedSource");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDiscouragedSource#toString()}
   *   <li>{@link ImmutableDiscouragedSource#count()}
   *   <li>{@link ImmutableDiscouragedSource#dataTypeId()}
   *   <li>{@link ImmutableDiscouragedSource#sourceReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ImmutableDiscouragedSource.count()",
    "long ImmutableDiscouragedSource.dataTypeId()",
    "EntityReference ImmutableDiscouragedSource.sourceReference()",
    "String ImmutableDiscouragedSource.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
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
    String actualToStringResult = immutableDiscouragedSource.toString();
    int actualCountResult = immutableDiscouragedSource.count();
    long actualDataTypeIdResult = immutableDiscouragedSource.dataTypeId();

    // Assert
    assertTrue(immutableDiscouragedSource.sourceReference() instanceof ImmutableEntityReference);
    assertEquals(
        "DiscouragedSource{sourceReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " dataTypeId=1, count=3}",
        actualToStringResult);
    assertEquals(1L, actualDataTypeIdResult);
    assertEquals(3, actualCountResult);
  }

  /**
   * Test Json {@link Json#count()}.
   *
   * <p>Method under test: {@link Json#count()}
   */
  @Test
  @DisplayName("Test Json count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.count()"})
  void testJsonCount() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().count());
  }

  /**
   * Test Json {@link Json#dataTypeId()}.
   *
   * <p>Method under test: {@link Json#dataTypeId()}
   */
  @Test
  @DisplayName("Test Json dataTypeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setSourceReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()", "void Json.setSourceReference(EntityReference)"})
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setSourceReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.sourceReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0, actualJson.count);
    assertEquals(0L, actualJson.dataTypeId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertFalse(actualJson.countIsSet);
    assertFalse(actualJson.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#setCount(int)}.
   *
   * <p>Method under test: {@link Json#setCount(int)}
   */
  @Test
  @DisplayName("Test Json setCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setCount(int)"})
  void testJsonSetCount() {
    // Arrange
    Json json = new Json();

    // Act
    json.setCount(3);

    // Assert
    assertEquals(3, json.count);
    assertTrue(json.countIsSet);
  }

  /**
   * Test Json {@link Json#setDataTypeId(long)}.
   *
   * <p>Method under test: {@link Json#setDataTypeId(long)}
   */
  @Test
  @DisplayName("Test Json setDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeId(long)"})
  void testJsonSetDataTypeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeId(1L);

    // Assert
    assertEquals(1L, json.dataTypeId);
    assertTrue(json.dataTypeIdIsSet);
  }

  /**
   * Test Json {@link Json#sourceReference()}.
   *
   * <p>Method under test: {@link Json#sourceReference()}
   */
  @Test
  @DisplayName("Test Json sourceReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.sourceReference()"})
  void testJsonSourceReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().sourceReference());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#withCount(int)}.
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiscouragedSource ImmutableDiscouragedSource.withCount(int)"})
  void testWithCount() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(42).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
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
    ImmutableDiscouragedSource actualWithCountResult = immutableDiscouragedSource.withCount(42);

    // Assert
    assertSame(immutableDiscouragedSource, actualWithCountResult);
  }

  /**
   * Test {@link ImmutableDiscouragedSource#withCount(int)}.
   *
   * <ul>
   *   <li>Then sourceReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#withCount(int)}
   */
  @Test
  @DisplayName("Test withCount(int); then sourceReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiscouragedSource ImmutableDiscouragedSource.withCount(int)"})
  void testWithCount_thenSourceReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act
    ImmutableDiscouragedSource actualWithCountResult =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withCount(42);

    // Assert
    EntityReference sourceReferenceResult = actualWithCountResult.sourceReference();
    assertTrue(sourceReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", sourceReferenceResult.description());
    assertEquals(1L, sourceReferenceResult.id());
    assertEquals(1L, actualWithCountResult.dataTypeId());
    assertEquals(42, actualWithCountResult.count());
    assertEquals(EntityKind.ALL, sourceReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#withDataTypeId(long)}.
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiscouragedSource ImmutableDiscouragedSource.withDataTypeId(long)"})
  void testWithDataTypeId() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(42L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
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
    ImmutableDiscouragedSource actualWithDataTypeIdResult =
        immutableDiscouragedSource.withDataTypeId(42L);

    // Assert
    assertSame(immutableDiscouragedSource, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableDiscouragedSource#withDataTypeId(long)}.
   *
   * <ul>
   *   <li>Then sourceReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#withDataTypeId(long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(long); then sourceReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDiscouragedSource ImmutableDiscouragedSource.withDataTypeId(long)"})
  void testWithDataTypeId_thenSourceReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);

    // Act
    ImmutableDiscouragedSource actualWithDataTypeIdResult =
        dataTypeIdResult
            .sourceReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withDataTypeId(42L);

    // Assert
    EntityReference sourceReferenceResult = actualWithDataTypeIdResult.sourceReference();
    assertTrue(sourceReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", sourceReferenceResult.description());
    assertEquals(1L, sourceReferenceResult.id());
    assertEquals(3, actualWithDataTypeIdResult.count());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId());
    assertEquals(EntityKind.ALL, sourceReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceReferenceResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableDiscouragedSource#withSourceReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableDiscouragedSource#withSourceReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withSourceReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDiscouragedSource ImmutableDiscouragedSource.withSourceReference(EntityReference)"
  })
  void testWithSourceReference() {
    // Arrange
    Builder dataTypeIdResult = ImmutableDiscouragedSource.builder().count(3).dataTypeId(1L);
    ImmutableDiscouragedSource immutableDiscouragedSource =
        dataTypeIdResult
            .sourceReference(
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
    ImmutableDiscouragedSource actualWithSourceReferenceResult =
        immutableDiscouragedSource.withSourceReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDiscouragedSource, actualWithSourceReferenceResult);
  }
}
