package org.finos.waltz.jobs.tools.lineage;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Optional;
import org.finos.waltz.jobs.tools.lineage.ImmutableRouteLookup.Builder;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.application.Application;
import org.finos.waltz.model.external_identifier.ExternalIdValue;
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
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllProcessingMessages(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_given42_whenArrayListAdd42() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllProcessingMessages(elements));
  }

  /**
   * Test Builder {@link Builder#addAllProcessingMessages(Iterable)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllProcessingMessages(Iterable); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.addAllProcessingMessages(elements));
  }

  /**
   * Test Builder {@link Builder#addAllProcessingMessages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllProcessingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllProcessingMessages(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllProcessingMessages(Iterable)"})
  void testBuilderAddAllProcessingMessages_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllProcessingMessages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllStrictRoutes(Iterable)}.
   * <p>
   * Method under test: {@link Builder#addAllStrictRoutes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllStrictRoutes(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllStrictRoutes(Iterable)"})
  void testBuilderAddAllStrictRoutes() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllStrictRoutes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addProcessingMessages(String)} with {@code element}.
   * <ul>
   *   <li>When {@code Element}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addProcessingMessages(String)}
   */
  @Test
  @DisplayName("Test Builder addProcessingMessages(String) with 'element'; when 'Element'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addProcessingMessages(String)"})
  void testBuilderAddProcessingMessagesWithElement_whenElement_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addProcessingMessages("Element"));
  }

  /**
   * Test Builder {@link Builder#addProcessingMessages(String[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addProcessingMessages(String[])}
   */
  @Test
  @DisplayName("Test Builder addProcessingMessages(String[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addProcessingMessages(String[])"})
  void testBuilderAddProcessingMessagesWithElements() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addProcessingMessages("Elements"));
  }

  /**
   * Test Builder {@link Builder#addStrictRoutes(Tuple3[])} with {@code elements}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addStrictRoutes(Tuple3[])}
   */
  @Test
  @DisplayName("Test Builder addStrictRoutes(Tuple3[]) with 'elements'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addStrictRoutes(Tuple3[])"})
  void testBuilderAddStrictRoutesWithElements_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addStrictRoutes());
  }

  /**
   * Test Builder {@link Builder#nonStrictRoute(Optional)} with {@code Optional}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#nonStrictRoute(Optional)}
   */
  @Test
  @DisplayName("Test Builder nonStrictRoute(Optional) with 'Optional'; when empty; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.nonStrictRoute(Optional)"})
  void testBuilderNonStrictRouteWithOptional_whenEmpty_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();
    Optional<? extends Tuple2<Graph<EntityReference, DataTypeEdge>, GraphPath<EntityReference, DataTypeEdge>>> nonStrictRoute = Optional
        .empty();

    // Act and Assert
    assertSame(builderResult, builderResult.nonStrictRoute(nonStrictRoute));
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); given '42'; when ArrayList() add '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_given42_whenArrayListAdd42() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("42");
    elements.add("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.processingMessages(elements));
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); given 'foo'; when ArrayList() add 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_givenFoo_whenArrayListAddFoo() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    ArrayList<String> elements = new ArrayList<>();
    elements.add("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.processingMessages(elements));
  }

  /**
   * Test Builder {@link Builder#processingMessages(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#processingMessages(Iterable)}
   */
  @Test
  @DisplayName("Test Builder processingMessages(Iterable); when ArrayList()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.processingMessages(Iterable)"})
  void testBuilderProcessingMessages_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.processingMessages(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#sourceApp(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#sourceApp(Optional)}
   */
  @Test
  @DisplayName("Test Builder sourceApp(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.sourceApp(Optional)"})
  void testBuilderSourceAppWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();
    Optional<? extends Application> sourceApp = Optional.of(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.sourceApp(sourceApp));
  }

  /**
   * Test Builder {@link Builder#source(ExternalIdValue)}.
   * <ul>
   *   <li>When {@link ExternalIdValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#source(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test Builder source(ExternalIdValue); when ExternalIdValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.source(ExternalIdValue)"})
  void testBuilderSource_whenExternalIdValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.source(ExternalIdValue.of("42")));
  }

  /**
   * Test Builder {@link Builder#strictRoutes(Iterable)}.
   * <p>
   * Method under test: {@link Builder#strictRoutes(Iterable)}
   */
  @Test
  @DisplayName("Test Builder strictRoutes(Iterable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.strictRoutes(Iterable)"})
  void testBuilderStrictRoutes() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.strictRoutes(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#targetApp(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#targetApp(Optional)}
   */
  @Test
  @DisplayName("Test Builder targetApp(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.targetApp(Optional)"})
  void testBuilderTargetAppWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();
    Optional<? extends Application> targetApp = Optional.of(mock(Application.class));

    // Act and Assert
    assertSame(builderResult, builderResult.targetApp(targetApp));
  }

  /**
   * Test Builder {@link Builder#target(ExternalIdValue)}.
   * <ul>
   *   <li>When {@link ExternalIdValue} with value is {@code 42}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#target(ExternalIdValue)}
   */
  @Test
  @DisplayName("Test Builder target(ExternalIdValue); when ExternalIdValue with value is '42'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.target(ExternalIdValue)"})
  void testBuilderTarget_whenExternalIdValueWithValueIs42_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRouteLookup.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.target(ExternalIdValue.of("42")));
  }
}
