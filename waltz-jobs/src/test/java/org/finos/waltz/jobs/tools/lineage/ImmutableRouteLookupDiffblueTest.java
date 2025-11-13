package org.finos.waltz.jobs.tools.lineage;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.jobs.tools.lineage.ImmutableRouteLookup.Builder;
import org.finos.waltz.model.Criticality;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.application.ApplicationKind;
import org.finos.waltz.model.application.ImmutableApplication;
import org.finos.waltz.model.application.LifecyclePhase;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
import org.finos.waltz.model.rating.RagRating;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRouteLookupDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllProcessingMessages(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllProcessingMessages(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_given42_whenArrayListAdd42() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act
    Builder actualAddAllProcessingMessagesResult = builderResult.addAllProcessingMessages(elements);

    // Assert
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#addAllProcessingMessages(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllProcessingMessages(Iterable); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act
    Builder actualAddAllProcessingMessagesResult = builderResult.addAllProcessingMessages(elements);

    // Assert
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#addAllProcessingMessages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllProcessingMessages(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualAddAllProcessingMessagesResult =
        builderResult.addAllProcessingMessages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#addAllStrictRoutes(Iterable)}.
   *
   * <p>Method under test: {@link Builder#addAllStrictRoutes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStrictRoutes(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllStrictRoutes(Iterable)"})
  void testBuilderAddAllStrictRoutes() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualAddAllStrictRoutesResult = builderResult.addAllStrictRoutes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllStrictRoutesResult);
  }

  /**
   * Test Builder {@link Builder#addProcessingMessages(String)} with {@code element}.
   *
   * <ul>
   *   <li>When {@code Element}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addProcessingMessages(String)}
   */
  @Test
  @DisplayName(
      "Test Builder addProcessingMessages(String) with 'element'; when 'Element'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addProcessingMessages(String)"})
  void testBuilderAddProcessingMessagesWithElement_whenElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualAddProcessingMessagesResult = builderResult.addProcessingMessages("Element");

    // Assert
    assertSame(builderResult, actualAddProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#addProcessingMessages(String[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addProcessingMessages(String[])}
   */
  @Test
  @DisplayName("Test Builder addProcessingMessages(String[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addProcessingMessages(String[])"})
  void testBuilderAddProcessingMessagesWithElements() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualAddProcessingMessagesResult = builderResult.addProcessingMessages("Elements");

    // Assert
    assertSame(builderResult, actualAddProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#addStrictRoutes(Tuple3[])} with {@code elements}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addStrictRoutes(Tuple3[])}
   */
  @Test
  @DisplayName("Test Builder addStrictRoutes(Tuple3[]) with 'elements'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addStrictRoutes(Tuple3[])"})
  void testBuilderAddStrictRoutesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualAddStrictRoutesResult = builderResult.addStrictRoutes();

    // Assert
    assertSame(builderResult, actualAddStrictRoutesResult);
  }

  /**
   * Test Builder {@link Builder#nonStrictRoute(Optional)} with {@code Optional}.
   *
   * <ul>
   *   <li>When empty.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#nonStrictRoute(Optional)}
   */
  @Test
  @DisplayName(
      "Test Builder nonStrictRoute(Optional) with 'Optional'; when empty; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.nonStrictRoute(Optional)"})
  void testBuilderNonStrictRouteWithOptional_whenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();
    Optional<
            ? extends
                Tuple2<
                    Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>>>
        nonStrictRoute = Optional.empty();

    // Act
    Builder actualNonStrictRouteResult = builderResult.nonStrictRoute(nonStrictRoute);

    // Assert
    assertSame(builderResult, actualNonStrictRouteResult);
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_given42_whenArrayListAdd42() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act
    Builder actualProcessingMessagesResult = builderResult.processingMessages(elements);

    // Assert
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); given 'foo'; when ArrayList() add 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act
    Builder actualProcessingMessagesResult = builderResult.processingMessages(elements);

    // Assert
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualProcessingMessagesResult = builderResult.processingMessages(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualProcessingMessagesResult);
  }

  /**
   * Test Builder {@link Builder#sourceApp(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#sourceApp(Optional)}
   */
  @Test
  @DisplayName("Test Builder sourceApp(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.sourceApp(Optional)"})
  void testBuilderSourceAppWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends Application> sourceApp = Optional.of(immutableApplication);

    // Act
    Builder actualSourceAppResult = builderResult.sourceApp(sourceApp);

    // Assert
    assertSame(builderResult, actualSourceAppResult);
  }

  /**
   * Test Builder {@link Builder#source(ExternalIdValue)}.
   *
   * <ul>
   *   <li>When {@link ExternalIdValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#source(ExternalIdValue)}
   */
  @Test
  @DisplayName(
      "Test Builder source(ExternalIdValue); when ExternalIdValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.source(ExternalIdValue)"})
  void testBuilderSource_whenExternalIdValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualSourceResult = builderResult.source(ExternalIdValue.of("42"));

    // Assert
    assertSame(builderResult, actualSourceResult);
  }

  /**
   * Test Builder {@link Builder#strictRoutes(Iterable)}.
   *
   * <p>Method under test: {@link Builder#strictRoutes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder strictRoutes(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.strictRoutes(Iterable)"})
  void testBuilderStrictRoutes() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualStrictRoutesResult = builderResult.strictRoutes(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualStrictRoutesResult);
  }

  /**
   * Test Builder {@link Builder#targetApp(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#targetApp(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetApp(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.targetApp(Optional)"})
  void testBuilderTargetAppWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ImmutableApplication.Builder applicationKindResult =
        ImmutableApplication.builder()
            .actualRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .applicationKind(ApplicationKind.IN_HOUSE);
    Optional<? extends ExternalIdValue> assetCode = Optional.of(ExternalIdValue.of("42"));

    ImmutableApplication.Builder overallRatingResult =
        applicationKindResult
            .assetCode(assetCode)
            .businessCriticality(Criticality.LOW)
            .commissionDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .id(1L)
            .kind(EntityKind.ALL)
            .lifecyclePhase(LifecyclePhase.PRODUCTION)
            .name("Name")
            .organisationalUnitId(1L)
            .overallRating(RagRating.R);
    Optional<? extends ExternalIdValue> parentAssetCode = Optional.of(ExternalIdValue.of("42"));
    ImmutableApplication immutableApplication =
        overallRatingResult
            .parentAssetCode(parentAssetCode)
            .plannedRetirementDate(LocalDate.of(1970, 1, 1).atStartOfDay())
            .provenance("Provenance")
            .build();
    Optional<? extends Application> targetApp = Optional.of(immutableApplication);

    // Act
    Builder actualTargetAppResult = builderResult.targetApp(targetApp);

    // Assert
    assertSame(builderResult, actualTargetAppResult);
  }

  /**
   * Test Builder {@link Builder#target(ExternalIdValue)}.
   *
   * <ul>
   *   <li>When {@link ExternalIdValue} with value is {@code 42}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#target(ExternalIdValue)}
   */
  @Test
  @DisplayName(
      "Test Builder target(ExternalIdValue); when ExternalIdValue with value is '42'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.target(ExternalIdValue)"})
  void testBuilderTarget_whenExternalIdValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act
    Builder actualTargetResult = builderResult.target(ExternalIdValue.of("42"));

    // Assert
    assertSame(builderResult, actualTargetResult);
  }
}
