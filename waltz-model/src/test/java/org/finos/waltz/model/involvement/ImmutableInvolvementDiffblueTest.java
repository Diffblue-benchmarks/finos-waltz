package org.finos.waltz.model.involvement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.ProvenanceProvider;
import org.finos.waltz.model.actor.ImmutableActor;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Builder;
import org.finos.waltz.model.involvement.ImmutableInvolvement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableInvolvementDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#provenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement Builder.build()", "Builder Builder.provenance(String)"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualEmployeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableEntityReference entityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableInvolvement actualImmutableInvolvement =
        actualEmployeeIdResult
            .entityReference(entityReference)
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Assert
    assertEquals("42", actualImmutableInvolvement.employeeId());
    assertEquals("Provenance", actualImmutableInvolvement.provenance());
    assertEquals(1L, actualImmutableInvolvement.kindId());
    assertTrue(actualImmutableInvolvement.isReadOnly());
    assertSame(entityReference, actualImmutableInvolvement.entityReference());
  }

  /**
   * Test Builder {@link Builder#employeeId(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#employeeId(String)}
   */
  @Test
  @DisplayName("Test Builder employeeId(String); when '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.employeeId(String)"})
  void testBuilderEmployeeId_when42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act
    Builder actualEmployeeIdResult = builderResult.employeeId("42");

    // Assert
    assertSame(builderResult, actualEmployeeIdResult);
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
    Builder builderResult = ImmutableInvolvement.builder();

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
   * Test Builder {@link Builder#from(Involvement)} with {@code Involvement}.
   *
   * <p>Method under test: {@link Builder#from(Involvement)}
   */
  @Test
  @DisplayName("Test Builder from(Involvement) with 'Involvement'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(Involvement)"})
  void testBuilderFromWithInvolvement() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement instance =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableInvolvement actualImmutableInvolvement = builderResult.build();
    assertEquals(instance, actualImmutableInvolvement);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement instance =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    ImmutableInvolvement actualImmutableInvolvement =
        builderResult.from((ProvenanceProvider) instance).build();
    assertEquals(instance, actualImmutableInvolvement);
    ImmutableInvolvement actualImmutableInvolvement2 = builderResult.build();
    assertEquals(instance, actualImmutableInvolvement2);
  }

  /**
   * Test Builder {@link Builder#from(ProvenanceProvider)} with {@code ProvenanceProvider}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ProvenanceProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ProvenanceProvider) with 'ProvenanceProvider'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProvenanceProvider)"})
  void testBuilderFromWithProvenanceProvider_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            ImmutableActor.builder()
                .description("The characteristics of someone or something")
                .externalId("42")
                .id(1L)
                .isExternal(true)
                .kind(EntityKind.ALL)
                .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                .lastUpdatedBy("2020-03-01")
                .name("Name")
                .provenance("Provenance")
                .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
  }

  /**
   * Test Builder {@link Builder#kindId(long)}.
   *
   * <p>Method under test: {@link Builder#kindId(long)}
   */
  @Test
  @DisplayName("Test Builder kindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.kindId(long)"})
  void testBuilderKindId() {
    // Arrange
    Builder builderResult = ImmutableInvolvement.builder();

    // Act
    Builder actualKindIdResult = builderResult.kindId(1L);

    // Assert
    assertSame(builderResult, actualKindIdResult);
  }

  /**
   * Test {@link ImmutableInvolvement#copyOf(Involvement)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#copyOf(Involvement)}
   */
  @Test
  @DisplayName("Test copyOf(Involvement); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.copyOf(Involvement)"})
  void testCopyOf_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement instance =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvement actualCopyOfResult = ImmutableInvolvement.copyOf(instance);

    // Assert
    EntityReference entityReferenceResult = actualCopyOfResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualCopyOfResult.employeeId());
    assertEquals("Provenance", actualCopyOfResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}, and {@link ImmutableInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvement#equals(Object)}
   *   <li>{@link ImmutableInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement2 =
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableInvolvement, immutableInvolvement2);
    assertEquals(immutableInvolvement.hashCode(), immutableInvolvement2.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}, and {@link ImmutableInvolvement#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvement#equals(Object)}
   *   <li>{@link ImmutableInvolvement#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act and Assert
    assertEquals(immutableInvolvement, immutableInvolvement);
    int expectedHashCodeResult = immutableInvolvement.hashCode();
    assertEquals(expectedHashCodeResult, immutableInvolvement.hashCode());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("Provenance");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableInvolvement,
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableInvolvement,
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(2L)
            .provenance("Provenance")
            .build();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableInvolvement,
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("42")
            .build();

    Builder employeeIdResult2 = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        immutableInvolvement,
        employeeIdResult2
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build());
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableInvolvement#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableInvolvement.equals(Object)",
    "int ImmutableInvolvement.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertNotEquals(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build(),
        "Different type to ImmutableInvolvement");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableInvolvement#toString()}
   *   <li>{@link ImmutableInvolvement#employeeId()}
   *   <li>{@link ImmutableInvolvement#entityReference()}
   *   <li>{@link ImmutableInvolvement#kindId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableInvolvement.employeeId()",
    "EntityReference ImmutableInvolvement.entityReference()",
    "long ImmutableInvolvement.kindId()",
    "String ImmutableInvolvement.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    String actualToStringResult = immutableInvolvement.toString();
    String actualEmployeeIdResult = immutableInvolvement.employeeId();
    EntityReference actualEntityReferenceResult = immutableInvolvement.entityReference();

    // Assert
    assertTrue(actualEntityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualEmployeeIdResult);
    assertEquals(
        "Involvement{kindId=1, entityReference=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " employeeId=42, isReadOnly=true, provenance=Provenance}",
        actualToStringResult);
    assertEquals(1L, immutableInvolvement.kindId());
  }

  /**
   * Test {@link ImmutableInvolvement#isReadOnly()}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#isReadOnly()}
   */
  @Test
  @DisplayName("Test isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableInvolvement.isReadOnly()"})
  void testIsReadOnly() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertTrue(
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .isReadOnly());
  }

  /**
   * Test Json {@link Json#employeeId()}.
   *
   * <p>Method under test: {@link Json#employeeId()}
   */
  @Test
  @DisplayName("Test Json employeeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.employeeId()"})
  void testJsonEmployeeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().employeeId());
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
   *   <li>{@link Json#setEmployeeId(String)}
   *   <li>{@link Json#setEntityReference(EntityReference)}
   *   <li>{@link Json#setProvenance(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setEmployeeId(String)",
    "void Json.setEntityReference(EntityReference)",
    "void Json.setProvenance(String)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setEmployeeId("42");
    actualJson.setEntityReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setProvenance("Provenance");

    // Assert
    EntityReference entityReference = actualJson.entityReference;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    assertEquals("42", actualJson.employeeId);
    assertEquals("Provenance", actualJson.provenance);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(0L, actualJson.kindId);
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.kindIdIsSet);
  }

  /**
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
  }

  /**
   * Test Json {@link Json#kindId()}.
   *
   * <p>Method under test: {@link Json#kindId()}
   */
  @Test
  @DisplayName("Test Json kindId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.kindId()"})
  void testJsonKindId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kindId());
  }

  /**
   * Test Json {@link Json#provenance()}.
   *
   * <p>Method under test: {@link Json#provenance()}
   */
  @Test
  @DisplayName("Test Json provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.provenance()"})
  void testJsonProvenance() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().provenance());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#setKindId(long)}.
   *
   * <p>Method under test: {@link Json#setKindId(long)}
   */
  @Test
  @DisplayName("Test Json setKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setKindId(long)"})
  void testJsonSetKindId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setKindId(1L);

    // Assert
    assertEquals(1L, json.kindId);
    assertTrue(json.kindIdIsSet);
  }

  /**
   * Test {@link ImmutableInvolvement#provenance()}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#provenance()}
   */
  @Test
  @DisplayName("Test provenance()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableInvolvement.provenance()"})
  void testProvenance() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act and Assert
    assertEquals(
        "Provenance",
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .provenance());
  }

  /**
   * Test {@link ImmutableInvolvement#withEmployeeId(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#withEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withEmployeeId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withEmployeeId(String)"})
  void testWithEmployeeId() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvement actualWithEmployeeIdResult = immutableInvolvement.withEmployeeId("42");

    // Assert
    assertSame(immutableInvolvement, actualWithEmployeeIdResult);
  }

  /**
   * Test {@link ImmutableInvolvement#withEmployeeId(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#withEmployeeId(String)}
   */
  @Test
  @DisplayName("Test withEmployeeId(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withEmployeeId(String)"})
  void testWithEmployeeId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("employeeId");

    // Act
    ImmutableInvolvement actualWithEmployeeIdResult =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .withEmployeeId("42");

    // Assert
    EntityReference entityReferenceResult = actualWithEmployeeIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithEmployeeIdResult.employeeId());
    assertEquals("Provenance", actualWithEmployeeIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithEmployeeIdResult.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithEmployeeIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableInvolvement#withEntityReference(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#withEntityReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withEntityReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableInvolvement ImmutableInvolvement.withEntityReference(EntityReference)"
  })
  void testWithEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvement actualWithEntityReferenceResult =
        immutableInvolvement.withEntityReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableInvolvement, actualWithEntityReferenceResult);
  }

  /**
   * Test {@link ImmutableInvolvement#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withIsReadOnly(boolean)"})
  void testWithIsReadOnly() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvement actualWithIsReadOnlyResult = immutableInvolvement.withIsReadOnly(true);

    // Assert
    assertSame(immutableInvolvement, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableInvolvement#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName(
      "Test withIsReadOnly(boolean); when 'false'; then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withIsReadOnly(boolean)"})
  void testWithIsReadOnly_whenFalse_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    ImmutableInvolvement actualWithIsReadOnlyResult =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .withIsReadOnly(false);

    // Assert
    EntityReference entityReferenceResult = actualWithIsReadOnlyResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithIsReadOnlyResult.employeeId());
    assertEquals("Provenance", actualWithIsReadOnlyResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithIsReadOnlyResult.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertFalse(actualWithIsReadOnlyResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableInvolvement#withKindId(long)}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#withKindId(long)}
   */
  @Test
  @DisplayName("Test withKindId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withKindId(long)"})
  void testWithKindId() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(42L)
            .provenance("Provenance")
            .build();

    // Act
    ImmutableInvolvement actualWithKindIdResult = immutableInvolvement.withKindId(42L);

    // Assert
    assertSame(immutableInvolvement, actualWithKindIdResult);
  }

  /**
   * Test {@link ImmutableInvolvement#withKindId(long)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#withKindId(long)}
   */
  @Test
  @DisplayName("Test withKindId(long); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withKindId(long)"})
  void testWithKindId_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    ImmutableInvolvement actualWithKindIdResult =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .withKindId(42L);

    // Assert
    EntityReference entityReferenceResult = actualWithKindIdResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithKindIdResult.employeeId());
    assertEquals("Provenance", actualWithKindIdResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(42L, actualWithKindIdResult.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithKindIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableInvolvement#withProvenance(String)}.
   *
   * <p>Method under test: {@link ImmutableInvolvement#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withProvenance(String)"})
  void testWithProvenance() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");
    ImmutableInvolvement immutableInvolvement =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("42")
            .build();

    // Act
    ImmutableInvolvement actualWithProvenanceResult = immutableInvolvement.withProvenance("42");

    // Assert
    assertSame(immutableInvolvement, actualWithProvenanceResult);
  }

  /**
   * Test {@link ImmutableInvolvement#withProvenance(String)}.
   *
   * <ul>
   *   <li>Then entityReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableInvolvement#withProvenance(String)}
   */
  @Test
  @DisplayName("Test withProvenance(String); then entityReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableInvolvement ImmutableInvolvement.withProvenance(String)"})
  void testWithProvenance_thenEntityReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder employeeIdResult = ImmutableInvolvement.builder().employeeId("42");

    // Act
    ImmutableInvolvement actualWithProvenanceResult =
        employeeIdResult
            .entityReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .kindId(1L)
            .provenance("Provenance")
            .build()
            .withProvenance("42");

    // Assert
    EntityReference entityReferenceResult = actualWithProvenanceResult.entityReference();
    assertTrue(entityReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithProvenanceResult.employeeId());
    assertEquals("42", actualWithProvenanceResult.provenance());
    assertEquals(
        "The characteristics of someone or something", entityReferenceResult.description());
    assertEquals(1L, entityReferenceResult.id());
    assertEquals(1L, actualWithProvenanceResult.kindId());
    assertEquals(EntityKind.ALL, entityReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReferenceResult.entityLifecycleStatus());
    assertTrue(actualWithProvenanceResult.isReadOnly());
  }
}
