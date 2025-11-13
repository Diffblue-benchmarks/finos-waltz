package org.finos.waltz.service.flow_classification_rule;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FlowDirection;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.MessageSeverity;
import org.finos.waltz.model.datatype.FlowDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType;
import org.finos.waltz.model.datatype.ImmutableFlowDataType.Builder;
import org.finos.waltz.model.entity_hierarchy.EntityHierarchy;
import org.finos.waltz.model.entity_hierarchy.ImmutableEntityHierarchy;
import org.finos.waltz.model.flow_classification_rule.FlowClassificationRuleVantagePoint;
import org.finos.waltz.model.flow_classification_rule.ImmutableFlowClassificationRuleVantagePoint;
import org.finos.waltz.model.rating.AuthoritativenessRatingValue;
import org.finos.waltz.service.flow_classification_rule.FlowClassificationRuleUtilities.MatchOutcome;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FlowClassificationRuleUtilitiesDiffblueTest {
  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ruleVantagePoints.add(
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
    HashSet<FlowDataType> population = new HashSet<>();
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints2() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ruleVantagePoints.add(
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

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult2 =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(1L)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult2 =
        ruleIdResult2.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ruleVantagePoints.add(
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
    HashSet<FlowDataType> population = new HashSet<>();
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints3() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints4() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();

    ImmutableFlowClassificationRuleVantagePoint.Builder ruleIdResult =
        ImmutableFlowClassificationRuleVantagePoint.builder()
            .classificationCode("Classification Code")
            .dataTypeId(null)
            .dataTypeRank(1)
            .message("Not all who wander are lost")
            .messageSeverity(MessageSeverity.NONE)
            .ruleId(1L);

    ImmutableFlowClassificationRuleVantagePoint.Builder subjectReferenceResult =
        ruleIdResult.subjectReference(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    ruleVantagePoints.add(
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
    HashSet<FlowDataType> population = new HashSet<>();
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints5() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();

    HashSet<FlowDataType> population = new HashSet<>();

    Builder outboundRuleIdResult =
        ImmutableFlowDataType.builder()
            .dtId(2L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult =
        outboundRuleIdResult
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult =
        sourceOuIdResult.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult =
        sourceOutboundRatingResult.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());

    Builder outboundRuleIdResult2 =
        ImmutableFlowDataType.builder()
            .dtId(1L)
            .inboundRuleId(1L)
            .lfId(1L)
            .lfdId(1L)
            .outboundRuleId(1L);

    Builder sourceOuIdResult2 =
        outboundRuleIdResult2
            .source(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .sourceOuId(1L);

    Builder sourceOutboundRatingResult2 =
        sourceOuIdResult2.sourceOutboundRating(AuthoritativenessRatingValue.of("42"));

    Builder targetResult2 =
        sourceOutboundRatingResult2.target(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());
    population.add(
        targetResult2
            .targetInboundRating(AuthoritativenessRatingValue.of("42"))
            .targetOuId(1L)
            .build());
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints_whenArrayList() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    HashSet<FlowDataType> population = new HashSet<>();
    ImmutableEntityHierarchy ouHierarchy = ImmutableEntityHierarchy.builder().build();
    ImmutableEntityHierarchy dtHierarchy = ImmutableEntityHierarchy.builder().build();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.INBOUND,
            ruleVantagePoints,
            population,
            ouHierarchy,
            dtHierarchy,
            new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }

  /**
   * Test {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection, List, Set,
   * EntityHierarchy, EntityHierarchy, Map)}.
   *
   * <ul>
   *   <li>When {@code OUTBOUND}.
   * </ul>
   *
   * <p>Method under test: {@link FlowClassificationRuleUtilities#applyVantagePoints(FlowDirection,
   * List, Set, EntityHierarchy, EntityHierarchy, Map)}
   */
  @Test
  @DisplayName(
      "Test applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map); when 'OUTBOUND'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map FlowClassificationRuleUtilities.applyVantagePoints(FlowDirection, List, Set, EntityHierarchy, EntityHierarchy, Map)"
  })
  void testApplyVantagePoints_whenOutbound() {
    // Arrange
    ArrayList<FlowClassificationRuleVantagePoint> ruleVantagePoints = new ArrayList<>();
    HashSet<FlowDataType> population = new HashSet<>();

    // Act
    Map<Long, Tuple2<Long, MatchOutcome>> actualApplyVantagePointsResult =
        FlowClassificationRuleUtilities.applyVantagePoints(
            FlowDirection.OUTBOUND, ruleVantagePoints, population, null, null, new HashMap<>());

    // Assert
    assertTrue(actualApplyVantagePointsResult.isEmpty());
  }
}
