package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceUserInvolvement.Builder;
import org.finos.waltz.model.survey.ImmutableSurveyInstanceUserInvolvement.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceUserInvolvementDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllSurveyInstances(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addAllSurveyInstances(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllSurveyInstances(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addAllSurveyInstances(Iterable)"})
  void testBuilderAddAllSurveyInstances_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSurveyInstances(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#addSurveyInstances(SurveyInstanceInfo)} with {@code element}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstanceInfo.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSurveyInstances(SurveyInstanceInfo)}
   */
  @Test
  @DisplayName("Test Builder addSurveyInstances(SurveyInstanceInfo) with 'element'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSurveyInstances(SurveyInstanceInfo)"})
  void testBuilderAddSurveyInstancesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json()));
  }

  /**
   * Test Builder {@link Builder#addSurveyInstances(SurveyInstanceInfo[])} with {@code elements}.
   * <ul>
   *   <li>When {@link ImmutableSurveyInstanceInfo.Json} (default constructor).</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#addSurveyInstances(SurveyInstanceInfo[])}
   */
  @Test
  @DisplayName("Test Builder addSurveyInstances(SurveyInstanceInfo[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.addSurveyInstances(SurveyInstanceInfo[])"})
  void testBuilderAddSurveyInstancesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json()));
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceUserInvolvement)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@link ImmutableSurveyInstanceInfo.Json} (default constructor).</li>
   *   <li>Then builder build surveyInstances size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceUserInvolvement); given HashSet() add Json (default constructor); then builder build surveyInstances size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceUserInvolvement)"})
  void testBuilderFrom_givenHashSetAddJson_thenBuilderBuildSurveyInstancesSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(new ImmutableSurveyInstanceInfo.Json());
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(surveyInstanceInfoSet);
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    ImmutableSurveyInstanceUserInvolvement buildResult = builderResult.build();
    assertEquals(1, buildResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, buildResult.surveyInvolvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceUserInvolvement)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then builder build surveyInvolvementKind is {@code OWNER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceUserInvolvement); given HashSet(); then builder build surveyInvolvementKind is 'OWNER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceUserInvolvement)"})
  void testBuilderFrom_givenHashSet_thenBuilderBuildSurveyInvolvementKindIsOwner() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(new HashSet<>());
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    assertEquals(SurveyInvolvementKind.OWNER, builderResult.build().surveyInvolvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(SurveyInstanceUserInvolvement)}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  @DisplayName("Test Builder from(SurveyInstanceUserInvolvement); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(SurveyInstanceUserInvolvement)"})
  void testBuilderFrom_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
  }

  /**
   * Test Builder {@link Builder#surveyInstances(Iterable)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#surveyInstances(Iterable)}
   */
  @Test
  @DisplayName("Test Builder surveyInstances(Iterable); when ArrayList(); then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInstances(Iterable)"})
  void testBuilderSurveyInstances_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstances(new ArrayList<>()));
  }

  /**
   * Test Builder {@link Builder#surveyInvolvementKind(SurveyInvolvementKind)}.
   * <p>
   * Method under test: {@link Builder#surveyInvolvementKind(SurveyInvolvementKind)}
   */
  @Test
  @DisplayName("Test Builder surveyInvolvementKind(SurveyInvolvementKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.surveyInvolvementKind(SurveyInvolvementKind)"})
  void testBuilderSurveyInvolvementKind() {
    // Arrange
    Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    Builder actualSurveyInvolvementKindResult = builderResult.surveyInvolvementKind(SurveyInvolvementKind.OWNER);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, builderResult.build().surveyInvolvementKind());
    assertSame(builderResult, actualSurveyInvolvementKindResult);
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
    assertNull(actualJson.surveyInvolvementKind);
    assertTrue(actualJson.surveyInstances.isEmpty());
  }

  /**
   * Test Json {@link Json#surveyInstances()}.
   * <p>
   * Method under test: {@link Json#surveyInstances()}
   */
  @Test
  @DisplayName("Test Json surveyInstances()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set Json.surveyInstances()"})
  void testJsonSurveyInstances() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyInstances());
  }

  /**
   * Test Json {@link Json#surveyInvolvementKind()}.
   * <p>
   * Method under test: {@link Json#surveyInvolvementKind()}
   */
  @Test
  @DisplayName("Test Json surveyInvolvementKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"SurveyInvolvementKind Json.surveyInvolvementKind()"})
  void testJsonSurveyInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).surveyInvolvementKind());
  }
}
