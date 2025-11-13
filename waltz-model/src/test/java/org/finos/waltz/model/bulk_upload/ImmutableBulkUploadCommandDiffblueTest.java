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
import org.finos.waltz.model.bulk_upload.ImmutableBulkUploadCommand.Builder;
import org.finos.waltz.model.bulk_upload.ImmutableBulkUploadCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableBulkUploadCommandDiffblueTest {
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
    "ImmutableBulkUploadCommand Builder.build()",
    "Builder Builder.rowSubjectQualifier(EntityReference)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualRowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand actualImmutableBulkUploadCommand =
        actualRowSubjectQualifierResult2
            .targetDomain(targetDomain)
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Assert
    assertEquals("Input String", actualImmutableBulkUploadCommand.inputString());
    assertEquals(EntityKind.ALL, actualImmutableBulkUploadCommand.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualImmutableBulkUploadCommand.uploadMode());
    assertSame(targetDomain, actualImmutableBulkUploadCommand.targetDomain());
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand instance =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadCommand actualImmutableBulkUploadCommand = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadCommand);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(BulkUploadCommand)}.
   *
   * <p>Method under test: {@link Builder#from(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test Builder from(BulkUploadCommand)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(BulkUploadCommand)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.empty();

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);
    ImmutableBulkUploadCommand instance =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableBulkUploadCommand actualImmutableBulkUploadCommand = builderResult.build();
    assertEquals(instance, actualImmutableBulkUploadCommand);
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
    Builder builderResult = ImmutableBulkUploadCommand.builder();

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
    Builder builderResult = ImmutableBulkUploadCommand.builder();

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
    Builder builderResult = ImmutableBulkUploadCommand.builder();
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
    Builder builderResult = ImmutableBulkUploadCommand.builder();

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
   * Test Builder {@link Builder#uploadMode(BulkUploadMode)}.
   *
   * <p>Method under test: {@link Builder#uploadMode(BulkUploadMode)}
   */
  @Test
  @DisplayName("Test Builder uploadMode(BulkUploadMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.uploadMode(BulkUploadMode)"})
  void testBuilderUploadMode() {
    // Arrange
    Builder builderResult = ImmutableBulkUploadCommand.builder();

    // Act
    Builder actualUploadModeResult = builderResult.uploadMode(BulkUploadMode.ADD_ONLY);

    // Assert
    assertSame(builderResult, actualUploadModeResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#copyOf(BulkUploadCommand)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#copyOf(BulkUploadCommand)}
   */
  @Test
  @DisplayName("Test copyOf(BulkUploadCommand); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.copyOf(BulkUploadCommand)"
  })
  void testCopyOf_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand instance =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualCopyOfResult = ImmutableBulkUploadCommand.copyOf(instance);

    // Assert
    EntityReference targetDomainResult = actualCopyOfResult.targetDomain();
    assertTrue(targetDomainResult instanceof ImmutableEntityReference);
    assertEquals("Input String", actualCopyOfResult.inputString());
    assertEquals("The characteristics of someone or something", targetDomainResult.description());
    assertEquals(1L, targetDomainResult.id());
    assertEquals(EntityKind.ALL, targetDomainResult.kind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.rowSubjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, targetDomainResult.entityLifecycleStatus());
    assertEquals(BulkUploadMode.ADD_ONLY, actualCopyOfResult.uploadMode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}, and {@link
   * ImmutableBulkUploadCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadCommand#equals(Object)}
   *   <li>{@link ImmutableBulkUploadCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand2 =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act and Assert
    assertEquals(immutableBulkUploadCommand, immutableBulkUploadCommand2);
    assertEquals(immutableBulkUploadCommand.hashCode(), immutableBulkUploadCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}, and {@link
   * ImmutableBulkUploadCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadCommand#equals(Object)}
   *   <li>{@link ImmutableBulkUploadCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act and Assert
    assertEquals(immutableBulkUploadCommand, immutableBulkUploadCommand);
    int expectedHashCodeResult = immutableBulkUploadCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableBulkUploadCommand.hashCode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
        immutableBulkUploadCommand,
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
        immutableBulkUploadCommand,
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
        immutableBulkUploadCommand,
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
        immutableBulkUploadCommand,
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.REPLACE)
            .build();

    Builder rowSubjectKindResult2 =
        ImmutableBulkUploadCommand.builder()
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
        immutableBulkUploadCommand,
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableBulkUploadCommand.equals(Object)",
    "int ImmutableBulkUploadCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build(),
        "Different type to ImmutableBulkUploadCommand");
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return inputString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return inputString is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkUploadCommand ImmutableBulkUploadCommand.fromJson(Json)"})
  void testFromJson_thenReturnInputStringIsJson() {
    // Arrange
    Json json = new Json();
    json.setUploadMode(BulkUploadMode.ADD_ONLY);
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
    ImmutableBulkUploadCommand actualFromJsonResult = ImmutableBulkUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualFromJsonResult.uploadMode());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) RowSubjectQualifier is {@code null}.
   *   <li>Then return inputString is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) RowSubjectQualifier is 'null'; then return inputString is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableBulkUploadCommand ImmutableBulkUploadCommand.fromJson(Json)"})
  void testFromJson_whenJsonRowSubjectQualifierIsNull_thenReturnInputStringIsJson() {
    // Arrange
    Json json = new Json();
    json.setUploadMode(BulkUploadMode.ADD_ONLY);
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
    ImmutableBulkUploadCommand actualFromJsonResult = ImmutableBulkUploadCommand.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.inputString());
    assertEquals(EntityKind.ALL, actualFromJsonResult.rowSubjectKind());
    assertEquals(BulkUploadMode.ADD_ONLY, actualFromJsonResult.uploadMode());
    EntityReference expectedTargetDomainResult = json.targetDomain;
    assertSame(expectedTargetDomainResult, actualFromJsonResult.targetDomain());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableBulkUploadCommand#inputString()}
   *   <li>{@link ImmutableBulkUploadCommand#rowSubjectKind()}
   *   <li>{@link ImmutableBulkUploadCommand#targetDomain()}
   *   <li>{@link ImmutableBulkUploadCommand#uploadMode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableBulkUploadCommand.inputString()",
    "EntityKind ImmutableBulkUploadCommand.rowSubjectKind()",
    "EntityReference ImmutableBulkUploadCommand.targetDomain()",
    "BulkUploadMode ImmutableBulkUploadCommand.uploadMode()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    String actualInputStringResult = immutableBulkUploadCommand.inputString();
    EntityKind actualRowSubjectKindResult = immutableBulkUploadCommand.rowSubjectKind();
    EntityReference actualTargetDomainResult = immutableBulkUploadCommand.targetDomain();

    // Assert
    assertTrue(actualTargetDomainResult instanceof ImmutableEntityReference);
    assertEquals("Input String", actualInputStringResult);
    assertEquals(EntityKind.ALL, actualRowSubjectKindResult);
    assertEquals(BulkUploadMode.ADD_ONLY, immutableBulkUploadCommand.uploadMode());
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
    assertNull(actualJson.uploadMode);
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
   * Test Json {@link Json#uploadMode()}.
   *
   * <p>Method under test: {@link Json#uploadMode()}
   */
  @Test
  @DisplayName("Test Json uploadMode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"BulkUploadMode Json.uploadMode()"})
  void testJsonUploadMode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().uploadMode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#rowSubjectQualifier()}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#rowSubjectQualifier()}
   */
  @Test
  @DisplayName("Test rowSubjectQualifier()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableBulkUploadCommand.rowSubjectQualifier()"})
  void testRowSubjectQualifier() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build()
            .rowSubjectQualifier());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableBulkUploadCommand.toString()"})
  void testToString() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
        "BulkUploadCommand{uploadMode=ADD_ONLY, targetDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#toString()}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableBulkUploadCommand.toString()"})
  void testToString2() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
            .inputString("Input String")
            .rowSubjectKind(EntityKind.ALL);
    Optional<? extends EntityReference> rowSubjectQualifier = Optional.empty();

    Builder rowSubjectQualifierResult =
        rowSubjectKindResult.rowSubjectQualifier(rowSubjectQualifier);

    // Act and Assert
    assertEquals(
        "BulkUploadCommand{uploadMode=ADD_ONLY, targetDomain=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withInputString(String)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withInputString(String)"
  })
  void testWithInputString() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder().inputString("42").rowSubjectKind(EntityKind.ALL);
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualWithInputStringResult =
        immutableBulkUploadCommand.withInputString("42");

    // Assert
    assertSame(immutableBulkUploadCommand, actualWithInputStringResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withInputString(String)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withInputString(String)}
   */
  @Test
  @DisplayName("Test withInputString(String); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withInputString(String)"
  })
  void testWithInputString_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand actualWithInputStringResult =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
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
    assertEquals(BulkUploadMode.ADD_ONLY, actualWithInputStringResult.uploadMode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withRowSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withRowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withRowSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withRowSubjectKind(EntityKind)"
  })
  void testWithRowSubjectKind() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualWithRowSubjectKindResult =
        immutableBulkUploadCommand.withRowSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableBulkUploadCommand, actualWithRowSubjectKindResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withRowSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withRowSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName(
      "Test withRowSubjectKind(EntityKind); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withRowSubjectKind(EntityKind)"
  })
  void testWithRowSubjectKind_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand actualWithRowSubjectKindResult =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
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
    assertEquals(BulkUploadMode.ADD_ONLY, actualWithRowSubjectKindResult.uploadMode());
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withRowSubjectQualifier(Optional)} with {@code
   * optional}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withRowSubjectQualifier(Optional)}
   */
  @Test
  @DisplayName("Test withRowSubjectQualifier(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withRowSubjectQualifier(Optional)"
  })
  void testWithRowSubjectQualifierWithOptional() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
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
    ImmutableBulkUploadCommand actualWithRowSubjectQualifierResult =
        immutableBulkUploadCommand.withRowSubjectQualifier(optional);

    // Assert
    assertEquals(immutableBulkUploadCommand, actualWithRowSubjectQualifierResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withRowSubjectQualifier(EntityReference)} with {@code
   * value}.
   *
   * <p>Method under test: {@link
   * ImmutableBulkUploadCommand#withRowSubjectQualifier(EntityReference)}
   */
  @Test
  @DisplayName("Test withRowSubjectQualifier(EntityReference) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withRowSubjectQualifier(EntityReference)"
  })
  void testWithRowSubjectQualifierWithValue() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualWithRowSubjectQualifierResult =
        immutableBulkUploadCommand.withRowSubjectQualifier(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkUploadCommand, actualWithRowSubjectQualifierResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withTargetDomain(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withTargetDomain(EntityReference)}
   */
  @Test
  @DisplayName("Test withTargetDomain(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withTargetDomain(EntityReference)"
  })
  void testWithTargetDomain() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualWithTargetDomainResult =
        immutableBulkUploadCommand.withTargetDomain(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableBulkUploadCommand, actualWithTargetDomainResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withUploadMode(BulkUploadMode)}.
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withUploadMode(BulkUploadMode)}
   */
  @Test
  @DisplayName("Test withUploadMode(BulkUploadMode)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withUploadMode(BulkUploadMode)"
  })
  void testWithUploadMode() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand immutableBulkUploadCommand =
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
            .uploadMode(BulkUploadMode.ADD_ONLY)
            .build();

    // Act
    ImmutableBulkUploadCommand actualWithUploadModeResult =
        immutableBulkUploadCommand.withUploadMode(BulkUploadMode.ADD_ONLY);

    // Assert
    assertSame(immutableBulkUploadCommand, actualWithUploadModeResult);
  }

  /**
   * Test {@link ImmutableBulkUploadCommand#withUploadMode(BulkUploadMode)}.
   *
   * <ul>
   *   <li>Then targetDomain return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableBulkUploadCommand#withUploadMode(BulkUploadMode)}
   */
  @Test
  @DisplayName(
      "Test withUploadMode(BulkUploadMode); then targetDomain return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableBulkUploadCommand ImmutableBulkUploadCommand.withUploadMode(BulkUploadMode)"
  })
  void testWithUploadMode_thenTargetDomainReturnImmutableEntityReference() {
    // Arrange
    Builder rowSubjectKindResult =
        ImmutableBulkUploadCommand.builder()
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
    ImmutableBulkUploadCommand actualWithUploadModeResult =
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
            .uploadMode(BulkUploadMode.REPLACE)
            .build()
            .withUploadMode(BulkUploadMode.ADD_ONLY);

    // Assert
    EntityReference targetDomainResult = actualWithUploadModeResult.targetDomain();
    assertTrue(targetDomainResult instanceof ImmutableEntityReference);
    assertEquals("Input String", actualWithUploadModeResult.inputString());
    assertEquals("The characteristics of someone or something", targetDomainResult.description());
    assertEquals(1L, targetDomainResult.id());
    assertEquals(EntityKind.ALL, targetDomainResult.kind());
    assertEquals(EntityKind.ALL, actualWithUploadModeResult.rowSubjectKind());
    assertEquals(EntityLifecycleStatus.ACTIVE, targetDomainResult.entityLifecycleStatus());
    assertEquals(BulkUploadMode.ADD_ONLY, actualWithUploadModeResult.uploadMode());
  }
}
