package org.finos.waltz.model.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import org.finos.waltz.model.EntityReference;
import org.junit.jupiter.api.Test;

class ImmutableSurveyInstanceUserInvolvementDiffblueTest {
  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#addAllSurveyInstances(Iterable)}
   */
  @Test
  void testBuilderAddAllSurveyInstances() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllSurveyInstances(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#addSurveyInstances(SurveyInstanceInfo)}
   */
  @Test
  void testBuilderAddSurveyInstances() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#addSurveyInstances(SurveyInstanceInfo)}
   */
  @Test
  void testBuilderAddSurveyInstances2() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    ImmutableSurveyInstanceInfo.Json element = new ImmutableSurveyInstanceInfo.Json();
    element.setSurveyTemplateRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(element));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#addSurveyInstances(SurveyInstanceInfo[])}
   */
  @Test
  void testBuilderAddSurveyInstances3() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(new ImmutableSurveyInstanceInfo.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#addSurveyInstances(SurveyInstanceInfo[])}
   */
  @Test
  void testBuilderAddSurveyInstances4() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    ImmutableSurveyInstanceInfo.Json json = new ImmutableSurveyInstanceInfo.Json();
    json.setSurveyTemplateRef(mock(EntityReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.addSurveyInstances(json));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(new HashSet<>());
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    ImmutableSurveyInstanceUserInvolvement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    assertEquals(SurveyInvolvementKind.OWNER, builderResult.build().surveyInvolvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenThrow(new IllegalStateException("instance"));
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#from(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(new ImmutableSurveyInstanceInfo.Json());
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(surveyInstanceInfoSet);
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    ImmutableSurveyInstanceUserInvolvement.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    ImmutableSurveyInstanceUserInvolvement buildResult = builderResult.build();
    assertEquals(1, buildResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, buildResult.surveyInvolvementKind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#surveyInstances(Iterable)}
   */
  @Test
  void testBuilderSurveyInstances() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.surveyInstances(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#surveyInvolvementKind(SurveyInvolvementKind)}
   */
  @Test
  void testBuilderSurveyInvolvementKind() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();

    // Act
    ImmutableSurveyInstanceUserInvolvement.Builder actualSurveyInvolvementKindResult = builderResult
        .surveyInvolvementKind(SurveyInvolvementKind.OWNER);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, builderResult.build().surveyInvolvementKind());
    assertSame(builderResult, actualSurveyInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Builder#surveyInvolvementKind(SurveyInvolvementKind)}
   */
  @Test
  void testBuilderSurveyInvolvementKind2() {
    // Arrange
    ImmutableSurveyInstanceInfo.Json element = new ImmutableSurveyInstanceInfo.Json();
    element.setSurveyTemplateRef(mock(EntityReference.class));
    ImmutableSurveyInstanceUserInvolvement.Builder builderResult = ImmutableSurveyInstanceUserInvolvement.builder();
    builderResult.addSurveyInstances(element);

    // Act
    ImmutableSurveyInstanceUserInvolvement.Builder actualSurveyInvolvementKindResult = builderResult
        .surveyInvolvementKind(SurveyInvolvementKind.OWNER);

    // Assert
    ImmutableSurveyInstanceUserInvolvement buildResult = builderResult.build();
    assertEquals(1, buildResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, buildResult.surveyInvolvementKind());
    assertSame(builderResult, actualSurveyInvolvementKindResult);
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#copyOf(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(new HashSet<>());
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualCopyOfResult = ImmutableSurveyInstanceUserInvolvement.copyOf(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    assertEquals(SurveyInvolvementKind.OWNER, actualCopyOfResult.surveyInvolvementKind());
    assertTrue(actualCopyOfResult.surveyInstances().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#copyOf(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(new ImmutableSurveyInstanceInfo.Json());
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(surveyInstanceInfoSet);
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualCopyOfResult = ImmutableSurveyInstanceUserInvolvement.copyOf(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    assertEquals(1, actualCopyOfResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, actualCopyOfResult.surveyInvolvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#copyOf(SurveyInstanceUserInvolvement)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    HashSet<SurveyInstanceInfo> surveyInstanceInfoSet = new HashSet<>();
    surveyInstanceInfoSet.add(new ImmutableSurveyInstanceInfo.Json());
    surveyInstanceInfoSet.add(new ImmutableSurveyInstanceInfo.Json());
    SurveyInstanceUserInvolvement instance = mock(SurveyInstanceUserInvolvement.class);
    when(instance.surveyInstances()).thenReturn(surveyInstanceInfoSet);
    when(instance.surveyInvolvementKind()).thenReturn(SurveyInvolvementKind.OWNER);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualCopyOfResult = ImmutableSurveyInstanceUserInvolvement.copyOf(instance);

    // Assert
    verify(instance).surveyInstances();
    verify(instance).surveyInvolvementKind();
    assertEquals(SurveyInvolvementKind.OWNER, actualCopyOfResult.surveyInvolvementKind());
    assertEquals(surveyInstanceInfoSet, actualCopyOfResult.surveyInstances());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#fromJson(ImmutableSurveyInstanceUserInvolvement.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableSurveyInstanceUserInvolvement.Json json = new ImmutableSurveyInstanceUserInvolvement.Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(null);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult = ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
    assertTrue(actualFromJsonResult.surveyInstances().isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#fromJson(ImmutableSurveyInstanceUserInvolvement.Json)}
   */
  @Test
  void testFromJson2() {
    // Arrange
    LinkedHashSet<SurveyInstanceInfo> surveyInstances = new LinkedHashSet<>();
    surveyInstances.add(new ImmutableSurveyInstanceInfo.Json());

    ImmutableSurveyInstanceUserInvolvement.Json json = new ImmutableSurveyInstanceUserInvolvement.Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(surveyInstances);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult = ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(1, actualFromJsonResult.surveyInstances().size());
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement#fromJson(ImmutableSurveyInstanceUserInvolvement.Json)}
   */
  @Test
  void testFromJson3() {
    // Arrange
    LinkedHashSet<SurveyInstanceInfo> surveyInstances = new LinkedHashSet<>();
    surveyInstances.add(new ImmutableSurveyInstanceInfo.Json());
    surveyInstances.add(new ImmutableSurveyInstanceInfo.Json());

    ImmutableSurveyInstanceUserInvolvement.Json json = new ImmutableSurveyInstanceUserInvolvement.Json();
    json.setSurveyInvolvementKind(SurveyInvolvementKind.OWNER);
    json.setSurveyInstances(surveyInstances);

    // Act
    ImmutableSurveyInstanceUserInvolvement actualFromJsonResult = ImmutableSurveyInstanceUserInvolvement.fromJson(json);

    // Assert
    assertEquals(SurveyInvolvementKind.OWNER, actualFromJsonResult.surveyInvolvementKind());
    assertEquals(surveyInstances, actualFromJsonResult.surveyInstances());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableSurveyInstanceUserInvolvement.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableSurveyInstanceUserInvolvement.Json actualJson = new ImmutableSurveyInstanceUserInvolvement.Json();

    // Assert
    assertNull(actualJson.surveyInvolvementKind);
    assertTrue(actualJson.surveyInstances.isEmpty());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Json#surveyInstances()}
   */
  @Test
  void testJsonSurveyInstances() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceUserInvolvement.Json()).surveyInstances());
  }

  /**
   * Method under test:
   * {@link ImmutableSurveyInstanceUserInvolvement.Json#surveyInvolvementKind()}
   */
  @Test
  void testJsonSurveyInvolvementKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableSurveyInstanceUserInvolvement.Json()).surveyInvolvementKind());
  }
}
