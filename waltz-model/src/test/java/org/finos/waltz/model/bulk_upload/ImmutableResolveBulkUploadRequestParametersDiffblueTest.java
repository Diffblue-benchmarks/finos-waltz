package org.finos.waltz.model.bulk_upload;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.bulk_upload.ImmutableResolveBulkUploadRequestParameters.Builder;
import org.finos.waltz.model.bulk_upload.ImmutableResolveBulkUploadRequestParameters.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableResolveBulkUploadRequestParametersDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#rowSubjectQualifier(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters Builder.build()",
    "Builder Builder.rowSubjectQualifier(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualRowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);
    Builder actualRowSubjectQualifierResult =
        actualRowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    Builder actualRowSubjectQualifierResult2 =
        actualRowSubjectQualifierResult.rowSubjectQualifier(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableEntityReference targetDomain =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableResolveBulkUploadRequestParameters actualImmutableResolveBulkUploadRequestParameters =
        actualRowSubjectQualifierResult2.targetDomain(targetDomain).build();

    // Assert
    assertEquals("Input String", actualImmutableResolveBulkUploadRequestParameters.inputString());
    assertEquals(
        EntityKind.ALL, actualImmutableResolveBulkUploadRequestParameters.rowSubjectKind());
    assertSame(targetDomain, actualImmutableResolveBulkUploadRequestParameters.targetDomain());
  }

  /**
   * Test Builder {@link Builder#from(ResolveBulkUploadRequestParameters)}.
   *
   * <p>Method under test: {@link Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveBulkUploadRequestParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolveBulkUploadRequestParameters)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();

    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters instance =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualImmutableResolveBulkUploadRequestParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableResolveBulkUploadRequestParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ResolveBulkUploadRequestParameters)}.
   *
   * <p>Method under test: {@link Builder#from(ResolveBulkUploadRequestParameters)}
   */
  @Test
  @DisplayName("Test Builder from(ResolveBulkUploadRequestParameters)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ResolveBulkUploadRequestParameters)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();

    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.empty();

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters instance =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualImmutableResolveBulkUploadRequestParameters =
        builderResult.build();
    assertEquals(instance, actualImmutableResolveBulkUploadRequestParameters);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#inputString(String)}.
   *
   * <ul>
   *   <li>When {@code Input String}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#inputString(String)}
   */
  @Test
  @DisplayName("Test Builder inputString(String); when 'Input String'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.inputString(String)"})
  void testBuilderInputString_whenInputString_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();

    // Act
    Builder actualInputStringResult = builderResult.inputString("Input String");

    // Assert
    assertSame(builderResult, actualInputStringResult);
  }

  /**
   * Test Builder {@link Builder#rowSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#rowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder rowSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowSubjectKind(EntityKind)"})
  void testBuilderRowSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();

    // Act
    Builder actualRowSubjectKindResult = builderResult.rowSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualRowSubjectKindResult);
  }

  /**
   * Test Builder {@link Builder#rowSubjectQualifier(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#rowSubjectQualifier(Optional)}
   */
  @Test
  @DisplayName("Test Builder rowSubjectQualifier(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rowSubjectQualifier(Optional)"})
  void testBuilderRowSubjectQualifierWithOptional() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    // Act
    Builder actualRowSubjectQualifierResult =
        builderResult.rowSubjectQualifier(rowSubjectQualifier);

    // Assert
    assertSame(builderResult, actualRowSubjectQualifierResult);
  }

  /**
   * Test Builder {@link Builder#targetDomain(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#targetDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder targetDomain(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetDomain(EntityReference)"})
  void testBuilderTargetDomain_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableResolveBulkUploadRequestParameters.builder();

    // Act
    Builder actualTargetDomainResult =
        builderResult.targetDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualTargetDomainResult);
  }

  /**
   * Test {@link
   * ImmutableResolveBulkUploadRequestParameters#copyOf(ResolveBulkUploadRequestParameters)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#copyOf(ResolveBulkUploadRequestParameters)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ResolveBulkUploadRequestParameters); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.copyOf(ResolveBulkUploadRequestParameters)"
  })
  void testCopyOf_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters instance =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualCopyOfResult =
        ImmutableResolveBulkUploadRequestParameters.copyOf(instance);

    // Assert
    EntityReference targetDomainResult = actualCopyOfResult.targetDomain();
    assertTrue(targetDomainResult instanceof ImmutableEntityReference);
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals("The characteristics of someone or something", targetDomainResult.description());
    assertEquals(1L, targetDomainResult.id());
    assertEquals(EntityKind.ALL, targetDomainResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, targetDomainResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}, and {@link
   * ImmutableResolveBulkUploadRequestParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier2 =
        Optional.of(immutableEntityReference2);

    Builder rowSubjectQualifierResult2 =
        rowSubjectKindResult2.rowSubjectQualifier(rowSubjectQualifier2);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters2 =
        rowSubjectQualifierResult2
            .targetDomain(
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
        immutableResolveBulkUploadRequestParameters, immutableResolveBulkUploadRequestParameters2);
    assertEquals(
        immutableResolveBulkUploadRequestParameters.hashCode(),
        immutableResolveBulkUploadRequestParameters2.hashCode());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}, and {@link
   * ImmutableResolveBulkUploadRequestParameters#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
        immutableResolveBulkUploadRequestParameters, immutableResolveBulkUploadRequestParameters);
    int expectedHashCodeResult = immutableResolveBulkUploadRequestParameters.hashCode();
    assertEquals(expectedHashCodeResult, immutableResolveBulkUploadRequestParameters.hashCode());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("inputString")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier2 =
        Optional.of(immutableEntityReference2);

    Builder rowSubjectQualifierResult2 =
        rowSubjectKindResult2.rowSubjectQualifier(rowSubjectQualifier2);

    // Act and Assert
    assertNotEquals(
        immutableResolveBulkUploadRequestParameters,
        rowSubjectQualifierResult2
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier2 =
        Optional.of(immutableEntityReference2);

    Builder rowSubjectQualifierResult2 =
        rowSubjectKindResult2.rowSubjectQualifier(rowSubjectQualifier2);

    // Act and Assert
    assertNotEquals(
        immutableResolveBulkUploadRequestParameters,
        rowSubjectQualifierResult2
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier2 =
        Optional.of(immutableEntityReference2);

    Builder rowSubjectQualifierResult2 =
        rowSubjectKindResult2.rowSubjectQualifier(rowSubjectQualifier2);

    // Act and Assert
    assertNotEquals(
        immutableResolveBulkUploadRequestParameters,
        rowSubjectQualifierResult2
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier2 =
        Optional.of(immutableEntityReference2);

    Builder rowSubjectQualifierResult2 =
        rowSubjectKindResult2.rowSubjectQualifier(rowSubjectQualifier2);

    // Act and Assert
    assertNotEquals(
        immutableResolveBulkUploadRequestParameters,
        rowSubjectQualifierResult2
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertNotEquals(
        rowSubjectQualifierResult
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableResolveBulkUploadRequestParameters.equals(Object)",
    "int ImmutableResolveBulkUploadRequestParameters.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertNotEquals(
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableResolveBulkUploadRequestParameters");
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return inputString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return inputString is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.fromJson(Json)"
  })
  void testFromJson_thenReturnInputStringIsJson() {
    // Arrange
    Json json = new Json();
    json.setInputString("Json");
    json.setTargetDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);
    json.setRowSubjectQualifier(rowSubjectQualifier);

    // Act
    ImmutableResolveBulkUploadRequestParameters actualFromJsonResult =
        ImmutableResolveBulkUploadRequestParameters.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RowSubjectQualifier is {@code null}.
   *   <li>Then return inputString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RowSubjectQualifier is 'null'; then return inputString is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.fromJson(Json)"
  })
  void testFromJson_whenJsonRowSubjectQualifierIsNull_thenReturnInputStringIsJson() {
    // Arrange
    Json json = new Json();
    json.setInputString("Json");
    json.setTargetDomain(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setRowSubjectKind(EntityKind.ALL);
    json.setRowSubjectQualifier(null);

    // Act
    ImmutableResolveBulkUploadRequestParameters actualFromJsonResult =
        ImmutableResolveBulkUploadRequestParameters.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#inputString()}
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#rowSubjectKind()}
   *   <li>{@link ImmutableResolveBulkUploadRequestParameters#targetDomain()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableResolveBulkUploadRequestParameters.inputString()",
    "EntityKind ImmutableResolveBulkUploadRequestParameters.rowSubjectKind()",
    "EntityReference ImmutableResolveBulkUploadRequestParameters.targetDomain()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
    String actualInputStringResult = immutableResolveBulkUploadRequestParameters.inputString();
    EntityKind actualRowSubjectKindResult =
        immutableResolveBulkUploadRequestParameters.rowSubjectKind();

    // Assert
    assertTrue(
        immutableResolveBulkUploadRequestParameters.targetDomain()
            instanceof ImmutableEntityReference);
    assertEquals("Input String", actualInputStringResult);
    assertEquals(EntityKind.ALL, actualRowSubjectKindResult);
  }

  /**
   * Test Json {@link Json#inputString()}.
   *
   * <p>Method under test: {@link Json#inputString()}
   */
  @Test
  @DisplayName("Test Json inputString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.inputString()"})
  void testJsonInputString() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().inputString());
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
    assertNull(actualJson.inputString);
    assertNull(actualJson.rowSubjectKind);
    assertNull(actualJson.targetDomain);
    assertFalse(actualJson.rowSubjectQualifier.isPresent());
  }

  /**
   * Test Json {@link Json#rowSubjectKind()}.
   *
   * <p>Method under test: {@link Json#rowSubjectKind()}
   */
  @Test
  @DisplayName("Test Json rowSubjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.rowSubjectKind()"})
  void testJsonRowSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rowSubjectKind());
  }

  /**
   * Test Json {@link Json#rowSubjectQualifier()}.
   *
   * <p>Method under test: {@link Json#rowSubjectQualifier()}
   */
  @Test
  @DisplayName("Test Json rowSubjectQualifier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.rowSubjectQualifier()"})
  void testJsonRowSubjectQualifier() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rowSubjectQualifier());
  }

  /**
   * Test Json {@link Json#targetDomain()}.
   *
   * <p>Method under test: {@link Json#targetDomain()}
   */
  @Test
  @DisplayName("Test Json targetDomain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.targetDomain()"})
  void testJsonTargetDomain() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().targetDomain());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#rowSubjectQualifier()}.
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#rowSubjectQualifier()}
   */
  @Test
  @DisplayName("Test rowSubjectQualifier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableResolveBulkUploadRequestParameters.rowSubjectQualifier()"})
  void testRowSubjectQualifier() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertEquals(
        rowSubjectQualifier,
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .rowSubjectQualifier());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#toString()}.
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolveBulkUploadRequestParameters.toString()"})
  void testToString() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertEquals(
        "ResolveBulkUploadRequestParameters{targetDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, rowSubjectKind=ALL, rowSubjectQualifier=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}}",
        rowSubjectQualifierResult
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#toString()}.
   *
   * <p>Method under test: {@link ImmutableResolveBulkUploadRequestParameters#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableResolveBulkUploadRequestParameters.toString()"})
  void testToString2() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.empty();

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertEquals(
        "ResolveBulkUploadRequestParameters{targetDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, rowSubjectKind=ALL}",
        rowSubjectQualifierResult
            .targetDomain(
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
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withInputString(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withInputString(String)"
  })
  void testWithInputString() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("42")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualWithInputStringResult =
        immutableResolveBulkUploadRequestParameters.withInputString("42");

    // Assert
    assertSame(immutableResolveBulkUploadRequestParameters, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withInputString(String)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withInputString(String)"
  })
  void testWithInputString_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act
    ImmutableResolveBulkUploadRequestParameters actualWithInputStringResult =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withInputString("42");

    // Assert
    EntityReference targetDomainResult = actualWithInputStringResult.targetDomain();
    assertTrue(targetDomainResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithInputStringResult.inputString());
    assertEquals("The characteristics of someone or something", targetDomainResult.description());
    assertEquals(1L, targetDomainResult.id());
    assertEquals(EntityKind.ALL, targetDomainResult.kind());
    assertEquals(EntityKind.ALL, actualWithInputStringResult.rowSubjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, targetDomainResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withRowSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withRowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withRowSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withRowSubjectKind(EntityKind)"
  })
  void testWithRowSubjectKind() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualWithRowSubjectKindResult =
        immutableResolveBulkUploadRequestParameters.withRowSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableResolveBulkUploadRequestParameters, actualWithRowSubjectKindResult);
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withRowSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withRowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withRowSubjectKind(EntityKind); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withRowSubjectKind(EntityKind)"
  })
  void testWithRowSubjectKind_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ACTOR);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act
    ImmutableResolveBulkUploadRequestParameters actualWithRowSubjectKindResult =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withRowSubjectKind(EntityKind.ALL);

    // Assert
    EntityReference targetDomainResult = actualWithRowSubjectKindResult.targetDomain();
    assertTrue(targetDomainResult instanceof ImmutableEntityReference);
    assertEquals("Input String", actualWithRowSubjectKindResult.inputString());
    assertEquals("The characteristics of someone or something", targetDomainResult.description());
    assertEquals(1L, targetDomainResult.id());
    assertEquals(EntityKind.ALL, targetDomainResult.kind());
    assertEquals(EntityKind.ALL, actualWithRowSubjectKindResult.rowSubjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, targetDomainResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withRowSubjectQualifier(Optional)} with
   * {@code optional}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withRowSubjectQualifier(Optional)}
   */
  @Test
  @DisplayName("Test withRowSubjectQualifier(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withRowSubjectQualifier(Optional)"
  })
  void testWithRowSubjectQualifierWithOptional() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();
    ImmutableEntityReference immutableEntityReference2 =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> optional = Optional.of(immutableEntityReference2);

    // Act
    ImmutableResolveBulkUploadRequestParameters actualWithRowSubjectQualifierResult =
        immutableResolveBulkUploadRequestParameters.withRowSubjectQualifier(optional);

    // Assert
    assertEquals(immutableResolveBulkUploadRequestParameters, actualWithRowSubjectQualifierResult);
  }

  /**
   * Test {@link
   * ImmutableResolveBulkUploadRequestParameters#withRowSubjectQualifier(EntityReference)} with
   * {@code value}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withRowSubjectQualifier(EntityReference)}
   */
  @Test
  @DisplayName("Test withRowSubjectQualifier(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withRowSubjectQualifier(EntityReference)"
  })
  void testWithRowSubjectQualifierWithValue() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualWithRowSubjectQualifierResult =
        immutableResolveBulkUploadRequestParameters.withRowSubjectQualifier(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableResolveBulkUploadRequestParameters, actualWithRowSubjectQualifierResult);
  }

  /**
   * Test {@link ImmutableResolveBulkUploadRequestParameters#withTargetDomain(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableResolveBulkUploadRequestParameters#withTargetDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetDomain(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableResolveBulkUploadRequestParameters ImmutableResolveBulkUploadRequestParameters.withTargetDomain(EntityReference)"
  })
  void testWithTargetDomain() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableResolveBulkUploadRequestParameters.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    ImmutableEntityReference immutableEntityReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.of(immutableEntityReference);

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableResolveBulkUploadRequestParameters immutableResolveBulkUploadRequestParameters =
        rowSubjectQualifierResult
            .targetDomain(
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
    ImmutableResolveBulkUploadRequestParameters actualWithTargetDomainResult =
        immutableResolveBulkUploadRequestParameters.withTargetDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableResolveBulkUploadRequestParameters, actualWithTargetDomainResult);
  }
}
