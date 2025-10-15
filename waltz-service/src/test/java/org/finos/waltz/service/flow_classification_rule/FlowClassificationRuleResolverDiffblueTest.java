package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint.Builder;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleResolverDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection,
   * List)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection, List)}
   */
  @Test
  @DisplayName("Test new FlowClassificationRuleResolver(FlowDirection, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowClassificationRuleResolver.<init>(FlowDirection, List)"})
  void testNewFlowClassificationRuleResolver() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());

    // Act and Assert
    List<?> toListResult =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints)
            .resolve(null, null, null, 1L)
            .toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection,
   * List)}.
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection, List)}
   */
  @Test
  @DisplayName("Test new FlowClassificationRuleResolver(FlowDirection, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowClassificationRuleResolver.<init>(FlowDirection, List)"})
  void testNewFlowClassificationRuleResolver2() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());

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
    flowClassificationVantagePoints.add(
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

    // Act and Assert
    List<?> toListResult =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints)
            .resolve(null, null, null, 1L)
            .toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection,
   * List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * FlowClassificationRuleResolver#FlowClassificationRuleResolver(FlowDirection, List)}
   */
  @Test
  @DisplayName("Test new FlowClassificationRuleResolver(FlowDirection, List); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void FlowClassificationRuleResolver.<init>(FlowDirection, List)"})
  void testNewFlowClassificationRuleResolver_whenArrayList() {
    // Arrange, Act and Assert
    List<?> toListResult =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, new ArrayList<>())
            .resolve(null, null, null, 1L)
            .toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}
   */
  @Test
  @DisplayName(
      "Test getMostSpecificRanked(Collection); then get() subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional FlowClassificationRuleResolver.getMostSpecificRanked(Collection)"})
  void testGetMostSpecificRanked_thenGetSubjectReferenceReturnImmutableEntityReference() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> vantagePoints = new ArrayList<>();

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
    vantagePoints.add(
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
            .build());

    // Act
    Optional<FlowClassificationRuleVantagePoint> actualMostSpecificRanked =
        FlowClassificationRuleResolver.getMostSpecificRanked(vantagePoints);

    // Assert
    FlowClassificationRuleVantagePoint getResult = actualMostSpecificRanked.get();
    EntityReference subjectReferenceResult2 = getResult.subjectReference();
    assertTrue(subjectReferenceResult2 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = getResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableFlowClassificationRuleVantagePoint);
    assertEquals("Classification Code", getResult.classificationCode());
    assertEquals("Not all who wander are lost", getResult.message());
    assertEquals(1, getResult.dataTypeRank());
    assertEquals(1, getResult.vantagePointRank());
    assertEquals(1L, getResult.dataTypeId().longValue());
    assertEquals(1L, getResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, getResult.messageSeverity());
    assertTrue(actualMostSpecificRanked.isPresent());
    assertEquals(subjectReferenceResult2, vantagePointResult);
  }

  /**
   * Test {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} subjectReference return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}
   */
  @Test
  @DisplayName(
      "Test getMostSpecificRanked(Collection); then get() subjectReference return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional FlowClassificationRuleResolver.getMostSpecificRanked(Collection)"})
  void testGetMostSpecificRanked_thenGetSubjectReferenceReturnImmutableEntityReference2() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> vantagePoints = new ArrayList<>();

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
    vantagePoints.add(
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
            .build());

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
    vantagePoints.add(
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

    // Act
    Optional<FlowClassificationRuleVantagePoint> actualMostSpecificRanked =
        FlowClassificationRuleResolver.getMostSpecificRanked(vantagePoints);

    // Assert
    FlowClassificationRuleVantagePoint getResult = actualMostSpecificRanked.get();
    EntityReference subjectReferenceResult3 = getResult.subjectReference();
    assertTrue(subjectReferenceResult3 instanceof ImmutableEntityReference);
    EntityReference vantagePointResult = getResult.vantagePoint();
    assertTrue(vantagePointResult instanceof ImmutableEntityReference);
    assertTrue(getResult instanceof ImmutableFlowClassificationRuleVantagePoint);
    assertEquals("Classification Code", getResult.classificationCode());
    assertEquals("Not all who wander are lost", getResult.message());
    assertEquals(1, getResult.dataTypeRank());
    assertEquals(1, getResult.vantagePointRank());
    assertEquals(1L, getResult.dataTypeId().longValue());
    assertEquals(1L, getResult.ruleId().longValue());
    assertEquals(MessageSeverity.NONE, getResult.messageSeverity());
    assertTrue(actualMostSpecificRanked.isPresent());
    assertEquals(subjectReferenceResult3, vantagePointResult);
  }

  /**
   * Test {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#getMostSpecificRanked(Collection)}
   */
  @Test
  @DisplayName("Test getMostSpecificRanked(Collection); when ArrayList(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional FlowClassificationRuleResolver.getMostSpecificRanked(Collection)"})
  void testGetMostSpecificRanked_whenArrayList_thenReturnNotPresent() {
    // Arrange and Act
    Optional<FlowClassificationRuleVantagePoint> actualMostSpecificRanked =
        FlowClassificationRuleResolver.getMostSpecificRanked(new ArrayList<>());

    // Assert
    assertFalse(actualMostSpecificRanked.isPresent());
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference,
   * EntityReference, Long)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference,
   * EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName("Test resolve(EntityReference, EntityReference, EntityReference, Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"
  })
  void testResolve() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());
    FlowClassificationRuleResolver flowClassificationRuleResolver =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints);

    // Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>>
        actualResolveResult =
            flowClassificationRuleResolver.resolve(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                mock(EntityReference.class),
                mock(EntityReference.class),
                1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
    assertSame(actualResolveResult.v1, getResult2);
    assertSame(actualResolveResult.v2, getResult);
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference,
   * EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then return toList first value is {@code Classification Code}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference,
   * EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test resolve(EntityReference, EntityReference, EntityReference, Long); then return toList first value is 'Classification Code'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"
  })
  void testResolve_thenReturnToListFirstValueIsClassificationCode() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());
    FlowClassificationRuleResolver flowClassificationRuleResolver =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints);
    ImmutableEntityReference vantagePointOrgUnit =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReference vantagePointEntity =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();

    // Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>>
        actualResolveResult =
            flowClassificationRuleResolver.resolve(
                vantagePointOrgUnit,
                vantagePointEntity,
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(0);
    assertTrue(getResult instanceof AuthoritativenessRatingValue);
    assertEquals("Classification Code", ((AuthoritativenessRatingValue) getResult).value());
    assertSame(actualResolveResult.v1, getResult);
    assertSame(actualResolveResult.v2, toListResult.get(1));
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference,
   * EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then return toList first value is {@code DISCOURAGED}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference,
   * EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test resolve(EntityReference, EntityReference, EntityReference, Long); then return toList first value is 'DISCOURAGED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"
  })
  void testResolve_thenReturnToListFirstValueIsDiscouraged() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());
    FlowClassificationRuleResolver flowClassificationRuleResolver =
        new FlowClassificationRuleResolver(FlowDirection.OUTBOUND, flowClassificationVantagePoints);

    // Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>>
        actualResolveResult =
            flowClassificationRuleResolver.resolve(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                mock(EntityReference.class),
                mock(EntityReference.class),
                1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(0);
    assertTrue(getResult instanceof AuthoritativenessRatingValue);
    assertEquals("DISCOURAGED", ((AuthoritativenessRatingValue) getResult).value());
    assertSame(actualResolveResult.v1, getResult);
    assertSame(actualResolveResult.v2, toListResult.get(1));
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference,
   * EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then return toList first value is {@code NO_OPINION}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference,
   * EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test resolve(EntityReference, EntityReference, EntityReference, Long); then return toList first value is 'NO_OPINION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"
  })
  void testResolve_thenReturnToListFirstValueIsNoOpinion() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> flowClassificationVantagePoints =
        new ArrayList<>();

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
    flowClassificationVantagePoints.add(
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
            .build());
    FlowClassificationRuleResolver flowClassificationRuleResolver =
        new FlowClassificationRuleResolver(FlowDirection.INBOUND, flowClassificationVantagePoints);

    // Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>>
        actualResolveResult =
            flowClassificationRuleResolver.resolve(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build(),
                mock(EntityReference.class),
                mock(EntityReference.class),
                1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(0);
    assertTrue(getResult instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult).value());
    assertSame(actualResolveResult.v1, getResult);
    assertSame(actualResolveResult.v2, toListResult.get(1));
  }

  /**
   * Test {@link FlowClassificationRuleResolver#resolve(EntityReference, EntityReference,
   * EntityReference, Long)}.
   *
   * <ul>
   *   <li>Then toList second return {@link Optional}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleResolver#resolve(EntityReference,
   * EntityReference, EntityReference, Long)}
   */
  @Test
  @DisplayName(
      "Test resolve(EntityReference, EntityReference, EntityReference, Long); then toList second return Optional")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Tuple2 FlowClassificationRuleResolver.resolve(EntityReference, EntityReference, EntityReference, Long)"
  })
  void testResolve_thenToListSecondReturnOptional() {
    // Arrange and Act
    Tuple2<AuthoritativenessRatingValue, Optional<FlowClassificationRuleVantagePoint>>
        actualResolveResult =
            new FlowClassificationRuleResolver(FlowDirection.INBOUND, new ArrayList<>())
                .resolve(
                    mock(EntityReference.class),
                    mock(EntityReference.class),
                    mock(EntityReference.class),
                    1L);

    // Assert
    List<?> toListResult = actualResolveResult.toList();
    assertEquals(2, toListResult.size());
    Object getResult = toListResult.get(1);
    assertTrue(getResult instanceof Optional);
    Object getResult2 = toListResult.get(0);
    assertTrue(getResult2 instanceof AuthoritativenessRatingValue);
    assertEquals("NO_OPINION", ((AuthoritativenessRatingValue) getResult2).value());
    assertFalse(((Optional<Object>) getResult).isPresent());
    assertSame(actualResolveResult.v1, getResult2);
    assertSame(actualResolveResult.v2, getResult);
  }
}
