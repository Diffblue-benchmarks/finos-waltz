package org.finos.waltz.model.datatype;

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
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Builder;
import org.finos.waltz.model.datatype.ImmutableDataTypeDecoratorRatingCharacteristicsRequest.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableDataTypeDecoratorRatingCharacteristicsRequestDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableDataTypeDecoratorRatingCharacteristicsRequest Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSourceResult = actualBuilderResult.source(source);
    ImmutableEntityReference target =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        actualImmutableDataTypeDecoratorRatingCharacteristicsRequest =
            actualSourceResult.target(target).build();

    // Assert
    assertSame(source, actualImmutableDataTypeDecoratorRatingCharacteristicsRequest.source());
    assertSame(target, actualImmutableDataTypeDecoratorRatingCharacteristicsRequest.target());
  }

  /**
   * Test Builder {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}.
   *
   * <p>Method under test: {@link Builder#from(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  @DisplayName("Test Builder from(DataTypeDecoratorRatingCharacteristicsRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DataTypeDecoratorRatingCharacteristicsRequest)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder builderResult2 = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest instance =
        sourceResult
            .target(
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
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        actualImmutableDataTypeDecoratorRatingCharacteristicsRequest = builderResult.build();
    assertEquals(instance, actualImmutableDataTypeDecoratorRatingCharacteristicsRequest);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#source(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder source(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(EntityReference)"})
  void testBuilderSource_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    // Act
    Builder actualSourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#target(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder target(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(EntityReference)"})
  void testBuilderTarget_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    // Act
    Builder actualTargetResult =
        builderResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualTargetResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#copyOf(DataTypeDecoratorRatingCharacteristicsRequest)}.
   *
   * <ul>
   *   <li>Then source return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#copyOf(DataTypeDecoratorRatingCharacteristicsRequest)}
   */
  @Test
  @DisplayName(
      "Test copyOf(DataTypeDecoratorRatingCharacteristicsRequest); then source return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristicsRequest ImmutableDataTypeDecoratorRatingCharacteristicsRequest.copyOf(DataTypeDecoratorRatingCharacteristicsRequest)"
  })
  void testCopyOf_thenSourceReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest instance =
        sourceResult
            .target(
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
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest actualCopyOfResult =
        ImmutableDataTypeDecoratorRatingCharacteristicsRequest.copyOf(instance);

    // Assert
    EntityReference sourceResult2 = actualCopyOfResult.source();
    assertTrue(sourceResult2 instanceof ImmutableEntityReference);
    EntityReference targetResult = actualCopyOfResult.target();
    assertTrue(targetResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", sourceResult2.description());
    assertEquals(1L, sourceResult2.id());
    assertEquals(EntityKind.ALL, sourceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, sourceResult2.entityLifecycleStatus());
    assertEquals(sourceResult2, targetResult);
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest2 =
            sourceResult2
                .target(
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
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristicsRequest,
        immutableDataTypeDecoratorRatingCharacteristicsRequest2);
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode(),
        immutableDataTypeDecoratorRatingCharacteristicsRequest2.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}, and {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
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
    assertEquals(
        immutableDataTypeDecoratorRatingCharacteristicsRequest,
        immutableDataTypeDecoratorRatingCharacteristicsRequest);
    int expectedHashCodeResult = immutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode());
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristicsRequest,
        sourceResult2
            .target(
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
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult2 =
        builderResult2.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        immutableDataTypeDecoratorRatingCharacteristicsRequest,
        sourceResult2
            .target(
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
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        sourceResult
            .target(
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
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableDataTypeDecoratorRatingCharacteristicsRequest.equals(Object)",
    "int ImmutableDataTypeDecoratorRatingCharacteristicsRequest.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act and Assert
    assertNotEquals(
        sourceResult
            .target(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableDataTypeDecoratorRatingCharacteristicsRequest");
  }

  /**
   * Test {@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return source is {@link Json} (default constructor) {@link Json#source}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return source is Json (default constructor) source")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristicsRequest ImmutableDataTypeDecoratorRatingCharacteristicsRequest.fromJson(Json)"
  })
  void testFromJson_thenReturnSourceIsJsonSource() {
    // Arrange
    Json json = new Json();
    json.setSource(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest actualFromJsonResult =
        ImmutableDataTypeDecoratorRatingCharacteristicsRequest.fromJson(json);

    // Assert
    EntityReference expectedSourceResult = json.source;
    assertSame(expectedSourceResult, actualFromJsonResult.source());
    EntityReference expectedTargetResult = json.target;
    assertSame(expectedTargetResult, actualFromJsonResult.target());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#toString()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#source()}
   *   <li>{@link ImmutableDataTypeDecoratorRatingCharacteristicsRequest#target()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableDataTypeDecoratorRatingCharacteristicsRequest.source()",
    "EntityReference ImmutableDataTypeDecoratorRatingCharacteristicsRequest.target()",
    "String ImmutableDataTypeDecoratorRatingCharacteristicsRequest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
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
    String actualToStringResult = immutableDataTypeDecoratorRatingCharacteristicsRequest.toString();
    EntityReference actualSourceResult =
        immutableDataTypeDecoratorRatingCharacteristicsRequest.source();
    EntityReference actualTargetResult =
        immutableDataTypeDecoratorRatingCharacteristicsRequest.target();

    // Assert
    assertTrue(actualSourceResult instanceof ImmutableEntityReference);
    assertTrue(actualTargetResult instanceof ImmutableEntityReference);
    assertEquals(
        "DataTypeDecoratorRatingCharacteristicsRequest{source=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, target=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(actualSourceResult, actualTargetResult);
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setSource(EntityReference)}
   *   <li>{@link Json#setTarget(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setSource(EntityReference)",
    "void Json.setTarget(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference source =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setSource(source);
    actualJson.setTarget(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.source;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.target;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(source, entityReference2);
  }

  /**
   * Test Json {@link Json#source()}.
   *
   * <p>Method under test: {@link Json#source()}
   */
  @Test
  @DisplayName("Test Json source()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.source()"})
  void testJsonSource() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().source());
  }

  /**
   * Test Json {@link Json#target()}.
   *
   * <p>Method under test: {@link Json#target()}
   */
  @Test
  @DisplayName("Test Json target()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.target()"})
  void testJsonTarget() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().target());
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#withSource(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#withSource(EntityReference)}
   */
  @Test
  @DisplayName("Test withSource(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristicsRequest ImmutableDataTypeDecoratorRatingCharacteristicsRequest.withSource(EntityReference)"
  })
  void testWithSource() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
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
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest actualWithSourceResult =
        immutableDataTypeDecoratorRatingCharacteristicsRequest.withSource(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecoratorRatingCharacteristicsRequest, actualWithSourceResult);
  }

  /**
   * Test {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#withTarget(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableDataTypeDecoratorRatingCharacteristicsRequest#withTarget(EntityReference)}
   */
  @Test
  @DisplayName("Test withTarget(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableDataTypeDecoratorRatingCharacteristicsRequest ImmutableDataTypeDecoratorRatingCharacteristicsRequest.withTarget(EntityReference)"
  })
  void testWithTarget() {
    // Arrange
    Builder builderResult = ImmutableDataTypeDecoratorRatingCharacteristicsRequest.builder();

    Builder sourceResult =
        builderResult.source(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest
        immutableDataTypeDecoratorRatingCharacteristicsRequest =
            sourceResult
                .target(
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
    ImmutableDataTypeDecoratorRatingCharacteristicsRequest actualWithTargetResult =
        immutableDataTypeDecoratorRatingCharacteristicsRequest.withTarget(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableDataTypeDecoratorRatingCharacteristicsRequest, actualWithTargetResult);
  }
}
