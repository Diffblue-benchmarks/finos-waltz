package org.finos.waltz.model.flow_classification_rule;

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
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Builder;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableFlowClassificationRuleVantagePointDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#dataTypeId(Long)}
   *   <li>{@link Builder#message(String)}
   *   <li>{@link Builder#messageSeverity(MessageSeverity)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint Builder.build()",
    "Builder Builder.dataTypeId(Long)",
    "Builder Builder.message(String)",
    "Builder Builder.messageSeverity(MessageSeverity)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualRuleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);
    ImmutableEntityReference subjectReference =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    Builder actualSubjectReferenceResult = actualRuleIdResult.subjectReference(subjectReference);
    ImmutableEntityReference vantagePoint =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint =
        actualSubjectReferenceResult.vantagePoint(vantagePoint).vantagePointRank(1).build();

    // Assert
    assertEquals(
        "Classification Code",
        actualImmutableFlowClassificationRuleVantagePoint.classificationCode());
    assertEquals(
        "Not all who wander are lost", actualImmutableFlowClassificationRuleVantagePoint.message());
    assertEquals(1, actualImmutableFlowClassificationRuleVantagePoint.dataTypeRank());
    assertEquals(1, actualImmutableFlowClassificationRuleVantagePoint.vantagePointRank());
    assertEquals(1L, actualImmutableFlowClassificationRuleVantagePoint.dataTypeId().longValue());
    assertEquals(1L, actualImmutableFlowClassificationRuleVantagePoint.ruleId().longValue());
    assertEquals(
        MessageSeverity.NONE, actualImmutableFlowClassificationRuleVantagePoint.messageSeverity());
    assertSame(
        subjectReference, actualImmutableFlowClassificationRuleVantagePoint.subjectReference());
    assertSame(vantagePoint, actualImmutableFlowClassificationRuleVantagePoint.vantagePoint());
  }

  /**
   * Test Builder {@link Builder#classificationCode(String)}.
   *
   * <ul>
   *   <li>When {@code Classification Code}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#classificationCode(String)}
   */
  @Test
  @DisplayName(
      "Test Builder classificationCode(String); when 'Classification Code'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.classificationCode(String)"})
  void testBuilderClassificationCode_whenClassificationCode_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualClassificationCodeResult =
        builderResult.classificationCode("Classification Code");

    // Assert
    assertSame(builderResult, actualClassificationCodeResult);
  }

  /**
   * Test Builder {@link Builder#dataTypeRank(int)}.
   *
   * <p>Method under test: {@link Builder#dataTypeRank(int)}
   */
  @Test
  @DisplayName("Test Builder dataTypeRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.dataTypeRank(int)"})
  void testBuilderDataTypeRank() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualDataTypeRankResult = builderResult.dataTypeRank(1);

    // Assert
    assertSame(builderResult, actualDataTypeRankResult);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint instance =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint);
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint2 =
        builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(null)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint instance =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint);
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint2 =
        builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint2);
  }

  /**
   * Test Builder {@link Builder#from(FlowClassificationRuleVantagePoint)}.
   *
   * <p>Method under test: {@link Builder#from(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName("Test Builder from(FlowClassificationRuleVantagePoint)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(FlowClassificationRuleVantagePoint)"})
  void testBuilderFrom3() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message(null)
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint instance =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint);
    ImmutableFlowClassificationRuleVantagePoint actualImmutableFlowClassificationRuleVantagePoint2 =
        builderResult.build();
    assertEquals(instance, actualImmutableFlowClassificationRuleVantagePoint2);
  }

  /**
   * Test Builder {@link Builder#ruleId(Long)}.
   *
   * <p>Method under test: {@link Builder#ruleId(Long)}
   */
  @Test
  @DisplayName("Test Builder ruleId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ruleId(Long)"})
  void testBuilderRuleId() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualRuleIdResult = builderResult.ruleId(1L);

    // Assert
    assertSame(builderResult, actualRuleIdResult);
  }

  /**
   * Test Builder {@link Builder#subjectReference(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#subjectReference(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder subjectReference(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectReference(EntityReference)"})
  void testBuilderSubjectReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualSubjectReferenceResult =
        builderResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualSubjectReferenceResult);
  }

  /**
   * Test Builder {@link Builder#vantagePointRank(int)}.
   *
   * <p>Method under test: {@link Builder#vantagePointRank(int)}
   */
  @Test
  @DisplayName("Test Builder vantagePointRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vantagePointRank(int)"})
  void testBuilderVantagePointRank() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualVantagePointRankResult = builderResult.vantagePointRank(1);

    // Assert
    assertSame(builderResult, actualVantagePointRankResult);
  }

  /**
   * Test Builder {@link Builder#vantagePoint(EntityReference)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#vantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder vantagePoint(EntityReference); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.vantagePoint(EntityReference)"})
  void testBuilderVantagePoint_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableFlowClassificationRuleVantagePoint.builder();

    // Act
    Builder actualVantagePointResult =
        builderResult.vantagePoint(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertSame(builderResult, actualVantagePointResult);
  }

  /**
   * Test {@link
   * ImmutableFlowClassificationRuleVantagePoint#copyOf(FlowClassificationRuleVantagePoint)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#copyOf(FlowClassificationRuleVantagePoint)}
   */
  @Test
  @DisplayName(
      "Test copyOf(FlowClassificationRuleVantagePoint); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.copyOf(FlowClassificationRuleVantagePoint)"
  })
  void testCopyOf_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint instance =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualCopyOfResult =
        ImmutableFlowClassificationRuleVantagePoint.copyOf(instance);

    // Assert
    EntityReference subjectReferenceResult2 = actualCopyOfResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualCopyOfResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals("Classification Code", actualCopyOfResult.classificationCode());
    assertEquals("Not all who wander are lost", actualCopyOfResult.message());
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1, actualCopyOfResult.dataTypeRank());
    assertEquals(1, actualCopyOfResult.vantagePointRank());
    assertEquals(1L, actualCopyOfResult.dataTypeId().longValue());
    assertEquals(1L, actualCopyOfResult.ruleId().longValue());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(MessageSeverity.NONE, actualCopyOfResult.messageSeverity());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleVantagePoint#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint2 =
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableFlowClassificationRuleVantagePoint, immutableFlowClassificationRuleVantagePoint2);
    assertEquals(
        immutableFlowClassificationRuleVantagePoint.hashCode(),
        immutableFlowClassificationRuleVantagePoint2.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}, and {@link
   * ImmutableFlowClassificationRuleVantagePoint#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act and Assert
    assertEquals(
        immutableFlowClassificationRuleVantagePoint, immutableFlowClassificationRuleVantagePoint);
    int expectedHashCodeResult = immutableFlowClassificationRuleVantagePoint.hashCode();
    assertEquals(expectedHashCodeResult, immutableFlowClassificationRuleVantagePoint.hashCode());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("classificationCode")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(2L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(0)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Classification Code")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.INFORMATION)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(2L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(0)
            .build();

    Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
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
        immutableFlowClassificationRuleVantagePoint,
        subjectReferenceResult2
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
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
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableFlowClassificationRuleVantagePoint.equals(Object)",
    "int ImmutableFlowClassificationRuleVantagePoint.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
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
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build(),
        "Different type to ImmutableFlowClassificationRuleVantagePoint");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#toString()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#classificationCode()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#dataTypeId()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#dataTypeRank()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#message()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#messageSeverity()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#ruleId()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#subjectReference()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#vantagePoint()}
   *   <li>{@link ImmutableFlowClassificationRuleVantagePoint#vantagePointRank()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableFlowClassificationRuleVantagePoint.classificationCode()",
    "Long ImmutableFlowClassificationRuleVantagePoint.dataTypeId()",
    "int ImmutableFlowClassificationRuleVantagePoint.dataTypeRank()",
    "String ImmutableFlowClassificationRuleVantagePoint.message()",
    "MessageSeverity ImmutableFlowClassificationRuleVantagePoint.messageSeverity()",
    "Long ImmutableFlowClassificationRuleVantagePoint.ruleId()",
    "EntityReference ImmutableFlowClassificationRuleVantagePoint.subjectReference()",
    "String ImmutableFlowClassificationRuleVantagePoint.toString()",
    "EntityReference ImmutableFlowClassificationRuleVantagePoint.vantagePoint()",
    "int ImmutableFlowClassificationRuleVantagePoint.vantagePointRank()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    String actualToStringResult = immutableFlowClassificationRuleVantagePoint.toString();
    String actualClassificationCodeResult =
        immutableFlowClassificationRuleVantagePoint.classificationCode();
    Long actualDataTypeIdResult = immutableFlowClassificationRuleVantagePoint.dataTypeId();
    int actualDataTypeRankResult = immutableFlowClassificationRuleVantagePoint.dataTypeRank();
    String actualMessageResult = immutableFlowClassificationRuleVantagePoint.message();
    MessageSeverity actualMessageSeverityResult =
        immutableFlowClassificationRuleVantagePoint.messageSeverity();
    Long actualRuleIdResult = immutableFlowClassificationRuleVantagePoint.ruleId();
    EntityReference actualSubjectReferenceResult =
        immutableFlowClassificationRuleVantagePoint.subjectReference();
    EntityReference actualVantagePointResult =
        immutableFlowClassificationRuleVantagePoint.vantagePoint();

    // Assert
    assertTrue(actualSubjectReferenceResult instanceof ImmutableEntityReference);
    assertTrue(actualVantagePointResult instanceof ImmutableEntityReference);
    assertEquals("Classification Code", actualClassificationCodeResult);
    assertEquals(
        "FlowClassificationRuleVantagePoint{vantagePoint=EntityReference{kind=ALL, id=1, entityLifecycleStatus"
            + "=ACTIVE}, vantagePointRank=1, dataTypeId=1, dataTypeRank=1, subjectReference=EntityReference{kind=ALL,"
            + " id=1, entityLifecycleStatus=ACTIVE}, ruleId=1, classificationCode=Classification Code, message=Not"
            + " all who wander are lost, messageSeverity=NONE}",
        actualToStringResult);
    assertEquals("Not all who wander are lost", actualMessageResult);
    assertEquals(1, actualDataTypeRankResult);
    assertEquals(1, immutableFlowClassificationRuleVantagePoint.vantagePointRank());
    assertEquals(1L, actualDataTypeIdResult.longValue());
    assertEquals(1L, actualRuleIdResult.longValue());
    assertEquals(MessageSeverity.NONE, actualMessageSeverityResult);
    assertEquals(actualSubjectReferenceResult, actualVantagePointResult);
  }

  /**
   * Test Json {@link Json#classificationCode()}.
   *
   * <p>Method under test: {@link Json#classificationCode()}
   */
  @Test
  @DisplayName("Test Json classificationCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.classificationCode()"})
  void testJsonClassificationCode() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().classificationCode());
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
   * Test Json {@link Json#dataTypeRank()}.
   *
   * <p>Method under test: {@link Json#dataTypeRank()}
   */
  @Test
  @DisplayName("Test Json dataTypeRank()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.dataTypeRank()"})
  void testJsonDataTypeRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().dataTypeRank());
  }

  /**
   * Test Json getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Json}
   *   <li>{@link Json#setClassificationCode(String)}
   *   <li>{@link Json#setDataTypeId(Long)}
   *   <li>{@link Json#setMessage(String)}
   *   <li>{@link Json#setMessageSeverity(MessageSeverity)}
   *   <li>{@link Json#setRuleId(Long)}
   *   <li>{@link Json#setSubjectReference(EntityReference)}
   *   <li>{@link Json#setVantagePoint(EntityReference)}
   * </ul>
   */
  @Test
  @DisplayName("Test Json getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Json.<init>()",
    "void Json.setClassificationCode(String)",
    "void Json.setDataTypeId(Long)",
    "void Json.setMessage(String)",
    "void Json.setMessageSeverity(MessageSeverity)",
    "void Json.setRuleId(Long)",
    "void Json.setSubjectReference(EntityReference)",
    "void Json.setVantagePoint(EntityReference)"
  })
  void testJsonGettersAndSetters() {
    // Arrange and Act
    Json actualJson = new Json();
    actualJson.setClassificationCode("Classification Code");
    actualJson.setDataTypeId(1L);
    actualJson.setMessage("Not all who wander are lost");
    actualJson.setMessageSeverity(MessageSeverity.NONE);
    actualJson.setRuleId(1L);
    actualJson.setSubjectReference(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    actualJson.setVantagePoint(
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
    assertEquals(1L, actualJson.ruleId.longValue());
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
   * Test Json {@link Json#messageSeverity()}.
   *
   * <p>Method under test: {@link Json#messageSeverity()}
   */
  @Test
  @DisplayName("Test Json messageSeverity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MessageSeverity Json.messageSeverity()"})
  void testJsonMessageSeverity() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().messageSeverity());
  }

  /**
   * Test Json {@link Json#ruleId()}.
   *
   * <p>Method under test: {@link Json#ruleId()}
   */
  @Test
  @DisplayName("Test Json ruleId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long Json.ruleId()"})
  void testJsonRuleId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ruleId());
  }

  /**
   * Test Json {@link Json#setDataTypeRank(int)}.
   *
   * <p>Method under test: {@link Json#setDataTypeRank(int)}
   */
  @Test
  @DisplayName("Test Json setDataTypeRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setDataTypeRank(int)"})
  void testJsonSetDataTypeRank() {
    // Arrange
    Json json = new Json();

    // Act
    json.setDataTypeRank(1);

    // Assert
    assertEquals(1, json.dataTypeRank);
    assertTrue(json.dataTypeRankIsSet);
  }

  /**
   * Test Json {@link Json#setVantagePointRank(int)}.
   *
   * <p>Method under test: {@link Json#setVantagePointRank(int)}
   */
  @Test
  @DisplayName("Test Json setVantagePointRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setVantagePointRank(int)"})
  void testJsonSetVantagePointRank() {
    // Arrange
    Json json = new Json();

    // Act
    json.setVantagePointRank(1);

    // Assert
    assertEquals(1, json.vantagePointRank);
    assertTrue(json.vantagePointRankIsSet);
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
   * Test Json {@link Json#vantagePoint()}.
   *
   * <p>Method under test: {@link Json#vantagePoint()}
   */
  @Test
  @DisplayName("Test Json vantagePoint()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.vantagePoint()"})
  void testJsonVantagePoint() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().vantagePoint());
  }

  /**
   * Test Json {@link Json#vantagePointRank()}.
   *
   * <p>Method under test: {@link Json#vantagePointRank()}
   */
  @Test
  @DisplayName("Test Json vantagePointRank()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.vantagePointRank()"})
  void testJsonVantagePointRank() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().vantagePointRank());
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withClassificationCode(String)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withClassificationCode(String)}
   */
  @Test
  @DisplayName("Test withClassificationCode(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withClassificationCode(String)"
  })
  void testWithClassificationCode() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("42")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithClassificationCodeResult =
        immutableFlowClassificationRuleVantagePoint.withClassificationCode("42");

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithClassificationCodeResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withClassificationCode(String)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withClassificationCode(String)}
   */
  @Test
  @DisplayName(
      "Test withClassificationCode(String); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withClassificationCode(String)"
  })
  void testWithClassificationCode_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithClassificationCodeResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withClassificationCode("42");

    // Assert
    EntityReference subjectReferenceResult2 = actualWithClassificationCodeResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithClassificationCodeResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withDataTypeId(Long)"
  })
  void testWithDataTypeId() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithDataTypeIdResult =
        immutableFlowClassificationRuleVantagePoint.withDataTypeId(1L);

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithDataTypeIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeId(Long)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeId(Long)}
   */
  @Test
  @DisplayName("Test withDataTypeId(Long); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withDataTypeId(Long)"
  })
  void testWithDataTypeId_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithDataTypeIdResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withDataTypeId(42L);

    // Assert
    EntityReference subjectReferenceResult2 = actualWithDataTypeIdResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithDataTypeIdResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(42L, actualWithDataTypeIdResult.dataTypeId().longValue());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeRank(int)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeRank(int)}
   */
  @Test
  @DisplayName("Test withDataTypeRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withDataTypeRank(int)"
  })
  void testWithDataTypeRank() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(42)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithDataTypeRankResult =
        immutableFlowClassificationRuleVantagePoint.withDataTypeRank(42);

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithDataTypeRankResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeRank(int)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withDataTypeRank(int)}
   */
  @Test
  @DisplayName("Test withDataTypeRank(int); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withDataTypeRank(int)"
  })
  void testWithDataTypeRank_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithDataTypeRankResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withDataTypeRank(42);

    // Assert
    EntityReference subjectReferenceResult2 = actualWithDataTypeRankResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithDataTypeRankResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withMessage(String)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withMessage(String)"
  })
  void testWithMessage() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("42")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithMessageResult =
        immutableFlowClassificationRuleVantagePoint.withMessage("42");

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithMessageResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withMessageSeverity(MessageSeverity)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName("Test withMessageSeverity(MessageSeverity)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withMessageSeverity(MessageSeverity)"
  })
  void testWithMessageSeverity() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithMessageSeverityResult =
        immutableFlowClassificationRuleVantagePoint.withMessageSeverity(MessageSeverity.NONE);

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithMessageSeverityResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withMessageSeverity(MessageSeverity)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withMessageSeverity(MessageSeverity)}
   */
  @Test
  @DisplayName(
      "Test withMessageSeverity(MessageSeverity); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withMessageSeverity(MessageSeverity)"
  })
  void testWithMessageSeverity_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.INFORMATION)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithMessageSeverityResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withMessageSeverity(MessageSeverity.NONE);

    // Assert
    EntityReference subjectReferenceResult2 = actualWithMessageSeverityResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithMessageSeverityResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withMessage(String)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withMessage(String)}
   */
  @Test
  @DisplayName("Test withMessage(String); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withMessage(String)"
  })
  void testWithMessage_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithMessageResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withMessage("42");

    // Assert
    EntityReference subjectReferenceResult2 = actualWithMessageResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithMessageResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withRuleId(Long)}.
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withRuleId(Long)}
   */
  @Test
  @DisplayName("Test withRuleId(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withRuleId(Long)"
  })
  void testWithRuleId() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithRuleIdResult =
        immutableFlowClassificationRuleVantagePoint.withRuleId(1L);

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithRuleIdResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withRuleId(Long)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableFlowClassificationRuleVantagePoint#withRuleId(Long)}
   */
  @Test
  @DisplayName(
      "Test withRuleId(Long); when forty-two; then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withRuleId(Long)"
  })
  void testWithRuleId_whenFortyTwo_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithRuleIdResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withRuleId(42L);

    // Assert
    EntityReference subjectReferenceResult2 = actualWithRuleIdResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithRuleIdResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(42L, actualWithRuleIdResult.ruleId().longValue());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withSubjectReference(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withSubjectReference(EntityReference)}
   */
  @Test
  @DisplayName("Test withSubjectReference(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withSubjectReference(EntityReference)"
  })
  void testWithSubjectReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithSubjectReferenceResult =
        immutableFlowClassificationRuleVantagePoint.withSubjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowClassificationRuleVantagePoint, actualWithSubjectReferenceResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withVantagePoint(EntityReference)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withVantagePoint(EntityReference)}
   */
  @Test
  @DisplayName("Test withVantagePoint(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withVantagePoint(EntityReference)"
  })
  void testWithVantagePoint() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithVantagePointResult =
        immutableFlowClassificationRuleVantagePoint.withVantagePoint(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableFlowClassificationRuleVantagePoint, actualWithVantagePointResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withVantagePointRank(int)}.
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withVantagePointRank(int)}
   */
  @Test
  @DisplayName("Test withVantagePointRank(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withVantagePointRank(int)"
  })
  void testWithVantagePointRank() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ImmutableFlowClassificationRuleVantagePoint immutableFlowClassificationRuleVantagePoint =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(42)
            .build();

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithVantagePointRankResult =
        immutableFlowClassificationRuleVantagePoint.withVantagePointRank(42);

    // Assert
    assertSame(immutableFlowClassificationRuleVantagePoint, actualWithVantagePointRankResult);
  }

  /**
   * Test {@link ImmutableFlowClassificationRuleVantagePoint#withVantagePointRank(int)}.
   *
   * <ul>
   *   <li>Then subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableFlowClassificationRuleVantagePoint#withVantagePointRank(int)}
   */
  @Test
  @DisplayName(
      "Test withVantagePointRank(int); then subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableFlowClassificationRuleVantagePoint ImmutableFlowClassificationRuleVantagePoint.withVantagePointRank(int)"
  })
  void testWithVantagePointRank_thenSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Act
    ImmutableFlowClassificationRuleVantagePoint actualWithVantagePointRankResult =
        subjectReferenceResult
            .vantagePoint(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .vantagePointRank(1)
            .build()
            .withVantagePointRank(42);

    // Assert
    EntityReference subjectReferenceResult2 = actualWithVantagePointRankResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = actualWithVantagePointRankResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertEquals(
        "The characteristics of someone or something", subjectReferenceResult2.description());
    assertEquals(1L, subjectReferenceResult2.id());
    assertEquals(EntityKind.ALL, subjectReferenceResult2.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, subjectReferenceResult2.entityLifecycleStatus());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }
}
