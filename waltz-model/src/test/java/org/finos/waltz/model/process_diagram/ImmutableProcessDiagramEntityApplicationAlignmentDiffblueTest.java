package org.finos.waltz.model.process_diagram;

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
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntityApplicationAlignment.Builder;
import org.finos.waltz.model.process_diagram.ImmutableProcessDiagramEntityApplicationAlignment.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableProcessDiagramEntityApplicationAlignmentDiffblueTest {
  /**
   * Test Builder {@link Builder#applicationRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicationRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder applicationRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicationRef(EntityReference)"})
  void testBuilderApplicationRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act
    Builder actualApplicationRefResult = builderResult.applicationRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualApplicationRefResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableProcessDiagramEntityApplicationAlignment Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();
    ImmutableEntityReference applicationRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualApplicationRefResult = actualBuilderResult.applicationRef(applicationRef);
    ImmutableEntityReference diagramMeasurableRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualDiagramMeasurableRefResult =
        actualApplicationRefResult.diagramMeasurableRef(diagramMeasurableRef);
    ImmutableEntityReference referencedMeasurableRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableProcessDiagramEntityApplicationAlignment
        actualImmutableProcessDiagramEntityApplicationAlignment =
            actualDiagramMeasurableRefResult
                .referencedMeasurableRef(referencedMeasurableRef)
                .build();

    // Assert
    assertSame(
        applicationRef, actualImmutableProcessDiagramEntityApplicationAlignment.applicationRef());
    assertSame(
        diagramMeasurableRef,
        actualImmutableProcessDiagramEntityApplicationAlignment.diagramMeasurableRef());
    assertSame(
        referencedMeasurableRef,
        actualImmutableProcessDiagramEntityApplicationAlignment.referencedMeasurableRef());
  }

  /**
   * Test Builder {@link Builder#diagramMeasurableRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#diagramMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder diagramMeasurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.diagramMeasurableRef(EntityReference)"})
  void testBuilderDiagramMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act
    Builder actualDiagramMeasurableRefResult =
        builderResult.diagramMeasurableRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualDiagramMeasurableRefResult);
  }

  /**
   * Test Builder {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}.
   *
   * <p>Method under test: {@link Builder#from(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  @DisplayName("Test Builder from(ProcessDiagramEntityApplicationAlignment)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ProcessDiagramEntityApplicationAlignment)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder builderResult2 = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult2.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment instance =
        diagramMeasurableRefResult
            .referencedMeasurableRef(
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
    ImmutableProcessDiagramEntityApplicationAlignment
        actualImmutableProcessDiagramEntityApplicationAlignment = builderResult.build();
    assertEquals(instance, actualImmutableProcessDiagramEntityApplicationAlignment);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#referencedMeasurableRef(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#referencedMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder referencedMeasurableRef(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.referencedMeasurableRef(EntityReference)"})
  void testBuilderReferencedMeasurableRef_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    // Act
    Builder actualReferencedMeasurableRefResult =
        builderResult.referencedMeasurableRef(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualReferencedMeasurableRefResult);
  }

  /**
   * Test {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#copyOf(ProcessDiagramEntityApplicationAlignment)}.
   *
   * <ul>
   *   <li>Then applicationRef return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#copyOf(ProcessDiagramEntityApplicationAlignment)}
   */
  @Test
  @DisplayName(
      "Test copyOf(ProcessDiagramEntityApplicationAlignment); then applicationRef return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntityApplicationAlignment ImmutableProcessDiagramEntityApplicationAlignment.copyOf(ProcessDiagramEntityApplicationAlignment)"
  })
  void testCopyOf_thenApplicationRefReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment instance =
        diagramMeasurableRefResult
            .referencedMeasurableRef(
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
    ImmutableProcessDiagramEntityApplicationAlignment actualCopyOfResult =
        ImmutableProcessDiagramEntityApplicationAlignment.copyOf(instance);

    // Assert
    EntityReference applicationRefResult2 = actualCopyOfResult.applicationRef();
    assertTrue(applicationRefResult2 instanceof ImmutableEntityReference);
    EntityReference diagramMeasurableRefResult2 = actualCopyOfResult.diagramMeasurableRef();
    assertTrue(diagramMeasurableRefResult2 instanceof ImmutableEntityReference);
    EntityReference referencedMeasurableRefResult = actualCopyOfResult.referencedMeasurableRef();
    assertTrue(referencedMeasurableRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", applicationRefResult2.description());
    assertEquals(1L, applicationRefResult2.id());
    assertEquals(EntityKind.ALL, applicationRefResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, applicationRefResult2.entityLifecycleStatus());
    assertEquals(applicationRefResult2, diagramMeasurableRefResult2);
    assertEquals(applicationRefResult2, referencedMeasurableRefResult);
  }

  /**
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}, and {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult2 =
        builderResult2.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult2 =
        applicationRefResult2.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment2 =
            diagramMeasurableRefResult2
                .referencedMeasurableRef(
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
        immutableProcessDiagramEntityApplicationAlignment,
        immutableProcessDiagramEntityApplicationAlignment2);
    assertEquals(
        immutableProcessDiagramEntityApplicationAlignment.hashCode(),
        immutableProcessDiagramEntityApplicationAlignment2.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}, and {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
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
        immutableProcessDiagramEntityApplicationAlignment,
        immutableProcessDiagramEntityApplicationAlignment);
    int expectedHashCodeResult = immutableProcessDiagramEntityApplicationAlignment.hashCode();
    assertEquals(
        expectedHashCodeResult, immutableProcessDiagramEntityApplicationAlignment.hashCode());
  }

  /**
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult2 =
        builderResult2.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult2 =
        applicationRefResult2.diagramMeasurableRef(
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
        immutableProcessDiagramEntityApplicationAlignment,
        diagramMeasurableRefResult2
            .referencedMeasurableRef(
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
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult2 =
        builderResult2.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult2 =
        applicationRefResult2.diagramMeasurableRef(
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
        immutableProcessDiagramEntityApplicationAlignment,
        diagramMeasurableRefResult2
            .referencedMeasurableRef(
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
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
                    ImmutableEntityReference.builder()
                        .description("The characteristics of someone or something")
                        .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                        .externalId("42")
                        .id(1L)
                        .kind(EntityKind.ALL)
                        .name("Name")
                        .build())
                .build();

    Builder builderResult2 = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult2 =
        builderResult2.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult2 =
        applicationRefResult2.diagramMeasurableRef(
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
        immutableProcessDiagramEntityApplicationAlignment,
        diagramMeasurableRefResult2
            .referencedMeasurableRef(
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
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
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
        diagramMeasurableRefResult
            .referencedMeasurableRef(
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
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableProcessDiagramEntityApplicationAlignment.equals(Object)",
    "int ImmutableProcessDiagramEntityApplicationAlignment.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
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
        diagramMeasurableRefResult
            .referencedMeasurableRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableProcessDiagramEntityApplicationAlignment");
  }

  /**
   * Test {@link ImmutableProcessDiagramEntityApplicationAlignment#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return applicationRef is {@link Json} (default constructor) {@link
   *       Json#applicationRef}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableProcessDiagramEntityApplicationAlignment#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); then return applicationRef is Json (default constructor) applicationRef")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntityApplicationAlignment ImmutableProcessDiagramEntityApplicationAlignment.fromJson(Json)"
  })
  void testFromJson_thenReturnApplicationRefIsJsonApplicationRef() {
    // Arrange
    Json json = new Json();
    json.setDiagramMeasurableRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setApplicationRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    json.setReferencedMeasurableRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Act
    ImmutableProcessDiagramEntityApplicationAlignment actualFromJsonResult =
        ImmutableProcessDiagramEntityApplicationAlignment.fromJson(json);

    // Assert
    EntityReference expectedApplicationRefResult = json.applicationRef;
    assertSame(expectedApplicationRefResult, actualFromJsonResult.applicationRef());
    EntityReference expectedDiagramMeasurableRefResult = json.diagramMeasurableRef;
    assertSame(expectedDiagramMeasurableRefResult, actualFromJsonResult.diagramMeasurableRef());
    EntityReference expectedReferencedMeasurableRefResult = json.referencedMeasurableRef;
    assertSame(
        expectedReferencedMeasurableRefResult, actualFromJsonResult.referencedMeasurableRef());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#toString()}
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#applicationRef()}
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#diagramMeasurableRef()}
   *   <li>{@link ImmutableProcessDiagramEntityApplicationAlignment#referencedMeasurableRef()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityReference ImmutableProcessDiagramEntityApplicationAlignment.applicationRef()",
    "EntityReference ImmutableProcessDiagramEntityApplicationAlignment.diagramMeasurableRef()",
    "EntityReference ImmutableProcessDiagramEntityApplicationAlignment.referencedMeasurableRef()",
    "String ImmutableProcessDiagramEntityApplicationAlignment.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
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
    String actualToStringResult = immutableProcessDiagramEntityApplicationAlignment.toString();
    EntityReference actualApplicationRefResult =
        immutableProcessDiagramEntityApplicationAlignment.applicationRef();
    EntityReference actualDiagramMeasurableRefResult =
        immutableProcessDiagramEntityApplicationAlignment.diagramMeasurableRef();
    EntityReference actualReferencedMeasurableRefResult =
        immutableProcessDiagramEntityApplicationAlignment.referencedMeasurableRef();

    // Assert
    assertTrue(actualApplicationRefResult instanceof ImmutableEntityReference);
    assertTrue(actualDiagramMeasurableRefResult instanceof ImmutableEntityReference);
    assertTrue(actualReferencedMeasurableRefResult instanceof ImmutableEntityReference);
    assertEquals(
        "ProcessDiagramEntityApplicationAlignment{diagramMeasurableRef=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, applicationRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " referencedMeasurableRef=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}}",
        actualToStringResult);
    assertEquals(actualApplicationRefResult, actualDiagramMeasurableRefResult);
    assertEquals(actualApplicationRefResult, actualReferencedMeasurableRefResult);
  }

  /**
   * Test Json {@link Json#applicationRef()}.
   *
   * <p>Method under test: {@link Json#applicationRef()}
   */
  @Test
  @DisplayName("Test Json applicationRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.applicationRef()"})
  void testJsonApplicationRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicationRef());
  }

  /**
   * Test Json {@link Json#diagramMeasurableRef()}.
   *
   * <p>Method under test: {@link Json#diagramMeasurableRef()}
   */
  @Test
  @DisplayName("Test Json diagramMeasurableRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.diagramMeasurableRef()"})
  void testJsonDiagramMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().diagramMeasurableRef());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setApplicationRef(EntityReference)}
   *   <li>{@link Json#setDiagramMeasurableRef(EntityReference)}
   *   <li>{@link Json#setReferencedMeasurableRef(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setApplicationRef(EntityReference)",
    "void Json.setDiagramMeasurableRef(EntityReference)",
    "void Json.setReferencedMeasurableRef(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    ImmutableEntityReference applicationRef =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    actualJson.setApplicationRef(applicationRef);
    actualJson.setDiagramMeasurableRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setReferencedMeasurableRef(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    EntityReference entityReference = actualJson.applicationRef;
    assertTrue(entityReference instanceof ImmutableEntityReference);
    EntityReference entityReference2 = actualJson.diagramMeasurableRef;
    assertTrue(entityReference2 instanceof ImmutableEntityReference);
    EntityReference entityReference3 = actualJson.referencedMeasurableRef;
    assertTrue(entityReference3 instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", entityReference.description());
    assertEquals(1L, entityReference.id());
    assertEquals(EntityKind.ALL, entityReference.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, entityReference.entityLifecycleStatus());
    assertEquals(applicationRef, entityReference2);
    assertEquals(applicationRef, entityReference3);
  }

  /**
   * Test Json {@link Json#referencedMeasurableRef()}.
   *
   * <p>Method under test: {@link Json#referencedMeasurableRef()}
   */
  @Test
  @DisplayName("Test Json referencedMeasurableRef()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.referencedMeasurableRef()"})
  void testJsonReferencedMeasurableRef() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().referencedMeasurableRef());
  }

  /**
   * Test {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withApplicationRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withApplicationRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withApplicationRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntityApplicationAlignment ImmutableProcessDiagramEntityApplicationAlignment.withApplicationRef(EntityReference)"
  })
  void testWithApplicationRef() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
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
    ImmutableProcessDiagramEntityApplicationAlignment actualWithApplicationRefResult =
        immutableProcessDiagramEntityApplicationAlignment.withApplicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableProcessDiagramEntityApplicationAlignment, actualWithApplicationRefResult);
  }

  /**
   * Test {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withDiagramMeasurableRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withDiagramMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withDiagramMeasurableRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntityApplicationAlignment ImmutableProcessDiagramEntityApplicationAlignment.withDiagramMeasurableRef(EntityReference)"
  })
  void testWithDiagramMeasurableRef() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
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
    ImmutableProcessDiagramEntityApplicationAlignment actualWithDiagramMeasurableRefResult =
        immutableProcessDiagramEntityApplicationAlignment.withDiagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(
        immutableProcessDiagramEntityApplicationAlignment, actualWithDiagramMeasurableRefResult);
  }

  /**
   * Test {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withReferencedMeasurableRef(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableProcessDiagramEntityApplicationAlignment#withReferencedMeasurableRef(EntityReference)}
   */
  @Test
  @DisplayName("Test withReferencedMeasurableRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableProcessDiagramEntityApplicationAlignment ImmutableProcessDiagramEntityApplicationAlignment.withReferencedMeasurableRef(EntityReference)"
  })
  void testWithReferencedMeasurableRef() {
    // Arrange
    Builder builderResult = ImmutableProcessDiagramEntityApplicationAlignment.builder();

    Builder applicationRefResult =
        builderResult.applicationRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    Builder diagramMeasurableRefResult =
        applicationRefResult.diagramMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableProcessDiagramEntityApplicationAlignment
        immutableProcessDiagramEntityApplicationAlignment =
            diagramMeasurableRefResult
                .referencedMeasurableRef(
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
    ImmutableProcessDiagramEntityApplicationAlignment actualWithReferencedMeasurableRefResult =
        immutableProcessDiagramEntityApplicationAlignment.withReferencedMeasurableRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(
        immutableProcessDiagramEntityApplicationAlignment, actualWithReferencedMeasurableRefResult);
  }
}
