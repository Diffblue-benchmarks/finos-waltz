package org.finos.waltz.model.legal_entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipView.Builder;
import org.finos.waltz.model.legal_entity.ImmutableLegalEntityRelationshipView.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableLegalEntityRelationshipViewDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllAssessmentHeaders(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllAssessmentHeaders(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllAssessmentHeaders(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllAssessmentHeaders(Iterable)"})
  void testBuilderAddAllAssessmentHeaders_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllAssessmentHeaders(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAllRows(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllRows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllRows(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllRows(Iterable)"})
  void testBuilderAddAllRows_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRows(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addAssessmentHeaders(EntityReference)} with {@code element}.
   * <p>
   * Method under test: {@link Builder#addAssessmentHeaders(EntityReference)}
   */
  @Test
  @DisplayName("Test Builder addAssessmentHeaders(EntityReference) with 'element'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentHeaders(EntityReference)"})
  void testBuilderAddAssessmentHeadersWithElement() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    Builder actualAddAssessmentHeadersResult = builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#addAssessmentHeaders(EntityReference[])} with {@code elements}.
   * <p>
   * Method under test: {@link Builder#addAssessmentHeaders(EntityReference[])}
   */
  @Test
  @DisplayName("Test Builder addAssessmentHeaders(EntityReference[]) with 'elements'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAssessmentHeaders(EntityReference[])"})
  void testBuilderAddAssessmentHeadersWithElements() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    Builder actualAddAssessmentHeadersResult = builderResult.addAssessmentHeaders(mock(EntityReference.class));

    // Assert
    assertEquals(1, builderResult.build().assessmentHeaders().size());
    assertSame(builderResult, actualAddAssessmentHeadersResult);
  }

  /**
   * Test Builder {@link Builder#addRows(LegalEntityRelationshipViewRow)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then builder build rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRows(LegalEntityRelationshipViewRow)}
   */
  @Test
  @DisplayName("Test Builder addRows(LegalEntityRelationshipViewRow) with 'element'; when Json (default constructor); then builder build rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRows(LegalEntityRelationshipViewRow)"})
  void testBuilderAddRowsWithElement_whenJson_thenBuilderBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#addRows(LegalEntityRelationshipViewRow[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then builder build rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addRows(LegalEntityRelationshipViewRow[])}
   */
  @Test
  @DisplayName("Test Builder addRows(LegalEntityRelationshipViewRow[]) with 'elements'; when Json (default constructor); then builder build rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addRows(LegalEntityRelationshipViewRow[])"})
  void testBuilderAddRowsWithElements_whenJson_thenBuilderBuildRowsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act
    Builder actualAddRowsResult = builderResult.addRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, builderResult.build().rows().size());
    assertSame(builderResult, actualAddRowsResult);
  }

  /**
   * Test Builder {@link Builder#assessmentHeaders(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#assessmentHeaders(Iterable)}
   */
  @Test
  @DisplayName("Test Builder assessmentHeaders(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.assessmentHeaders(Iterable)"})
  void testBuilderAssessmentHeaders_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.assessmentHeaders(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#build()}.
   * <p>
   * Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView Builder.build()"})
  void testBuilderBuild() {
    // Arrange, Act and Assert
    assertTrue(ImmutableLegalEntityRelationshipView.builder().build().assessmentHeaders().isEmpty());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipView)}.
   * <ul>
   *   <li>Given {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>When builder addRows {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipView); given Json (default constructor); when builder addRows Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipView)"})
  void testBuilderFrom_givenJson_whenBuilderAddRowsJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    Builder builderResult2 = ImmutableLegalEntityRelationshipView.builder();
    builderResult2.addRows(new ImmutableLegalEntityRelationshipViewRow.Json());
    builderResult2.addAssessmentHeaders(mock(EntityReference.class));
    ImmutableLegalEntityRelationshipView instance = builderResult2.build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    assertEquals(instance, builderResult.build());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipView)}.
   * <ul>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipView); then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipView)"})
  void testBuilderFrom_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    Builder builderResult2 = ImmutableLegalEntityRelationshipView.builder();
    builderResult2.addAssessmentHeaders(mock(EntityReference.class));
    ImmutableLegalEntityRelationshipView instance = builderResult2.build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#from(LegalEntityRelationshipView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return build is builder build.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(LegalEntityRelationshipView)}
   */
  @Test
  @DisplayName("Test Builder from(LegalEntityRelationshipView); when builder build; then return build is builder build")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(LegalEntityRelationshipView)"})
  void testBuilderFrom_whenBuilderBuild_thenReturnBuildIsBuilderBuild() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    ImmutableLegalEntityRelationshipView instance = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertEquals(instance, builderResult.from(instance).build());
    assertEquals(instance, builderResult.build());
  }

  /**
   * Test Builder {@link Builder#rows(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#rows(Iterable)}
   */
  @Test
  @DisplayName("Test Builder rows(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rows(Iterable)"})
  void testBuilderRows_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rows(new ArrayList<>()));
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}.
   * <ul>
   *   <li>When builder build.</li>
   *   <li>Then return assessmentHeaders Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#copyOf(LegalEntityRelationshipView)}
   */
  @Test
  @DisplayName("Test copyOf(LegalEntityRelationshipView); when builder build; then return assessmentHeaders Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.copyOf(LegalEntityRelationshipView)"})
  void testCopyOf_whenBuilderBuild_thenReturnAssessmentHeadersEmpty() {
    // Arrange
    ImmutableLegalEntityRelationshipView instance = ImmutableLegalEntityRelationshipView.builder().build();

    // Act
    ImmutableLegalEntityRelationshipView actualCopyOfResult = ImmutableLegalEntityRelationshipView.copyOf(instance);

    // Assert
    Set<EntityReference> assessmentHeadersResult = actualCopyOfResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualCopyOfResult.rows());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}, and {@link ImmutableLegalEntityRelationshipView#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipView#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();
    ImmutableLegalEntityRelationshipView buildResult2 = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}, and {@link ImmutableLegalEntityRelationshipView#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipView#equals(Object)}
   *   <li>{@link ImmutableLegalEntityRelationshipView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addAssessmentHeaders(mock(EntityReference.class));
    ImmutableLegalEntityRelationshipView buildResult = builderResult.build();
    ImmutableLegalEntityRelationshipView buildResult2 = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableLegalEntityRelationshipView.builder();
    builderResult.addRows(new ImmutableLegalEntityRelationshipViewRow.Json());
    ImmutableLegalEntityRelationshipView buildResult = builderResult.build();
    ImmutableLegalEntityRelationshipView buildResult2 = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImmutableLegalEntityRelationshipView.equals(Object)",
      "int ImmutableLegalEntityRelationshipView.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImmutableLegalEntityRelationshipView");
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then return rows is {@link LinkedHashSet#LinkedHashSet()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return rows is LinkedHashSet()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRowsIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewRow> rows = new LinkedHashSet<>();
    rows.add(new ImmutableLegalEntityRelationshipViewRow.Json());
    rows.add(new ImmutableLegalEntityRelationshipViewRow.Json());

    Json json = new Json();
    json.setAssessmentHeaders(null);
    json.setRows(rows);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentHeaders().isEmpty());
    assertEquals(rows, actualFromJsonResult.rows());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@link LinkedHashSet#LinkedHashSet()} add {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then return rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given LinkedHashSet() add Json (default constructor); then return rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.fromJson(Json)"})
  void testFromJson_givenLinkedHashSetAddJson_thenReturnRowsSizeIsOne() {
    // Arrange
    LinkedHashSet<LegalEntityRelationshipViewRow> rows = new LinkedHashSet<>();
    rows.add(new ImmutableLegalEntityRelationshipViewRow.Json());

    Json json = new Json();
    json.setAssessmentHeaders(null);
    json.setRows(rows);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.rows().size());
    assertTrue(actualFromJsonResult.assessmentHeaders().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Json} (default constructor) Rows is {@code null}.</li>
   *   <li>Then return rows is assessmentHeaders.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given 'null'; when Json (default constructor) Rows is 'null'; then return rows is assessmentHeaders")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.fromJson(Json)"})
  void testFromJson_givenNull_whenJsonRowsIsNull_thenReturnRowsIsAssessmentHeaders() {
    // Arrange
    Json json = new Json();
    json.setAssessmentHeaders(null);
    json.setRows(null);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    Set<EntityReference> assessmentHeadersResult = actualFromJsonResult.assessmentHeaders();
    assertTrue(assessmentHeadersResult.isEmpty());
    assertSame(assessmentHeadersResult, actualFromJsonResult.rows());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}.
   * <ul>
   *   <li>Then return assessmentHeaders size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return assessmentHeaders size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.fromJson(Json)"})
  void testFromJson_thenReturnAssessmentHeadersSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> assessmentHeaders = new LinkedHashSet<>();
    assessmentHeaders.add(mock(EntityReference.class));

    Json json = new Json();
    json.setAssessmentHeaders(assessmentHeaders);
    json.setRows(null);

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.assessmentHeaders().size());
    assertTrue(actualFromJsonResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}.
   * <ul>
   *   <li>When {@link Json} (default constructor).</li>
   *   <li>Then return rows is {@link Json} (default constructor) {@link Json#rows}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); when Json (default constructor); then return rows is Json (default constructor) rows")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.fromJson(Json)"})
  void testFromJson_whenJson_thenReturnRowsIsJsonRows() {
    // Arrange
    Json json = new Json();

    // Act
    ImmutableLegalEntityRelationshipView actualFromJsonResult = ImmutableLegalEntityRelationshipView.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.assessmentHeaders().isEmpty());
    Set<LegalEntityRelationshipViewRow> expectedRowsResult = json.rows;
    assertSame(expectedRowsResult, actualFromJsonResult.rows());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableLegalEntityRelationshipView#toString()}
   *   <li>{@link ImmutableLegalEntityRelationshipView#assessmentHeaders()}
   *   <li>{@link ImmutableLegalEntityRelationshipView#rows()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set ImmutableLegalEntityRelationshipView.assessmentHeaders()",
      "Set ImmutableLegalEntityRelationshipView.rows()", "String ImmutableLegalEntityRelationshipView.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act
    String actualToStringResult = buildResult.toString();
    Set<EntityReference> actualAssessmentHeadersResult = buildResult.assessmentHeaders();
    Set<LegalEntityRelationshipViewRow> actualRowsResult = buildResult.rows();

    // Assert
    assertEquals("LegalEntityRelationshipView{assessmentHeaders=[], rows=[]}", actualToStringResult);
    assertTrue(actualAssessmentHeadersResult.isEmpty());
    assertSame(actualAssessmentHeadersResult, actualRowsResult);
  }

  /**
   * Test Json {@link Json#assessmentHeaders()}.
   * <p>
   * Method under test: {@link Json#assessmentHeaders()}
   */
  @Test
  @DisplayName("Test Json assessmentHeaders()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.assessmentHeaders()"})
  void testJsonAssessmentHeaders() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).assessmentHeaders());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertTrue(actualJson.assessmentHeaders.isEmpty());
    assertTrue(actualJson.rows.isEmpty());
  }

  /**
   * Test Json {@link Json#rows()}.
   * <p>
   * Method under test: {@link Json#rows()}
   */
  @Test
  @DisplayName("Test Json rows()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set Json.rows()"})
  void testJsonRows() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rows());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#withAssessmentHeaders(EntityReference[])} with {@code EntityReference[]}.
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#withAssessmentHeaders(EntityReference[])}
   */
  @Test
  @DisplayName("Test withAssessmentHeaders(EntityReference[]) with 'EntityReference[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.withAssessmentHeaders(EntityReference[])"})
  void testWithAssessmentHeadersWithEntityReference() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act
    ImmutableLegalEntityRelationshipView actualWithAssessmentHeadersResult = buildResult
        .withAssessmentHeaders(mock(EntityReference.class));

    // Assert
    assertEquals(1, actualWithAssessmentHeadersResult.assessmentHeaders().size());
    assertTrue(actualWithAssessmentHeadersResult.rows().isEmpty());
  }

  /**
   * Test {@link ImmutableLegalEntityRelationshipView#withRows(LegalEntityRelationshipViewRow[])} with {@code LegalEntityRelationshipViewRow[]}.
   * <ul>
   *   <li>When {@link ImmutableLegalEntityRelationshipViewRow.Json} (default constructor).</li>
   *   <li>Then return rows size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImmutableLegalEntityRelationshipView#withRows(LegalEntityRelationshipViewRow[])}
   */
  @Test
  @DisplayName("Test withRows(LegalEntityRelationshipViewRow[]) with 'LegalEntityRelationshipViewRow[]'; when Json (default constructor); then return rows size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "ImmutableLegalEntityRelationshipView ImmutableLegalEntityRelationshipView.withRows(LegalEntityRelationshipViewRow[])"})
  void testWithRowsWithLegalEntityRelationshipViewRow_whenJson_thenReturnRowsSizeIsOne() {
    // Arrange
    ImmutableLegalEntityRelationshipView buildResult = ImmutableLegalEntityRelationshipView.builder().build();

    // Act
    ImmutableLegalEntityRelationshipView actualWithRowsResult = buildResult
        .withRows(new ImmutableLegalEntityRelationshipViewRow.Json());

    // Assert
    assertEquals(1, actualWithRowsResult.rows().size());
    assertTrue(actualWithRowsResult.assessmentHeaders().isEmpty());
  }
}
