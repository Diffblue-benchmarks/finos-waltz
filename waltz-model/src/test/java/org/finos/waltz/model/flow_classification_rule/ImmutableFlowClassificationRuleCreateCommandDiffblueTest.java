package org.finos.waltz.model.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleCreateCommand.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleCreateCommand.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleCreateCommandDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#dataTypeId(Long)}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#message(String)}
   *   <li>{@link Builder#severity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand Builder.build()",
    "Builder Builder.dataTypeId(Long)",
    "Builder Builder.description(String)",
    "Builder Builder.message(String)",
    "Builder Builder.severity(MessageSeverity)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualMessageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");
    ImmutableEntityReference parentReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSeverityResult =
        actualMessageResult.parentReference(parentReference).severity(MessageSeverity.NONE);
    ImmutableEntityReference subjectReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand =
            actualSeverityResult.subjectReference(subjectReference).build();

    // Assert
    assertEquals(
        "Not all who wander are lost",
        actualImmutableFlowClassificationRuleCreateCommand.message());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableFlowClassificationRuleCreateCommand.description());
    assertEquals(1L, actualImmutableFlowClassificationRuleCreateCommand.dataTypeId().longValue());
    assertEquals(1L, actualImmutableFlowClassificationRuleCreateCommand.classificationId());
    assertEquals(
        MessageSeverity.NONE, actualImmutableFlowClassificationRuleCreateCommand.severity());
    assertSame(
        parentReference, actualImmutableFlowClassificationRuleCreateCommand.parentReference());
    assertSame(
        subjectReference, actualImmutableFlowClassificationRuleCreateCommand.subjectReference());
  }

  /**
   * Test Builder {@link Builder#classificationId(long)}.
   *
   * <p>Method under test: {@link Builder#classificationId(long)}
   */
  @Test
  @DisplayName("Test Builder classificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classificationId(long)"})
  void testBuilderClassificationId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act
    Builder actualClassificationIdResult = builderResult.classificationId(1L);

    // Assert
    assertSame(builderResult, actualClassificationIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand =
            builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(null)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand =
            builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message(null);

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand =
            builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(null);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand =
            builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code
   * FlowClassificationRuleCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code
   * FlowClassificationRuleCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(null)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code
   * FlowClassificationRuleCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description(null)
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code
   * FlowClassificationRuleCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand4() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message(null);

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleCreateCommand)} with {@code
   * FlowClassificationRuleCreateCommand}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test Builder from(FlowClassificationRuleCreateCommand) with 'FlowClassificationRuleCreateCommand'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleCreateCommand)"})
  void testBuilderFromWithFlowClassificationRuleCreateCommand5() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(null);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand = builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand);
    ImmutableFlowClassificationRuleCreateCommand
        actualImmutableFlowClassificationRuleCreateCommand2 = builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleCreateCommand2);
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
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act
    Builder actualParentReferenceResult =
        builderResult.parentReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualParentReferenceResult);
  }

  /**
   * Test Builder {@link Builder#subjectReference(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subjectReference(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder subjectReference(EntityReference); when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectReference(EntityReference)"})
  void testBuilderSubjectReference_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleCreateCommand.builder();

    // Act
    Builder actualSubjectReferenceResult =
        builderResult.subjectReference(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualSubjectReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleCreateCommand#copyOf(FlowClassificationRuleCreateCommand)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#copyOf(FlowClassificationRuleCreateCommand)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowClassificationRuleCreateCommand); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.copyOf(FlowClassificationRuleCreateCommand)"
  })
  void testCopyOf_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand instance =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualCopyOfResult =
        ImmutableFlowClassificationRuleCreateCommand.copyOf(instance);

    // Assert
    EntityReference parentReferenceResult = actualCopyOfResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult = actualCopyOfResult.subjectReference();
    assertTrue(subjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(1L, actualCopyOfResult.classificationId());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.severity());
    assertEquals(parentReferenceResult, subjectReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand2 =
        severityResult2
            .subjectReference(
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
        immutableFlowClassificationRuleCreateCommand,
        immutableFlowClassificationRuleCreateCommand2);
    assertEquals(
        immutableFlowClassificationRuleCreateCommand.hashCode(),
        immutableFlowClassificationRuleCreateCommand2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleCreateCommand#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
        immutableFlowClassificationRuleCreateCommand, immutableFlowClassificationRuleCreateCommand);
    int expectedHashCodeResult = immutableFlowClassificationRuleCreateCommand.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassificationRuleCreateCommand.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(2L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(2L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Message");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.INFORMATION);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder messageResult2 =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult2 =
        messageResult2
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        immutableFlowClassificationRuleCreateCommand,
        severityResult2
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        severityResult
            .subjectReference(
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
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleCreateCommand.equals(Object)",
    "int ImmutableFlowClassificationRuleCreateCommand.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act and Assert
    assertNotEquals(
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableFlowClassificationRuleCreateCommand");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#toString()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#classificationId()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#dataTypeId()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#description()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#message()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#parentReference()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#severity()}
   *   <li>{@link ImmutableFlowClassificationRuleCreateCommand#subjectReference()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long ImmutableFlowClassificationRuleCreateCommand.classificationId()",
    "Long ImmutableFlowClassificationRuleCreateCommand.dataTypeId()",
    "String ImmutableFlowClassificationRuleCreateCommand.description()",
    "String ImmutableFlowClassificationRuleCreateCommand.message()",
    "EntityReference ImmutableFlowClassificationRuleCreateCommand.parentReference()",
    "MessageSeverity ImmutableFlowClassificationRuleCreateCommand.severity()",
    "EntityReference ImmutableFlowClassificationRuleCreateCommand.subjectReference()",
    "String ImmutableFlowClassificationRuleCreateCommand.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    String actualToStringResult = immutableFlowClassificationRuleCreateCommand.toString();
    long actualClassificationIdResult =
        immutableFlowClassificationRuleCreateCommand.classificationId();
    Long actualDataTypeIdResult = immutableFlowClassificationRuleCreateCommand.dataTypeId();
    String actualDescriptionResult = immutableFlowClassificationRuleCreateCommand.description();
    String actualMessageResult = immutableFlowClassificationRuleCreateCommand.message();
    EntityReference actualParentReferenceResult =
        immutableFlowClassificationRuleCreateCommand.parentReference();
    MessageSeverity actualSeverityResult = immutableFlowClassificationRuleCreateCommand.severity();
    EntityReference actualSubjectReferenceResult =
        immutableFlowClassificationRuleCreateCommand.subjectReference();

    // Assert
    assertTrue(actualParentReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualSubjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals(
        "FlowClassificationRuleCreateCommand{classificationId=1, dataTypeId=1, subjectReference=EntityReference"
            + "{kind=ALL, id=1, entityLifecycleStatus=ACTIVE}, parentReference=EntityReference{kind=ALL, id=1,"
            + " entityLifecycleStatus=ACTIVE}, severity=NONE, message=Not all who wander are lost}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessageResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, actualDataTypeIdResult.longValue());
    assertEquals(1L, actualClassificationIdResult);
    assertEquals(MessageSeverity.NONE, actualSeverityResult);
    assertEquals(actualParentReferenceResult, actualSubjectReferenceResult);
  }

  /**
   * Test Json {@link Json#classificationId()}.
   *
   * <p>Method under test: {@link Json#classificationId()}
   */
  @Test
  @DisplayName("Test Json classificationId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.classificationId()"})
  void testJsonClassificationId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classificationId());
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
  @MethodsUnderTest({"Long Json.dataTypeId()"})
  void testJsonDataTypeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeId());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setDescription(String)}
   *   <li>{@link Json#setMessage(String)}
   *   <li>{@link Json#setParentReference(EntityReference)}
   *   <li>{@link Json#setSeverity(MessageSeverity)}
   *   <li>{@link Json#setSubjectReference(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setDataTypeId(Long)",
    "void Json.setDescription(String)",
    "void Json.setMessage(String)",
    "void Json.setParentReference(EntityReference)",
    "void Json.setSeverity(MessageSeverity)",
    "void Json.setSubjectReference(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setDataTypeId(1L);
    actualJson.setDescription("The characteristics of someone or something");
    actualJson.setMessage("Not all who wander are lost");
    actualJson.setParentReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setSeverity(MessageSeverity.NONE);
    actualJson.setSubjectReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());

    // Assert
    assertEquals(1L, actualJson.dataTypeId.longValue());
  }

  /**
   * Test Json {@link Json#message()}.
   *
   * <p>Method under test: {@link Json#message()}
   */
  @Test
  @DisplayName("Test Json message()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.message()"})
  void testJsonMessage() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().message());
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
   * Test Json {@link Json#setClassificationId(long)}.
   *
   * <p>Method under test: {@link Json#setClassificationId(long)}
   */
  @Test
  @DisplayName("Test Json setClassificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setClassificationId(long)"})
  void testJsonSetClassificationId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setClassificationId(1L);

    // Assert
    assertEquals(1L, json.classificationId);
    assertTrue(json.classificationIdIsSet);
  }

  /**
   * Test Json {@link Json#severity()}.
   *
   * <p>Method under test: {@link Json#severity()}
   */
  @Test
  @DisplayName("Test Json severity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.severity()"})
  void testJsonSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().severity());
  }

  /**
   * Test Json {@link Json#subjectReference()}.
   *
   * <p>Method under test: {@link Json#subjectReference()}
   */
  @Test
  @DisplayName("Test Json subjectReference()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.subjectReference()"})
  void testJsonSubjectReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectReference());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withClassificationId(long)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withClassificationId(long)}
   */
  @Test
  @DisplayName("Test withClassificationId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withClassificationId(long)"
  })
  void testWithClassificationId() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(42L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithClassificationIdResult =
        immutableFlowClassificationRuleCreateCommand.withClassificationId(42L);

    // Assert
    assertSame(immutableFlowClassificationRuleCreateCommand, actualWithClassificationIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withClassificationId(long)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withClassificationId(long)}
   */
  @Test
  @DisplayName(
      "Test withClassificationId(long); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withClassificationId(long)"
  })
  void testWithClassificationId_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleCreateCommand actualWithClassificationIdResult =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withClassificationId(42L);

    // Assert
    EntityReference parentReferenceResult = actualWithClassificationIdResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult = actualWithClassificationIdResult.subjectReference();
    assertTrue(subjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Not all who wander are lost", actualWithClassificationIdResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something",
        actualWithClassificationIdResult.description());
    assertEquals(1L, actualWithClassificationIdResult.dataTypeId().longValue());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(42L, actualWithClassificationIdResult.classificationId());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualWithClassificationIdResult.severity());
    assertEquals(parentReferenceResult, subjectReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withDataTypeId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withDataTypeId(Long)"
  })
  void testWithDataTypeId() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithDataTypeIdResult =
        immutableFlowClassificationRuleCreateCommand.withDataTypeId(1L);

    // Assert
    assertSame(immutableFlowClassificationRuleCreateCommand, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withDataTypeId(Long)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withDataTypeId(Long)"
  })
  void testWithDataTypeId_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleCreateCommand actualWithDataTypeIdResult =
        severityResult
            .subjectReference(
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
    EntityReference parentReferenceResult = actualWithDataTypeIdResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult = actualWithDataTypeIdResult.subjectReference();
    assertTrue(subjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Not all who wander are lost", actualWithDataTypeIdResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithDataTypeIdResult.description());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(1L, actualWithDataTypeIdResult.classificationId());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualWithDataTypeIdResult.severity());
    assertEquals(parentReferenceResult, subjectReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithDescriptionResult =
        immutableFlowClassificationRuleCreateCommand.withDescription("42");

    // Assert
    assertEquals(immutableFlowClassificationRuleCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withDescription(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("42")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithDescriptionResult =
        immutableFlowClassificationRuleCreateCommand.withDescription("42");

    // Assert
    assertSame(immutableFlowClassificationRuleCreateCommand, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withMessage(String)"
  })
  void testWithMessage() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("42");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithMessageResult =
        immutableFlowClassificationRuleCreateCommand.withMessage("42");

    // Assert
    assertSame(immutableFlowClassificationRuleCreateCommand, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withMessage(String)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleCreateCommand#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withMessage(String)"
  })
  void testWithMessage_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);

    // Act
    ImmutableFlowClassificationRuleCreateCommand actualWithMessageResult =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withMessage("42");

    // Assert
    EntityReference parentReferenceResult = actualWithMessageResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult = actualWithMessageResult.subjectReference();
    assertTrue(subjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals("42", actualWithMessageResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithMessageResult.description());
    assertEquals(1L, actualWithMessageResult.dataTypeId().longValue());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(1L, actualWithMessageResult.classificationId());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualWithMessageResult.severity());
    assertEquals(parentReferenceResult, subjectReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withParentReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withParentReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withParentReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withParentReference(EntityReference)"
  })
  void testWithParentReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithParentReferenceResult =
        immutableFlowClassificationRuleCreateCommand.withParentReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowClassificationRuleCreateCommand, actualWithParentReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withSeverity(MessageSeverity)"
  })
  void testWithSeverity() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithSeverityResult =
        immutableFlowClassificationRuleCreateCommand.withSeverity(MessageSeverity.NONE);

    // Assert
    assertSame(immutableFlowClassificationRuleCreateCommand, actualWithSeverityResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleCreateCommand#withSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then parentReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName(
      "Test withSeverity(MessageSeverity); then parentReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withSeverity(MessageSeverity)"
  })
  void testWithSeverity_thenParentReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.INFORMATION);

    // Act
    ImmutableFlowClassificationRuleCreateCommand actualWithSeverityResult =
        severityResult
            .subjectReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .withSeverity(MessageSeverity.NONE);

    // Assert
    EntityReference parentReferenceResult = actualWithSeverityResult.parentReference();
    assertTrue(parentReferenceResult instanceof ImmutableEntityReference);
    EntityReference subjectReferenceResult = actualWithSeverityResult.subjectReference();
    assertTrue(subjectReferenceResult instanceof ImmutableEntityReference);
    assertEquals("Not all who wander are lost", actualWithSeverityResult.message());
    assertEquals(
        "The characteristics of someone or something", parentReferenceResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithSeverityResult.description());
    assertEquals(1L, actualWithSeverityResult.dataTypeId().longValue());
    assertEquals(1L, parentReferenceResult.id());
    assertEquals(1L, actualWithSeverityResult.classificationId());
    assertEquals(EntityKind.ALL, parentReferenceResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, parentReferenceResult.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualWithSeverityResult.severity());
    assertEquals(parentReferenceResult, subjectReferenceResult);
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleCreateCommand#withSubjectReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleCreateCommand#withSubjectReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withSubjectReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleCreateCommand ImmutableFlowClassificationRuleCreateCommand.withSubjectReference(EntityReference)"
  })
  void testWithSubjectReference() {
    // Arrange
    Builder messageResult =
        ImmutableFlowClassificationRuleCreateCommand.builder()
            .classificationId(1L)
            .dataTypeId(1L)
            .description("The characteristics of someone or something")
            .message("Not all who wander are lost");

    Builder severityResult =
        messageResult
            .parentReference(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .severity(MessageSeverity.NONE);
    ImmutableFlowClassificationRuleCreateCommand immutableFlowClassificationRuleCreateCommand =
        severityResult
            .subjectReference(
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
    ImmutableFlowClassificationRuleCreateCommand actualWithSubjectReferenceResult =
        immutableFlowClassificationRuleCreateCommand.withSubjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowClassificationRuleCreateCommand, actualWithSubjectReferenceResult);
  }
}
